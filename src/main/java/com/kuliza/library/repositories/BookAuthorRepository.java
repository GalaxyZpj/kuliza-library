package com.kuliza.library.repositories;

import com.kuliza.library.entities.BookAuthor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {
}
