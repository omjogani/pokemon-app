package co.incubyte.pokemon_details;

import co.incubyte.pokemon_details.ability_details.AbilityDetails;

import java.util.List;

public class PokemonDetailsBuilder {
    private String id;
    private String name;
    private String url;
    private int weight;
    private int height;

//    private List<AbilityDetails> abilityDetails;

    public static PokemonDetailsBuilder buildPokemonDetails() {
        return new PokemonDetailsBuilder();
    }

    public PokemonDetailsBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public PokemonDetailsBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PokemonDetailsBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public PokemonDetailsBuilder withWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public PokemonDetailsBuilder withHeight(int height) {
        this.height = height;
        return this;
    }

//    public PokemonDetailsBuilder withAbilityDetails(List<AbilityDetails> abilityDetails) {
//        this.abilityDetails = abilityDetails;
//        return this;
//    }

    public PokemonDetails build() {
        PokemonDetails pokemonDetails = new PokemonDetails();
        pokemonDetails.setId(id);
        pokemonDetails.setName(name);
        pokemonDetails.setUrl(url);
        pokemonDetails.setWeight(weight);
        pokemonDetails.setHeight(height);
//        pokemonDetails.setAbilityDetails(abilityDetails);
        return pokemonDetails;
    }
}
