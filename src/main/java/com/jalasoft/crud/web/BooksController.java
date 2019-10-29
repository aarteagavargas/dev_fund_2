package com.jalasoft.crud.web;

import java.util.List;

import com.jalasoft.crud.exception.RecordNotFoundException;
import com.jalasoft.crud.model.Book;
import com.jalasoft.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController
{
    @Autowired
    BookService service;
 
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = service.getAllBooks();
 
        return new ResponseEntity<List<Book>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        Book entity = service.getBook(id);
 
        return new ResponseEntity<Book>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Book> updateBook(Book book)
                                                    throws RecordNotFoundException {
        Book updated = service.updateBook(book);
        return new ResponseEntity<Book>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteBookById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteBook(id);
        return HttpStatus.FORBIDDEN;
    }
 
}