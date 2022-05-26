package com.example.udaan.exception;

public class DealIdNotFoundException extends RuntimeException {
    public DealIdNotFoundException(String message) {
        super(message);
    }
}
