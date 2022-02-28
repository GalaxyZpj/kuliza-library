package com.kuliza.library.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import com.kuliza.library.entities.abstracts.AbstractEntity;
import com.kuliza.library.exceptions.EntityNotFoundException;
import com.kuliza.library.exceptions.MissingFieldException;
import com.kuliza.library.rest.dto.abstracts.AbstractGetDto;
import com.kuliza.library.rest.mapper.DtoMapper;
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

public abstract class AbstractEntityCrudRestController<EntityType extends AbstractEntity, GetDtoType, GetMinDtoType extends AbstractGetDto, PostPutPatchDtoType> {

  @Autowired
  protected AbstractEntityService<EntityType> service;

  @Autowired
  protected DtoMapper<EntityType> mapper;

  abstract EntityType generateEntityInstance();

  abstract GetDtoType generateGetDtoInstance();

  abstract GetMinDtoType generateGetMinDtoInstance();

  abstract PostPutPatchDtoType generatePostPutPatchDtoInstance();

  @GetMapping
  ResponseEntity<List<EntityType>> list() {
    return ResponseEntity.ok().body(service.fetchAll());
  }

  @GetMapping("/{id}")
  ResponseEntity<EntityType> get(@PathVariable Long id) {
    try {
      return ResponseEntity.ok().body(service.fetch(id));
    } catch (NoSuchElementException e) {
      throw new EntityNotFoundException(e);
    }
  }

  @PostMapping
  ResponseEntity<GetMinDtoType> add(@Valid @RequestBody PostPutPatchDtoType dto)
      throws SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
      InstantiationException, InvocationTargetException, NoSuchMethodException {
    EntityType entity = generateEntityInstance();
    mapper.mapDtoToEntity(dto, entity);
    GetMinDtoType res = generateGetMinDtoInstance();
    mapper.mapEntityToDto(service.create(entity), res);
    return ResponseEntity.status(HttpStatus.CREATED).body(res);
  }

  @PutMapping("/{id}")
  ResponseEntity<GetMinDtoType> edit(@PathVariable Long id, @Valid @RequestBody PostPutPatchDtoType dto)
      throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
      InstantiationException, InvocationTargetException, NoSuchMethodException {
    try {
      EntityType entity = generateEntityInstance();
      mapper.mapDtoToEntity(dto, entity);
      GetMinDtoType res = generateGetMinDtoInstance();
      mapper.mapEntityToDto(service.update(id, entity), res);
      return ResponseEntity.ok().body(res);
    } catch (NoSuchElementException e) {
      throw new EntityNotFoundException(e);
    }
  }

  @PatchMapping("/{id}")
  ResponseEntity<GetMinDtoType> partialEdit(@PathVariable Long id, @RequestBody PostPutPatchDtoType dto)
      throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
      InstantiationException, InvocationTargetException, NoSuchMethodException {
    try {
      EntityType entity = generateEntityInstance();
      mapper.mapDtoToEntity(dto, entity);
      GetMinDtoType res = generateGetMinDtoInstance();
      mapper.mapEntityToDto(service.update(id, entity), res);
      return ResponseEntity.ok().body(res);
    } catch (NoSuchElementException e) {
      throw new EntityNotFoundException(e);
    } catch (IllegalStateException e) {
      throw new MissingFieldException(e.getMessage(), e);
    }
  }

  @DeleteMapping("/{id}")
  void remove(@PathVariable Long id) {
    try {
      service.delete(id);
    } catch (Exception e) {
      throw new EntityNotFoundException(e);
    }
  }
}
