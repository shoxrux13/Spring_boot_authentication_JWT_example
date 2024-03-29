package com.example.exam_spring_sec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {
    private String name;
    private Double price;
}
