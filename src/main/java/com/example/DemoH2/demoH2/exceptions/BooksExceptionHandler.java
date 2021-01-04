package com.example.DemoH2.demoH2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.awt.print.Book;

@ControllerAdvice
public class BooksExceptionHandler {

    @ExceptionHandler(value = BookNotFound.class)
    public ResponseEntity<Object> exception (BookNotFound B) {
        return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BookIsAlreadyInStack.class)
    public ResponseEntity<Object> exception (BookIsAlreadyInStack BS) {
        return new ResponseEntity<>("Book is already in stack", HttpStatus.ALREADY_REPORTED);
    }
}
