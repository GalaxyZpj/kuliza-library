package com.kuliza.library.entities.abstracts;

import java.time.Instant;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class AbstractEntity {

  @Id
  @GeneratedValue
  private Long id;

  @CreationTimestamp
  private Instant created;

  @UpdateTimestamp
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
