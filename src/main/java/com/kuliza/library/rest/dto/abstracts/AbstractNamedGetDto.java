package com.kuliza.library.rest.dto.abstracts;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractNamedGetDto extends AbstractGetDto {

  @JsonProperty("name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
