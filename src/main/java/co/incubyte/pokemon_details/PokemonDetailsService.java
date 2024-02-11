package co.incubyte.pokemon_details;

import de.huxhorn.sulky.ulid.ULID;
import exceptions.EntityNotFoundException;
import jakarta.inject.Singleton;

@Singleton
public class PokemonDetailsService {
  private final PokemonDetailsRepository pokemonDetailsRepository;

  public PokemonDetailsService(PokemonDetailsRepository pokemonDetailsRepository) {
    this.pokemonDetailsRepository = pokemonDetailsRepository;
  }

  public PokemonDetails getPokemonDetails(String id) {
    return pokemonDetailsRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Pokemon with " + id + " not found"));
  }

  public PokemonDetails addPokemonDetails(PokemonDetailsRequest pokemonRequest) {
    PokemonDetails pokemonDetails =
        PokemonDetailsBuilder.buildPokemonDetails()
            .withId(new ULID().nextULID())
            .withName(pokemonRequest.name())
            .withUrl(pokemonRequest.url())
            .withWeight(pokemonRequest.weight())
            .withHeight(pokemonRequest.height())
            .withAbilityDetails(pokemonRequest.abilityDetails())
            .build();
    return pokemonDetailsRepository.save(pokemonDetails);
  }
}
