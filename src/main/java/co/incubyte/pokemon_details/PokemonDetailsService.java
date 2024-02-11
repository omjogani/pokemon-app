package co.incubyte.pokemon_details;

import co.incubyte.pokemon_details.ability_details.AbilityDetails;
import co.incubyte.pokemon_details.ability_details.ability.Ability;
import de.huxhorn.sulky.ulid.ULID;
import exceptions.EntityNotFoundException;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

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
//    List<AbilityDetails> listOfAbilityDetails = new ArrayList<>();
//    System.out.println(pokemonRequest.abilities());
//    System.out.println(pokemonRequest.abilities().stream().findFirst());
//    for (var abilityDetail : pokemonRequest.abilities()) {
//      AbilityDetails abilityDetails = new AbilityDetails();
//      abilityDetails.setId(new ULID().nextULID());
//      abilityDetails.setHidden(abilityDetail.isHidden());
//      abilityDetails.setAbility(
//          new Ability(
//              new ULID().nextULID(),
//              "WATER",
//              "abilityDetails.getAbility().getUrl()"));
//      listOfAbilityDetails.add(abilityDetails);
//    }
    PokemonDetails pokemonDetails =
        PokemonDetailsBuilder.buildPokemonDetails()
            .withId(new ULID().nextULID())
            .withName(pokemonRequest.name())
            .withUrl(pokemonRequest.url())
            .withWeight(pokemonRequest.weight())
            .withHeight(pokemonRequest.height())
            .build();
    return pokemonDetailsRepository.save(pokemonDetails);
  }
}
