package co.incubyte.pokemon_details;

import co.incubyte.pokemon_details.ability_details.AbilityDetails;

import java.util.List;

public record PokemonDetailsRequest(
    String name, String url, int height, int weight) {}
