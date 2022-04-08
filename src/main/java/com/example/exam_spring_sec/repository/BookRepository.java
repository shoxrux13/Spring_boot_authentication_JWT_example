package com.example.exam_spring_sec.repository;

import com.example.exam_spring_sec.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book,Integer> {
}
