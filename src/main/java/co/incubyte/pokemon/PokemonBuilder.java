package co.incubyte.pokemon;

public final class PokemonBuilder {
  private String id;
  private String name;
  private String url;

  public static PokemonBuilder buildPokemon() {
      return new PokemonBuilder();
  };
  public PokemonBuilder withId(String id) {
    this.id = id;
    return this;
  }

  public PokemonBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public PokemonBuilder withUrl(String url) {
    this.url = url;
    return this;
  }

  public Pokemon build() {
      Pokemon pokemon = new Pokemon();
      pokemon.setId(id);
      pokemon.setName(name);
      pokemon.setUrl(url);
      return pokemon;
  }
}
