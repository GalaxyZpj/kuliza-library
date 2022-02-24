package com.kuliza.library.controllers;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.Book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uri.BOOK)
public class BookController extends AbstractEntityCrudRestController<Book> {
}
