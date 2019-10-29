package com.jalasoft.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jalasoft.crud.model.Book;
import com.jalasoft.crud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalasoft.crud.exception.RecordNotFoundException;

@Service
public class BookService {
     
    @Autowired
    BookRepository repository;
     
    public List<Book> getAllBooks()
    {
        List<Book> booksList = repository.findAll();
         
        if(booksList.size() > 0) {
            return booksList;
        } else {
            return new ArrayList<Book>();
        }
    }
     
    public Book getBook(Long id) throws RecordNotFoundException
    {
        Optional<Book> book = repository.findById(id);
         
        if(book.isPresent()) {
            return book.get();
        } else {
            throw new RecordNotFoundException("There is not a book with that id");
        }
    }
     
    public Book updateBook(Book entity) throws RecordNotFoundException
    {
        Optional<Book> book = repository.findById(entity.getId());
         
        if(book.isPresent())
        {
            Book newEntity = book.get();
            newEntity.setGenre(entity.getGenre());
            newEntity.setTitle(entity.getTitle());
            newEntity.setAuthor(entity.getAuthor());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteBook(Long id) throws RecordNotFoundException
    {
        Optional<Book> book = repository.findById(id);
         
        if(book.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("There is not a book with that id");
        }
    }
}