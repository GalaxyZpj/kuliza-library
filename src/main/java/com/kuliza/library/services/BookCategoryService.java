package com.kuliza.library.services;

import java.util.List;
import java.util.Map;

import com.kuliza.library.entities.BookCategory;
import com.kuliza.library.repositories.BookCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCategoryService {
  @Autowired
  private BookCategoryRepository repository;

  public void validateUpdateData(Map<Object, Object> data) throws IllegalStateException {
    if (!data.containsKey("name")) {
      throw new IllegalStateException("Mandatory: name");
    }
  }

  public List<BookCategory> fetchCategories() {
    return (List<BookCategory>) repository.findAll();
  }

  public BookCategory fetchCategory(Long categoryId) {
    return repository.findById(categoryId).get();
  }

  public BookCategory createCategory(BookCategory category) {
    return repository.save(category);
  }

  public BookCategory updateCategory(Long categoryId, String newName) {
    BookCategory category = fetchCategory(categoryId);
    category.setName(newName);
    repository.save(category);
    return category;
  }

  public void deleteCategory(Long categoryId) {
    repository.deleteById(categoryId);
  }
}
