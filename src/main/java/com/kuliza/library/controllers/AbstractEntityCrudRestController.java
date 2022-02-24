package com.kuliza.library.controllers;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.kuliza.library.exceptions.EntityNotFoundException;
import com.kuliza.library.exceptions.MissingFieldException;
import com.kuliza.library.services.AbstractEntityService;

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

public abstract class AbstractEntityCrudRestController<EntityType> {

  @Autowired
  protected AbstractEntityService<EntityType> service;

  @GetMapping
  List<EntityType> list() {
    return service.fetchAll();
  }

  @GetMapping("/{id}")
  EntityType get(@PathVariable Long id) {
    try {
      return service.fetch(id);
    } catch (NoSuchElementException e) {
      throw new EntityNotFoundException(e);
    }
  }

  @PostMapping
  ResponseEntity<EntityType> add(@Valid @RequestBody EntityType entity) {
    service.create(entity);
    return ResponseEntity.status(HttpStatus.CREATED).body(entity);
  }

  @PutMapping("/{id}")
  EntityType edit(@PathVariable Long id, @Valid @RequestBody EntityType entity) {
    try {
      Map<String, Object> data = service.generateMapFromInstance(entity);
      service.validateUpdateRequestData(data);
      return service.update(id, data);
    } catch (NoSuchElementException e) {
      throw new EntityNotFoundException(e);
    }
  }

  @PatchMapping("/{id}")
  EntityType partialEdit(@PathVariable Long id, @RequestBody EntityType entity) {
    try {
      Map<String, Object> data = service.generateMapFromInstance(entity);
      service.validateUpdateRequestData(data);
      return service.update(id, data);
    } catch (NoSuchElementException e) {
      throw new EntityNotFoundException(e);
    } catch (IllegalStateException e) {
      throw new MissingFieldException(e.getMessage(), e);
    }
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> remove(@PathVariable Long id) {
    try {
      service.delete(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      throw new EntityNotFoundException(e);
    }
  }
}
