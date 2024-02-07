package co.incubyte.pokemon;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, String> {}
