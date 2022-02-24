package com.kuliza.library.controllers;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.BookAuthor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uri.BOOK_AUTHOR)
public class BookAuthorController extends AbstractEntityCrudRestController<BookAuthor> {
}
