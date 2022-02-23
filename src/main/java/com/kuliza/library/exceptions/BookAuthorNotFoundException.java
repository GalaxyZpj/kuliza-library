package com.kuliza.library.exceptions;

import com.kuliza.library.exceptions.generics.EntityNotFoundException;

import org.springframework.lang.Nullable;

public class BookAuthorNotFoundException extends EntityNotFoundException {
  public BookAuthorNotFoundException(@Nullable Throwable cause) {
    super("BookAuthor", cause);
  }
}
