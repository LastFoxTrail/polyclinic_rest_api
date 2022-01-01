package com.lis.projects.exception.handler;

import com.lis.projects.exception.GetDoubleArgumentException;
import com.lis.projects.exception.json_formatter.IncorrectRequestData;
import com.lis.projects.exception.UndefinedRequestBodyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.lis.projects.exception.EmptyCollectionException;
import com.lis.projects.exception.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class EntityGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectRequestData> handleException(Exception exception) {
        IncorrectRequestData response = new IncorrectRequestData(exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectRequestData> handleException(EntityNotFoundException exception) {
        IncorrectRequestData response = new IncorrectRequestData(exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectRequestData> handleException(EmptyCollectionException exception) {
        IncorrectRequestData response = new IncorrectRequestData(exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectRequestData> handleException(UndefinedRequestBodyException exception) {
        IncorrectRequestData response = new IncorrectRequestData(exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectRequestData> handleException(GetDoubleArgumentException exception) {
        IncorrectRequestData response = new IncorrectRequestData(exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
