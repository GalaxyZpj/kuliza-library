package com.kuliza.library.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.server.ResponseStatusException;

public class MissingFieldException extends ResponseStatusException {

  public MissingFieldException(String message, @Nullable Throwable cause) {
    super(HttpStatus.BAD_REQUEST, message, cause);
  }

  public MissingFieldException(List<String> fieldList, @Nullable Throwable cause) {
    super(HttpStatus.BAD_REQUEST, "Mandatory: " + String.join(",", fieldList), cause);
  }

  public MissingFieldException(String message) {
    this(message, null);
  }

  public MissingFieldException(List<String> fieldList) {
    this(fieldList, null);
  }

}
