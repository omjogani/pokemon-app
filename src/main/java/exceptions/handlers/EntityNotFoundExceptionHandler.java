package exceptions.handlers;

import exceptions.EntityNotFoundException;
import exceptions.common.PokemonApiErrorResponse;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
@Produces
@Requires(classes = {EntityNotFoundExceptionHandler.class, ExceptionHandler.class})
public class EntityNotFoundExceptionHandler
    implements ExceptionHandler<EntityNotFoundException, HttpResponse<PokemonApiErrorResponse>> {
  @Override
  public HttpResponse<PokemonApiErrorResponse> handle(
      HttpRequest request, EntityNotFoundException exception) {
    return HttpResponse.notFound(
        new PokemonApiErrorResponse(
            "ENTITY_NOT_FOUND", exception.getMessage(), HttpStatus.NOT_FOUND));
  }
}
