package com.kuliza.library.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.ReflectionUtils;

public abstract class AbstractEntityService<T> {
  protected static final String[] nonUpdatableKeys = new String[] { "id", "created", "lastModified" };

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

  public T update(Long id, Map<String, Object> data) {
    T entity = fetch(id);
    data.forEach((key, value) -> {
      Field field = ReflectionUtils.findField(entity.getClass(), key);
      field.setAccessible(true);
      ReflectionUtils.setField(field, entity, value);
    });
    repository.save(entity);
    return entity;
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

  public void validateUpdateRequestData(Map<String, Object> data) throws IllegalStateException {
    for (String key : nonUpdatableKeys) {
      data.remove(key);
    }
    while (data.values().remove(null))
      ;
    if (data.isEmpty())
      throw new IllegalStateException("No valid fields provided.");
  }

}
