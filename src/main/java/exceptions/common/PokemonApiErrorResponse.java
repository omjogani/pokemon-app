package exceptions.common;

import io.micronaut.http.HttpStatus;

public record PokemonApiErrorResponse(String errorCode, String message, HttpStatus status) {}
