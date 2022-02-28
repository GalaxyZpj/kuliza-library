package com.kuliza.library.rest.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookIssueRecordPostPutPatchDto {

  @JsonProperty("book_id")
  @NotNull
  private Long bookId;

  @JsonProperty("person_id")
  @NotNull
  private Long personId;

  @JsonProperty("return_by")
  @NotNull
  @Future
  private LocalDate returnBy;

  @JsonProperty("returned")
  private Boolean returned = false;

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
