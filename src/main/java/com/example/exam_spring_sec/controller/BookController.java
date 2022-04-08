package com.example.exam_spring_sec.controller;


import com.example.exam_spring_sec.sevice.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.example.exam_spring_sec.utils.Constant.DEFAULT_PAGE_SIZE;


@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping
    public HttpEntity getAllMovies(
            @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "search", defaultValue = "") String search,
            @RequestParam(name = "sort", defaultValue = "title") String sort,
            @RequestParam(name = "direction", defaultValue = "true") boolean direction
    ) {
        return bookService.getAllBooks(size, page, search, sort, direction);
    }


    @GetMapping("/{id}")
    public HttpEntity getBookById(@PathVariable UUID id) {
        return bookService.getBookById(id);
    }


    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HttpEntity saveBook() {
        return ResponseEntity.ok("New book has been saved...!!");
    }

}
