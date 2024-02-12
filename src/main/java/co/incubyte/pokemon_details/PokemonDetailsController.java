package co.incubyte.pokemon_details;

import io.micronaut.http.annotation.*;

@Controller("/pokemon-details")
public class PokemonDetailsController {

  PokemonDetailsService pokemonDetailsService;

  public PokemonDetailsController(
      PokemonDetailsService pokemonDetailsService) {
    this.pokemonDetailsService = pokemonDetailsService;
  }

  @Get("/{id}")
  public PokemonDetailsResponse getPokemonDetails(@PathVariable String id) {
    PokemonDetails pokemonDetails = pokemonDetailsService.getPokemonDetails(id);
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
    return new PokemonDetailsResponse(
        addedPokemonDetails.getId(),
        addedPokemonDetails.getName(),
        addedPokemonDetails.getUrl(),
        addedPokemonDetails.getHeight(),
        addedPokemonDetails.getWeight());
  }
}
