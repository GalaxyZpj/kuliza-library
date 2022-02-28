package com.kuliza.library.rest.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliza.library.entities.Book;
import com.kuliza.library.entities.Person;
import com.kuliza.library.rest.dto.abstracts.AbstractGetDto;

public class BookIssueRecordGetDto extends AbstractGetDto {

  @JsonProperty("book")
  private Book book;

  @JsonProperty("person")
  private Person person;

  @JsonProperty("return_by")
  private LocalDate returnBy;

  @JsonProperty("returned")
  private Boolean returned;

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public LocalDate getReturnBy() {
    return returnBy;
  }

  public void setReturnBy(LocalDate returnBy) {
    this.returnBy = returnBy;
  }

  public Boolean getReturned() {
    return returned;
  }

  public void setReturned(Boolean returned) {
    this.returned = returned;
  }

}
