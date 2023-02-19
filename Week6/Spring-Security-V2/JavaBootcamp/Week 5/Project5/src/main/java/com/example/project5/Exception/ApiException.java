package com.example.project5.Exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}