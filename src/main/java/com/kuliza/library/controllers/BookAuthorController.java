package com.kuliza.library.controllers;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.BookAuthor;
import com.kuliza.library.rest.dto.BookAuthorGetDto;
import com.kuliza.library.rest.dto.BookAuthorPostPutDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uri.BOOK_AUTHOR)
public class BookAuthorController
    extends AbstractEntityCrudRestController<BookAuthor, BookAuthorGetDto, BookAuthorGetDto, BookAuthorPostPutDto> {

  @Override
  BookAuthor generateEntityInstance() {
    return new BookAuthor();
  }

  @Override
  BookAuthorGetDto generateGetDtoInstance() {
    return new BookAuthorGetDto();
  }

  @Override
  BookAuthorGetDto generateGetMinDtoInstance() {
    return new BookAuthorGetDto();
  }

  @Override
  BookAuthorPostPutDto generatePostPutPatchDtoInstance() {
    return new BookAuthorPostPutDto();
  }

}
