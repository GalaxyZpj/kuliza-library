package com.kuliza.library.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.kuliza.library.entities.abstracts.AbstractNamedEntity;

@Entity
public class Person extends AbstractNamedEntity {

  @Column(nullable = false)
  private String mobile;

  @Column(nullable = false)
  private String address;

  public Person() {
  }

  public Person(String name, String mobile, String address) {
    this.mobile = mobile;
    this.address = address;
    setName(name);
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
