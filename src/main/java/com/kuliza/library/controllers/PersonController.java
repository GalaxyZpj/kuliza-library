package com.kuliza.library.controllers;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.kuliza.library.Uri;
import com.kuliza.library.entities.Person;
import com.kuliza.library.exceptions.PersonNotFoundException;
import com.kuliza.library.exceptions.generics.MissingFieldException;
import com.kuliza.library.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
  @Autowired
  private PersonService service;

  @GetMapping(Uri.PERSON)
  List<Person> listPeople() {
    return service.fetchPeople();
  }

  @GetMapping(Uri.PERSON_PARAMETERIZED)
  Person getPerson(@PathVariable Long id) {
    try {
      return service.fetchPerson(id);
    } catch (NoSuchElementException e) {
      throw new PersonNotFoundException(e);
    }
  }

  @PostMapping(Uri.PERSON)
  ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
    service.createPerson(person);
    return ResponseEntity.status(HttpStatus.CREATED).body(person);
  }

  @PutMapping(Uri.PERSON_PARAMETERIZED)
  Person editPerson(@PathVariable Long id, @Valid @RequestBody Person person) {
    try {
      Map<String, Object> data = service.generateMapFromInstance(person);
      service.validateUpdateRequestData(data);
      return service.updatePerson(id, data);
    } catch (NoSuchElementException e) {
      throw new PersonNotFoundException(e);
    }
  }

  @PatchMapping(Uri.PERSON_PARAMETERIZED)
  Person partialEditPerson(@PathVariable Long id, @RequestBody Person person) {
    try {
      Map<String, Object> data = service.generateMapFromInstance(person);
      service.validateUpdateRequestData(data);
      return service.updatePerson(id, data);
    } catch (NoSuchElementException e) {
      throw new PersonNotFoundException(e);
    } catch (IllegalStateException e) {
      throw new MissingFieldException(e.getMessage(), e);
    }
  }

  @DeleteMapping(Uri.PERSON_PARAMETERIZED)
  ResponseEntity<Void> removePerson(@PathVariable Long id) {
    try {
      service.deletePerson(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new PersonNotFoundException(e);
    }
  }
}
