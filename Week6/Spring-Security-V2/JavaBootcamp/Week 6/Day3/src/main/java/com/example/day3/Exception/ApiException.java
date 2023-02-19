package com.example.day3.Exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}