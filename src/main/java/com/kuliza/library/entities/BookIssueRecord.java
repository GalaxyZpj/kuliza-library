package com.kuliza.library.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.kuliza.library.entities.abstracts.AbstractEntity;

@Entity
public class BookIssueRecord extends AbstractEntity {

  @ManyToOne(optional = false)
  @JoinColumn(name = "book_id")
  private Book book;

  @ManyToOne(optional = false)
  @JoinColumn(name = "person_id")
  private Person person;

  @Column(columnDefinition = "DATE", nullable = false)
  private LocalDate returnBy;

  @Column(nullable = false)
  private Boolean returned = false;

  public BookIssueRecord() {
  }

  public BookIssueRecord(Book book, Person person, LocalDate returnBy) {
    this.book = book;
    this.person = person;
    this.returnBy = returnBy;
  }

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
