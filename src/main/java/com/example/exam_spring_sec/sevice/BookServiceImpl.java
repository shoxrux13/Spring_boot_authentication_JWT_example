package com.example.exam_spring_sec.sevice;

import com.example.exam_spring_sec.dto.BookDto;
import com.example.exam_spring_sec.model.Book;
import com.example.exam_spring_sec.repository.BookRepository;
import com.example.exam_spring_sec.sevice.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;


    @Override
    public HttpEntity getAllBooks(int size, int page, String search, String sort, boolean direction) {
        return null;
    }

    @Override
    public HttpEntity getBookById(UUID id) {
        return null;
    }

    @Override
    public HttpEntity addBook(Book bookDto) {
        return null;
    }

    @Override
    public HttpEntity editBook(UUID id, Book bookDto) {
        return null;
    }

    @Override
    public HttpEntity saveBook(BookDto bookDto) {
        return null;
    }

    @Override
    public HttpEntity deleteBookById(UUID id) {
        return null;
    }
}
