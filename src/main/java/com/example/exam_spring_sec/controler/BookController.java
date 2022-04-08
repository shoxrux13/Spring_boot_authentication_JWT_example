package com.example.exam_spring_sec.controler;

import com.example.exam_spring_sec.dto.BookDto;
import com.example.exam_spring_sec.model.Book;
import com.example.exam_spring_sec.payload.ApiResponse;
import com.example.exam_spring_sec.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public HttpEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    //    @Secured({"ROLE_ADMIN"})
    @PostMapping
    public HttpEntity<?> addNewBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping()
    public HttpEntity<?> editBook(@PathVariable Integer id, BookDto bookDto) {
        return ResponseEntity.ok(bookService.editBook(id, bookDto));
    }

    //    @Secured("ROLE_SUPER_ADMIN")
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteBook(@PathVariable Integer id) {
        ApiResponse response = new ApiResponse();
        try {
            bookService.deleteBook(id);
            response.setSuccess(true);
            response.setMassage("Success");
        } catch (Exception e) {
            response.setMassage(e.getMessage());
            response.setSuccess(false);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getBookById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
}
