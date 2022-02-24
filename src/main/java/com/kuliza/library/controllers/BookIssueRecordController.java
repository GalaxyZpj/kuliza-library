package com.kuliza.library.controllers;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.BookIssueRecord;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uri.BOOK_ISSUE_RECORD)
public class BookIssueRecordController extends AbstractEntityCrudRestController<BookIssueRecord> {
}
