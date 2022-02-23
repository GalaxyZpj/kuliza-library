package com.kuliza.library.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import com.kuliza.library.entities.abstracts.AbstractNamedEntity;

@Entity
public class Person extends AbstractNamedEntity {

  @NotBlank(message = "mobile is mandatory")
  private String mobile;

  @NotBlank(message = "address is mandatory")
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
