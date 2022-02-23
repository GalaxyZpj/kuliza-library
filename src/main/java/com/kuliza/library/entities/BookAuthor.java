package com.kuliza.library.entities;

import javax.persistence.Entity;

import com.kuliza.library.entities.abstracts.AbstractNamedEntity;

@Entity
public class BookAuthor extends AbstractNamedEntity {

  public BookAuthor() {
  }

  public BookAuthor(String name) {
    setName(name);
  }
}
