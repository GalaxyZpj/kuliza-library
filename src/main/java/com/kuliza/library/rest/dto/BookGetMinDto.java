package com.kuliza.library.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliza.library.rest.dto.abstracts.AbstractNamedGetDto;

public class BookGetMinDto extends AbstractNamedGetDto {

  @JsonProperty("category_id")
  private Long categoryId;

  @JsonProperty("author_id")
  private Long authorId;

  @JsonProperty("copies")
  private int copies;

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
