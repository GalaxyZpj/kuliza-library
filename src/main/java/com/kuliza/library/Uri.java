package com.kuliza.library;

import org.springframework.stereotype.Component;

@Component
public class Uri {

  public static final String BOOK = "/api/book";
  public static final String BOOK_PARAMETERIZED = "/api/book/{id}";
  public static final String BOOK_AUTHOR = "/api/book-author";
  public static final String BOOK_AUTHOR_PARAMETERIZED = "/api/book-author/{id}";
  public static final String BOOK_CATEGORY = "/api/book-category";
  public static final String BOOK_CATEGORY_PARAMETERIZED = "/api/book-category/{id}";
  public static final String BOOK_ISSUE_RECORD = "/api/book-issue-record";
  public static final String BOOK_ISSUE_RECORD_PARAMETERIZED = "/api/book-issue-record/{id}";
  public static final String PERSON = "/api/person";
  public static final String PERSON_PARAMETERIZED = "/api/person/{id}";

}
