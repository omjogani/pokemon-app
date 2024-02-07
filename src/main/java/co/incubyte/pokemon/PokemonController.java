package co.incubyte.pokemon;

import io.micronaut.http.annotation.*;
import java.util.List;

@Controller("/pokemon")
public class PokemonController {
  PokemonService pokemonService;

  public PokemonController(PokemonService pokemonService) {
    this.pokemonService = pokemonService;
  }

  @Get
  List<PokemonResponse> getAllPokemons() {
    List<Pokemon> allPokemons = pokemonService.getAllPokemons();
    return allPokemons.stream()
        .map(pokemon -> new PokemonResponse(pokemon.getId(), pokemon.getName(), pokemon.getUrl()))
        .toList();
  }

  @Get("/{id}")
  PokemonResponse getPokemonById(@PathVariable String id) {
    Pokemon pokemonById = pokemonService.getPokemonById(id);
    return new PokemonResponse(pokemonById.getId(), pokemonById.getName(), pokemonById.getUrl());
  }

  @Post
  PokemonResponse addPokemon(@Body PokemonRequest pokemon) {
    Pokemon addedPokemon = pokemonService.addPokemon(pokemon);
    return new PokemonResponse(addedPokemon.getId(), addedPokemon.getName(), addedPokemon.getUrl());
  }
}
