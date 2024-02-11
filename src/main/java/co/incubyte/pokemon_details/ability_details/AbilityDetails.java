package co.incubyte.pokemon_details.ability_details;

import co.incubyte.pokemon_details.ability_details.ability.Ability;
import co.incubyte.pokemon_details.PokemonDetails;
import jakarta.persistence.*;

@Entity
@Table(name = "ability_detail")
public class AbilityDetails {
  @Id
  private String id;
  private boolean isHidden;
  @OneToOne
  private Ability ability;

  @ManyToOne
  @JoinColumn(name = "pokemon_detail_id")
  private PokemonDetails pokemonDetails;

  public AbilityDetails() {}

  public AbilityDetails(String id, boolean isHidden, Ability ability) {
    this.id = id;
    this.isHidden = isHidden;
    this.ability = ability;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isHidden() {
    return isHidden;
  }

  public void setHidden(boolean hidden) {
    isHidden = hidden;
  }

  public Ability getAbility() {
    return ability;
  }

  public void setAbility(Ability ability) {
    this.ability = ability;
  }

  public PokemonDetails getPokemonDetails() {
    return pokemonDetails;
  }

  public void setPokemonDetails(PokemonDetails pokemonDetails) {
    this.pokemonDetails = pokemonDetails;
  }
}
