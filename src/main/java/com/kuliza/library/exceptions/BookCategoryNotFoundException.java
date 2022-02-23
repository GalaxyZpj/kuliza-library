package com.kuliza.library.exceptions;

import com.kuliza.library.exceptions.generics.EntityNotFoundException;

import org.springframework.lang.Nullable;

public class BookCategoryNotFoundException extends EntityNotFoundException {
  public BookCategoryNotFoundException(@Nullable Throwable cause) {
    super("BookCategory", cause);
  }
}
