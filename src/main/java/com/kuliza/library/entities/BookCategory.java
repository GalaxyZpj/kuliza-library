package com.kuliza.library.entities;

import javax.persistence.Entity;

import com.kuliza.library.entities.abstracts.AbstractNamedEntity;

@Entity
public class BookCategory extends AbstractNamedEntity {

  public BookCategory() {
  }

  public BookCategory(String name) {
    setName(name);
  }

}
