package co.incubyte.pokemon_details.ability_details;

import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class AbilityDetailsService {
    private final AbilityDetailsRepository abilityDetailsRepository;

    public AbilityDetailsService(AbilityDetailsRepository abilityDetailsRepository) {
        this.abilityDetailsRepository = abilityDetailsRepository;
    }

    public AbilityDetails createAbilityDetails(AbilityDetails abilityDetails) {
        return abilityDetailsRepository.save(abilityDetails);
    }

    public List<AbilityDetails> getAbilityDetails(String pokemonDetailsId) {
        return abilityDetailsRepository.findByPokemonDetailsId(pokemonDetailsId);
    }
}
