package com.kuliza.library.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliza.library.entities.BookAuthor;
import com.kuliza.library.entities.BookCategory;
import com.kuliza.library.rest.dto.abstracts.AbstractNamedGetDto;

public class BookGetDto extends AbstractNamedGetDto {

  @JsonProperty("category")
  private BookCategory category;

  @JsonProperty("author")
  private BookAuthor author;

  @JsonProperty("copies")
  private int copies;

  public BookCategory getCategory() {
    return category;
  }

  public void setCategory(BookCategory category) {
    this.category = category;
  }

  public BookAuthor getAuthor() {
    return author;
  }

  public void setAuthor(BookAuthor author) {
    this.author = author;
  }

  public int getCopies() {
    return copies;
  }

  public void setCopies(int copies) {
    this.copies = copies;
  }

}
