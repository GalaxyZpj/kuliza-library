package com.kuliza.library.repositories;

import com.kuliza.library.entities.BookAuthor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAuthorRepository extends CrudRepository<BookAuthor, Long> {
}
