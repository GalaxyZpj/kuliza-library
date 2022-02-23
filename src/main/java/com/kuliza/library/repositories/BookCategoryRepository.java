package com.kuliza.library.repositories;

import com.kuliza.library.entities.BookCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
}
