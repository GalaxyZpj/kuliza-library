package com.kuliza.library.repositories;

import com.kuliza.library.entities.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
