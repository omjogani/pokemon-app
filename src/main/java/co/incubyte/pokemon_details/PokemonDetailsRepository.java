package co.incubyte.pokemon_details;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface PokemonDetailsRepository extends CrudRepository<PokemonDetails, String> {}
