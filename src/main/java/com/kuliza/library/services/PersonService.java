package com.kuliza.library.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuliza.library.entities.Person;
import com.kuliza.library.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service
public class PersonService {
  @Autowired
  private PersonRepository repository;

  public void validateUpdateRequestData(Map<String, Object> data) throws IllegalStateException {
    String[] toBeRemovedKeys = new String[] { "id", "created", "lastModified" };
    for (String key : toBeRemovedKeys) {
      data.remove(key);
    }
    while (data.values().remove(null))
      ;
    if (data.isEmpty())
      throw new IllegalStateException("No valid fields provided.");
  }

  public Map<String, Object> generateMapFromInstance(Person person) {
    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> data = mapper.convertValue(person, new TypeReference<Map<String, Object>>() {
    });
    return data;
  }

  public List<Person> fetchPeople() {
    return repository.findAll();
  }

  public Person fetchPerson(Long personId) {
    return repository.findById(personId).get();
  }

  public Person createPerson(Person person) {
    return repository.save(person);
  }

  public Person updatePerson(Long personId, Map<String, Object> data) {
    Person person = fetchPerson(personId);
    data.forEach((key, value) -> {
      Field field = ReflectionUtils.findField(Person.class, key);
      field.setAccessible(true);
      ReflectionUtils.setField(field, person, value);
    });
    repository.save(person);
    return person;
  }

  public void deletePerson(Long personId) {
    repository.deleteById(personId);
  }
}
