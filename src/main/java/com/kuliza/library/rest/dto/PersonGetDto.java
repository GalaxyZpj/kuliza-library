package com.kuliza.library.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliza.library.rest.dto.abstracts.AbstractNamedGetDto;

public class PersonGetDto extends AbstractNamedGetDto {

  @JsonProperty("mobile")
  private String mobile;

  @JsonProperty("address")
  private String address;

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
