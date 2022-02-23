package com.kuliza.library.repositories;

import com.kuliza.library.entities.BookCategory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends CrudRepository<BookCategory, Long> {
}
