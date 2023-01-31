package com.example.homework17.Exception;

public class ApiException extends RuntimeException{
    private int status;
    public ApiException(String message, int status){
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
