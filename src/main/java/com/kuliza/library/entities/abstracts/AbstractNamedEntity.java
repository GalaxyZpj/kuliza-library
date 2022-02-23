package com.kuliza.library.entities.abstracts;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractEntity {
  @NotBlank(message = "name is mandatory")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
