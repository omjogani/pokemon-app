package co.incubyte.pokemon_details;

import co.incubyte.pokemon_details.ability_details.AbilityDetails;
import co.incubyte.pokemon_details.ability_details.AbilityDetailsService;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/pokemon-details")
public class PokemonDetailsController {

  PokemonDetailsService pokemonDetailsService;
  AbilityDetailsService abilityDetailsService;

  public PokemonDetailsController(
      PokemonDetailsService pokemonDetailsService, AbilityDetailsService abilityDetailsService) {
    this.pokemonDetailsService = pokemonDetailsService;
    this.abilityDetailsService = abilityDetailsService;
  }

  @Get("/{id}")
  public PokemonDetailsResponse getPokemonDetails(@PathVariable String id) {
    PokemonDetails pokemonDetails = pokemonDetailsService.getPokemonDetails(id);
    List<AbilityDetails> listOfAbilities =
        abilityDetailsService.getAbilityDetails(pokemonDetails.getId());
    return new PokemonDetailsResponse(
        pokemonDetails.getId(),
        pokemonDetails.getName(),
        pokemonDetails.getUrl(),
        pokemonDetails.getHeight(),
        pokemonDetails.getWeight());
  }

  @Post
  public PokemonDetailsResponse addPokemonDetails(
      @Body PokemonDetailsRequest pokemonDetailsRequest) {
    PokemonDetails addedPokemonDetails =
        pokemonDetailsService.addPokemonDetails(pokemonDetailsRequest);
    List<AbilityDetails> listOfAbilities =
        abilityDetailsService.getAbilityDetails(addedPokemonDetails.getId());
    return new PokemonDetailsResponse(
        addedPokemonDetails.getId(),
        addedPokemonDetails.getName(),
        addedPokemonDetails.getUrl(),
        addedPokemonDetails.getHeight(),
        addedPokemonDetails.getWeight());
  }
}
