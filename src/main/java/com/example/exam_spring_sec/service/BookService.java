package com.example.exam_spring_sec.service;

import com.example.exam_spring_sec.dto.BookDto;
import com.example.exam_spring_sec.model.Book;
import com.example.exam_spring_sec.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public HttpEntity<?> editBook(Integer id, BookDto bookDto) {
        Optional<Book> bookById = bookRepository.findById(id);
        if(bookById.isPresent()){
            Book editBook = bookById.get();
            editBook.setName(bookDto.getName());
            editBook.setPrice(bookDto.getPrice());

            return ResponseEntity.ok(editBook);
        }
        return ResponseEntity.notFound().build();

    }


    public HttpEntity<?> deleteBook(Integer id) {
        if(id !=null) {
            bookRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        else return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    public HttpEntity<?> getBookById(Integer id) {
        if(id !=null){
            return ResponseEntity.ok(bookRepository.findById(id));
        }
        return ResponseEntity.badRequest().build();
    }

    public HttpEntity<?> addBook(Book book) {
        return ResponseEntity.ok(bookRepository.save(book));
    }
}
