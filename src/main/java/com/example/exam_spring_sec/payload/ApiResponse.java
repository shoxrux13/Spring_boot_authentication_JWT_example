package com.example.exam_spring_sec.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {

    Object data;

    String massage;

    boolean isSuccess;
}
