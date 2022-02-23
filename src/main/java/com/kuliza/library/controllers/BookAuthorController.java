package com.kuliza.library.controllers;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.BookAuthor;
import com.kuliza.library.exceptions.BookAuthorNotFoundException;
import com.kuliza.library.exceptions.generics.MissingFieldException;
import com.kuliza.library.services.BookAuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAuthorController {
  @Autowired
  private BookAuthorService service;

  @GetMapping(Uri.BOOK_AUTHOR)
  List<BookAuthor> listAuthors() {
    return service.fetchAuthors();
  }

  @GetMapping(Uri.BOOK_AUTHOR_PARAMETERIZED)
  BookAuthor getAuthor(@PathVariable Long id) {
    try {
      return service.fetchAuthor(id);
    } catch (NoSuchElementException e) {
      throw new BookAuthorNotFoundException(e);
    }
  }

  @PostMapping(Uri.BOOK_AUTHOR)
  ResponseEntity<BookAuthor> addAuthor(@Valid @RequestBody BookAuthor author) {
    service.createAuthor(author);
    return ResponseEntity.status(HttpStatus.CREATED).body(author);
  }

  @PutMapping(Uri.BOOK_AUTHOR_PARAMETERIZED)
  BookAuthor editAuthor(@PathVariable Long id, @RequestBody Map<Object, Object> body) {
    try {
      service.validateUpdateData(body);
      return service.updateAuthor(id, (String) body.get("name"));
    } catch (NoSuchElementException e) {
      throw new BookAuthorNotFoundException(e);
    } catch (IllegalStateException e) {
      throw new MissingFieldException(e.getMessage(), e);
    }
  }

  @DeleteMapping(Uri.BOOK_AUTHOR_PARAMETERIZED)
  ResponseEntity<Void> removeAuthor(@PathVariable Long id) {
    try {
      service.deleteAuthor(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new BookAuthorNotFoundException(e);
    }
  }
}
