package com.example.day1.Exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}