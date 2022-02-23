package com.kuliza.library.exceptions.generics;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.server.ResponseStatusException;

public class EntityNotFoundException extends ResponseStatusException {
  public EntityNotFoundException(@Nullable Throwable cause) {
    super(HttpStatus.NOT_FOUND, "Entity with provided id not found.", cause);
  }

  public EntityNotFoundException(String entityName, @Nullable Throwable cause) {
    super(HttpStatus.NOT_FOUND, entityName + " with provided id not found.", cause);
  }
}
