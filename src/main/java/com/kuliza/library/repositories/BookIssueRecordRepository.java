package com.kuliza.library.repositories;

import com.kuliza.library.entities.BookIssueRecord;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookIssueRecordRepository extends CrudRepository<BookIssueRecord, Long> {
}
