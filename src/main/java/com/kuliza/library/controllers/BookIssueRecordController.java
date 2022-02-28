package com.kuliza.library.controllers;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.BookIssueRecord;
import com.kuliza.library.rest.dto.BookIssueRecordGetDto;
import com.kuliza.library.rest.dto.BookIssueRecordGetMinDto;
import com.kuliza.library.rest.dto.BookIssueRecordPostPutPatchDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uri.BOOK_ISSUE_RECORD)
public class BookIssueRecordController extends
    AbstractEntityCrudRestController<BookIssueRecord, BookIssueRecordGetDto, BookIssueRecordGetMinDto, BookIssueRecordPostPutPatchDto> {

  @Override
  BookIssueRecord generateEntityInstance() {
    return new BookIssueRecord();
  }

  @Override
  BookIssueRecordGetDto generateGetDtoInstance() {
    return new BookIssueRecordGetDto();
  }

  @Override
  BookIssueRecordGetMinDto generateGetMinDtoInstance() {
    return new BookIssueRecordGetMinDto();
  }

  @Override
  BookIssueRecordPostPutPatchDto generatePostPutPatchDtoInstance() {
    return new BookIssueRecordPostPutPatchDto();
  }

}
