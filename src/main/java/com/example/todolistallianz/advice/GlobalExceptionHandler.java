package com.example.todolistallianz.advice;

import com.example.todolistallianz.advice.exception.JobNotFoundException;
import com.example.todolistallianz.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound(JobNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                new Date().getTime());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
