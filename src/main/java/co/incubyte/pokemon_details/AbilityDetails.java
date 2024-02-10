package co.incubyte.pokemon_details;

public class AbilityDetails {
  private boolean isHidden;
  private Ability ability;

  public AbilityDetails() {}

  public AbilityDetails(boolean isHidden, Ability ability) {
    this.isHidden = isHidden;
    this.ability = ability;
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
}
