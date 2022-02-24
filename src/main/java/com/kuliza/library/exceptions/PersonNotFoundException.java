package com.kuliza.library.exceptions;

import com.kuliza.library.exceptions.generics.EntityNotFoundException;

import org.springframework.lang.Nullable;

public class PersonNotFoundException extends EntityNotFoundException {
  public PersonNotFoundException(@Nullable Throwable cause) {
    super("Person", cause);
  }
}
