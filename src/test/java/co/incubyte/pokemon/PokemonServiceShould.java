package co.incubyte.pokemon;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class PokemonServiceShould {

  PokemonRepository pokemonRepository;

  PokemonService pokemonService;

  @BeforeEach
  void setUp() {
    pokemonRepository = mock(PokemonRepository.class);
    pokemonService = new PokemonService(pokemonRepository);
  }

  @Test
  void add_pokemon_to_repository() {
    // arrange
    PokemonRequest pokemonRequest = new PokemonRequest("FAKE_NAME", "FAKE_URL");

    when(pokemonRepository.save(any(Pokemon.class))).then(returnsFirstArg());

    // action
    Pokemon receivedPokemon = pokemonService.addPokemon(pokemonRequest);

    // assert
    assertThat(receivedPokemon.getId()).isNotNull();
    assertThat(receivedPokemon.getName()).isEqualTo("FAKE_NAME");
    assertThat(receivedPokemon.getUrl()).isEqualTo("FAKE_URL");
  }

  @Test
  void get_pokemon_by_id() {
    // arrange
    Pokemon pokemon = new Pokemon("FAKE_ID", "FAKE_NAME", "FAKE_URL");
    when(pokemonRepository.findById("FAKE_ID")).thenReturn(Optional.of(pokemon));

    // action
    Pokemon receivedPokemon = pokemonService.getPokemonById("FAKE_ID");

    // assert
    assertThat(receivedPokemon).isEqualTo(pokemon);
  }

  @Test
  void throw_an_exception_entity_not_found_on_invalid_pokemon_id() {
    when(pokemonRepository.findById("FAKE_ID")).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> {
      Pokemon receivedPokemon = pokemonService.getPokemonById("FAKE_ID");
    });

    verify(pokemonRepository).findById("FAKE_ID");
  }


  @Test
  void invoke_findAll_method_of_repository_and_return_pokemon_list() {
    // arrange
    List<Pokemon> pokemonList =
        List.of(
            new Pokemon("FAKE_ID1", "FAKE_ID1", "FAKE_ID1"),
            new Pokemon("FAKE_ID2", "FAKE_ID2", "FAKE_ID2"));
    when(pokemonRepository.findAll()).thenReturn(pokemonList);

    // action
    List<Pokemon> receivedPokemonList = pokemonService.getAllPokemons();

    // assert
    assertThat(receivedPokemonList).isEqualTo(pokemonList);
    verify(pokemonRepository).findAll();
  }
}
