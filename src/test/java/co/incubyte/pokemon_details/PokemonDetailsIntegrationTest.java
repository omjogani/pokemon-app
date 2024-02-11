package co.incubyte.pokemon_details;

import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.RestAssured;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class PokemonDetailsIntegrationTest {

  private static final Logger log = LoggerFactory.getLogger(PokemonDetailsIntegrationTest.class);

  private String base;

  @Inject EmbeddedServer embeddedServer;

  @BeforeEach
  void setUp() {
    base = embeddedServer.getURI().toString();
  }

  @Test
  void add_pokemon_details_to_repository() {
    String id = add_pokemon_details(base);
    log.info(id);
  }
  private static String add_pokemon_details(String base) {
    String pokemonBody =
        """
    {
          "name": "pikachu",
          "url": "pikachu.com",
          "height": 4,
          "weight": 60,
        }
        """;
    return RestAssured.given()
        .log()
        .all()
        .when()
        .body(pokemonBody)
        .post(base + "/pokemon-details")
        .then()
        .extract()
        .body()
        .path("id");
  }
}
