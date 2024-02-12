package co.incubyte.pokemon_details;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PokemonDetailsServiceShould {

  PokemonDetailsRepository pokemonDetailsRepository;

  PokemonDetailsService pokemonDetailsService;

  @BeforeEach
  void setUp() {
    pokemonDetailsRepository = Mockito.mock(PokemonDetailsRepository.class);
    pokemonDetailsService = new PokemonDetailsService(pokemonDetailsRepository);
  }

  @Test
  void get_pokemon_details_by_id() {
    // arrange
    PokemonDetails staticPokemonDetails =
        new PokemonDetails("FAKE_ID", "FAKE_NAME", "FAKE_URL", 100, 100);
    when(pokemonDetailsRepository.findById("FAKE_ID"))
        .thenReturn(java.util.Optional.of(staticPokemonDetails));

    // action
    PokemonDetails pokemonDetails = pokemonDetailsService.getPokemonDetails("FAKE_ID");

    // assert
    assertThat(pokemonDetails.getId()).isEqualTo("FAKE_ID");
    assertThat(pokemonDetails.getName()).isEqualTo("FAKE_NAME");
    assertThat(pokemonDetails.getUrl()).isEqualTo("FAKE_URL");
    assertThat(pokemonDetails.getHeight()).isEqualTo(100);
    assertThat(pokemonDetails.getWeight()).isEqualTo(100);
    verify(pokemonDetailsRepository).findById("FAKE_ID");
  }

  @Test
  void add_pokemon_detail_with_pokemon_details_data() {
    // arrange
    PokemonDetailsRequest staticPokemonRequest =
        new PokemonDetailsRequest("FAKE_NAME", "FAKE_URL", 100, 100);
    when(pokemonDetailsRepository.save(any(PokemonDetails.class))).then(returnsFirstArg());

    // action
    PokemonDetails addedPokemonDetails =
        pokemonDetailsService.addPokemonDetails(staticPokemonRequest);

    // assert
    assertThat(addedPokemonDetails.getId()).isNotNull();
    assertThat(addedPokemonDetails.getName()).isEqualTo("FAKE_NAME");
    assertThat(addedPokemonDetails.getUrl()).isEqualTo("FAKE_URL");
    assertThat(addedPokemonDetails.getHeight()).isEqualTo(100);
    assertThat(addedPokemonDetails.getWeight()).isEqualTo(100);
    verify(pokemonDetailsRepository).save(any(PokemonDetails.class));
  }
}
