package com.Lesson3.exeptions;

public class BadRequestException extends Exception{
    public BadRequestException(String message) {
        super(message);
    }
}
