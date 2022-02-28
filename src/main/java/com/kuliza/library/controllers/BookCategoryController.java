package com.kuliza.library.controllers;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.BookCategory;
import com.kuliza.library.rest.dto.BookCategoryGetDto;
import com.kuliza.library.rest.dto.BookCategoryPostPutDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uri.BOOK_CATEGORY)
public class BookCategoryController extends
    AbstractEntityCrudRestController<BookCategory, BookCategoryGetDto, BookCategoryGetDto, BookCategoryPostPutDto> {

  @Override
  BookCategory generateEntityInstance() {
    return new BookCategory();
  }

  @Override
  BookCategoryGetDto generateGetDtoInstance() {
    return new BookCategoryGetDto();
  }

  @Override
  BookCategoryGetDto generateGetMinDtoInstance() {
    return new BookCategoryGetDto();
  }

  @Override
  BookCategoryPostPutDto generatePostPutPatchDtoInstance() {
    return new BookCategoryPostPutDto();
  }

}
