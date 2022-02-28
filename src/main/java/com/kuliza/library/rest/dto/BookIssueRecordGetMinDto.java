package com.kuliza.library.rest.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliza.library.rest.dto.abstracts.AbstractGetDto;

public class BookIssueRecordGetMinDto extends AbstractGetDto {

  @JsonProperty("book_id")
  private Long bookId;

  @JsonProperty("person_id")
  private Long personId;

  @JsonProperty("return_by")
  private LocalDate returnBy;

  @JsonProperty("returned")
  private Boolean returned;

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
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
