package com.kuliza.library.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuliza.library.entities.abstracts.AbstractEntity;
import com.kuliza.library.utils.MapperUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractEntityService<T extends AbstractEntity> {

  @Autowired
  protected JpaRepository<T, Long> repository;

  public Map<String, Object> generateMapFromInstance(T entity) {
    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> data = mapper.convertValue(entity, new TypeReference<Map<String, Object>>() {
    });
    return data;
  }

  public List<T> fetchAll() {
    return repository.findAll();
  }

  public T fetch(Long id) {
    return repository.findById(id).get();
  }

  public T create(T entity) {
    return repository.save(entity);
  }

  public T update(Long id, T entity) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
      SecurityException, NoSuchMethodException, InvocationTargetException {
    T fetchedEntity = fetch(id);
    MapperUtils.patchEntityAttributes(entity, fetchedEntity);
    repository.save(fetchedEntity);
    return fetchedEntity;
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

}
