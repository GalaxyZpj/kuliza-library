package com.kuliza.library.runners;

import com.kuliza.library.entities.BookAuthor;
import com.kuliza.library.entities.BookCategory;
import com.kuliza.library.repositories.BookAuthorRepository;
import com.kuliza.library.repositories.BookCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializeDataRunner implements CommandLineRunner {
  @Autowired
  private BookCategoryRepository categoryRepository;

  @Autowired
  private BookAuthorRepository authorRepository;

  @Override
  public void run(String... args) throws Exception {
    categoryRepository.save(new BookCategory("Category 1"));
    categoryRepository.save(new BookCategory("Category 2"));

    authorRepository.save(new BookAuthor("Author 1"));
    authorRepository.save(new BookAuthor("Author 2"));
  }
}
