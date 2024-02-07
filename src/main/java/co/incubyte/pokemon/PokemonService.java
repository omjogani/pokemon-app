package co.incubyte.pokemon;

import de.huxhorn.sulky.ulid.ULID;
import exceptions.EntityNotFoundException;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class PokemonService {

  PokemonRepository pokemonRepository;

  public PokemonService(PokemonRepository pokemonRepository) {
    this.pokemonRepository = pokemonRepository;
  }

  public List<Pokemon> getAllPokemons() {
    return pokemonRepository.findAll();
  }

  public Pokemon getPokemonById(String pokemonId) {
    return pokemonRepository
        .findById(pokemonId)
        .orElseThrow(
            () -> new EntityNotFoundException("Pokemon with ID: " + pokemonId + " is not found!"));
  }

  public Pokemon addPokemon(PokemonRequest pokemonRequest) {
    Pokemon pokemon =
        PokemonBuilder.buildPokemon()
            .withId(new ULID().nextULID())
            .withName(pokemonRequest.name())
            .withUrl(pokemonRequest.url())
            .build();

    return pokemonRepository.save(pokemon);
  }
}
