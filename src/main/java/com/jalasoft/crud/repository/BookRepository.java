package com.jalasoft.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalasoft.crud.model.Book;
 
@Repository
public interface BookRepository
        extends JpaRepository<Book, Long> {
 
}
