package co.incubyte.pokemon_details;

public record PokemonDetailsRequest(String name, String url, int height, int weight, AbilityDetails abilityDetails) {}
