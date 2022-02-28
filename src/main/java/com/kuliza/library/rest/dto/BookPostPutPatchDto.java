package com.kuliza.library.rest.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliza.library.rest.dto.abstracts.AbstractNamedPostPutPatchDto;

public class BookPostPutPatchDto extends AbstractNamedPostPutPatchDto {

  @JsonProperty("category_id")
  @NotNull
  private Long categoryId;

  @JsonProperty("author_id")
  @NotNull
  private Long authorId;

  @JsonProperty("copies")
  private int copies = 0;

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  public int getCopies() {
    return copies;
  }

  public void setCopies(int copies) {
    this.copies = copies;
  }

}
