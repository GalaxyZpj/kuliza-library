package com.kuliza.library.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.kuliza.library.entities.abstracts.AbstractNamedEntity;

@Entity
public class Book extends AbstractNamedEntity {

  @ManyToOne(optional = false)
  private BookCategory category;

  @ManyToOne(optional = false)
  private BookAuthor author;

  @Column(nullable = false)
  private int copies;

  public Book() {
  }

  public Book(String name, BookCategory category, BookAuthor author, int copies) {
    this.category = category;
    this.author = author;
    this.copies = copies;
    setName(name);
  }

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
