package co.incubyte.pokemon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PokemonControllerShould {

  PokemonService pokemonService;
  PokemonController pokemonController;
  @BeforeEach
  void setUp() {
    pokemonService = Mockito.mock(PokemonService.class);

    pokemonController = new PokemonController(pokemonService);
  }

  @Test
  void add_pokemon_to_service() {

  }
}
