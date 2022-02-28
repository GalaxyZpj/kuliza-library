package com.kuliza.library.rest.dto.abstracts;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractGetDto {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("created")
  private Instant created;

  @JsonProperty("last_modified")
  private Instant lastModified;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Instant getCreated() {
    return created;
  }

  public void setCreated(Instant created) {
    this.created = created;
  }

  public Instant getLastModified() {
    return lastModified;
  }

  public void setLastModified(Instant lastModified) {
    this.lastModified = lastModified;
  }

}
