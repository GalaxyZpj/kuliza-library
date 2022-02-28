package com.kuliza.library.controllers;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.Person;
import com.kuliza.library.rest.dto.PersonGetDto;
import com.kuliza.library.rest.dto.PersonPostPutPatchDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uri.PERSON)
public class PersonController
    extends AbstractEntityCrudRestController<Person, PersonGetDto, PersonGetDto, PersonPostPutPatchDto> {

  @Override
  Person generateEntityInstance() {
    return new Person();
  }

  @Override
  PersonGetDto generateGetDtoInstance() {
    return new PersonGetDto();
  }

  @Override
  PersonGetDto generateGetMinDtoInstance() {
    return new PersonGetDto();
  }

  @Override
  PersonPostPutPatchDto generatePostPutPatchDtoInstance() {
    return new PersonPostPutPatchDto();
  }
}
