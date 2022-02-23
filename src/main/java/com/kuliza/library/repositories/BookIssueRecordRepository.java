package com.kuliza.library.repositories;

import com.kuliza.library.entities.BookIssueRecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookIssueRecordRepository extends JpaRepository<BookIssueRecord, Long> {
}
