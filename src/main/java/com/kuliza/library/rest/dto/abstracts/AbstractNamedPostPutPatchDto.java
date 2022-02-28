package com.kuliza.library.rest.dto.abstracts;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractNamedPostPutPatchDto {

  @NotBlank
  @JsonProperty("name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
