package co.incubyte.pokemon_details;

import co.incubyte.pokemon_details.ability_details.AbilityDetails;

import java.util.List;

public record PokemonDetailsResponse(String id, String name, String url, int height, int weight) {}
