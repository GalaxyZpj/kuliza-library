package com.kuliza.library.rest.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliza.library.rest.dto.abstracts.AbstractNamedPostPutPatchDto;

public class PersonPostPutPatchDto extends AbstractNamedPostPutPatchDto {

  @JsonProperty("mobile")
  @NotBlank
  private String mobile;

  @JsonProperty("address")
  @NotBlank
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
