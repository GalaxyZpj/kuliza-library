package com.kuliza.library.entities.abstracts;

import java.time.Instant;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public abstract class AbstractEntity {

  @Id
  @GeneratedValue
  private Long id;

  @CreatedDate
  private Instant created;

  @LastModifiedDate
  private Instant lastModified;

  public Long getId() {
    return id;
  }

  public Instant getCreated() {
    return created;
  }

  public Instant getLastModified() {
    return lastModified;
  }
}
