package com.lis.projects.exception;

public class UndefinedRequestBodyException extends RuntimeException {

    public UndefinedRequestBodyException(String message) {
        super(message);
    }
}
