package com.kuliza.library.controllers;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.BookCategory;
import com.kuliza.library.exceptions.BookCategoryNotFoundException;
import com.kuliza.library.exceptions.generics.MissingFieldException;
import com.kuliza.library.services.BookCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookCategoryController {
  @Autowired
  private BookCategoryService service;

  @GetMapping(Uri.BOOK_CATEGORY)
  List<BookCategory> fetchCategories() {
    return service.fetchCategories();
  }

  @GetMapping(Uri.BOOK_CATEGORY_PARAMETERIZED)
  BookCategory fetchCategory(@PathVariable Long id) {
    try {
      return service.fetchCategory(id);
    } catch (NoSuchElementException e) {
      throw new BookCategoryNotFoundException(e);
    }
  }

  @PostMapping(Uri.BOOK_CATEGORY)
  BookCategory createCategory(@Valid @RequestBody BookCategory category) {
    return service.createCategory(category);
  }

  @PutMapping(Uri.BOOK_CATEGORY_PARAMETERIZED)
  BookCategory updateCategory(@PathVariable Long id, @RequestBody Map<Object, Object> body) {
    try {
      service.validateUpdateData(body);
      return service.updateCategory(id, (String) body.get("name"));
    } catch (NoSuchElementException e) {
      throw new BookCategoryNotFoundException(e);
    } catch (IllegalStateException e) {
      throw new MissingFieldException(e.getMessage(), e);
    }
  }

  @DeleteMapping(Uri.BOOK_CATEGORY_PARAMETERIZED)
  ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
    try {
      service.deleteCategory(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new BookCategoryNotFoundException(e);
    }
  }
}
