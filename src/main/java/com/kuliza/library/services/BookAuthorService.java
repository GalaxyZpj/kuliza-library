package com.kuliza.library.services;

import java.util.List;
import java.util.Map;

import com.kuliza.library.entities.BookAuthor;
import com.kuliza.library.repositories.BookAuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookAuthorService {
  @Autowired
  private BookAuthorRepository repository;

  public void validateUpdateData(Map<Object, Object> data) throws IllegalStateException {
    if (!data.containsKey("name")) {
      throw new IllegalStateException("Mandatory: name");
    }
  }

  public List<BookAuthor> fetchAuthors() {
    return repository.findAll();
  }

  public BookAuthor fetchAuthor(Long authorId) {
    return repository.findById(authorId).get();
  }

  public BookAuthor createAuthor(BookAuthor author) {
    return repository.save(author);
  }

  public BookAuthor updateAuthor(Long authorId, String newName) {
    BookAuthor author = fetchAuthor(authorId);
    author.setName(newName);
    repository.save(author);
    return author;
  }

  public void deleteAuthor(Long authorId) {
    repository.deleteById(authorId);
  }
}
