package com.example.day3;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Response {

    private String message;
    private Integer status;
}
