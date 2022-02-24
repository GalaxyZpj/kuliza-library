package com.kuliza.library.controllers;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.Person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uri.PERSON)
public class PersonController extends AbstractEntityCrudRestController<Person> {
}
