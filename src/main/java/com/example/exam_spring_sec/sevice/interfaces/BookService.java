package com.example.exam_spring_sec.sevice.interfaces;

import com.example.exam_spring_sec.dto.BookDto;
import com.example.exam_spring_sec.model.Book;
import org.springframework.http.HttpEntity;


import java.util.UUID;

public interface BookService {

    HttpEntity getAllBooks(int size, int page, String search, String sort, boolean direction);

    HttpEntity getBookById(UUID id);

    HttpEntity addBook(Book bookDto);

    HttpEntity editBook(UUID id, Book bookDto);

    HttpEntity saveBook(BookDto bookDto);

    HttpEntity deleteBookById(UUID id);


}
