package com.kuliza.library.controllers;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.BookCategory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uri.BOOK_CATEGORY)
public class BookCategoryController extends AbstractEntityCrudRestController<BookCategory> {
}
