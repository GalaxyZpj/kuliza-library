package com.kuliza.library.controllers;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.Book;
import com.kuliza.library.rest.dto.BookGetDto;
import com.kuliza.library.rest.dto.BookGetMinDto;
import com.kuliza.library.rest.dto.BookPostPutPatchDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uri.BOOK)
public class BookController
    extends AbstractEntityCrudRestController<Book, BookGetDto, BookGetMinDto, BookPostPutPatchDto> {

  @Override
  Book generateEntityInstance() {
    return new Book();
  }

  @Override
  BookGetDto generateGetDtoInstance() {
    return new BookGetDto();
  }

  @Override
  BookGetMinDto generateGetMinDtoInstance() {
    return new BookGetMinDto();
  }

  @Override
  BookPostPutPatchDto generatePostPutPatchDtoInstance() {
    return new BookPostPutPatchDto();
  }
}
