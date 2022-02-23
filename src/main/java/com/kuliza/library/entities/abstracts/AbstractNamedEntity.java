package com.kuliza.library.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractEntity {
  @Column(nullable = false)
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
