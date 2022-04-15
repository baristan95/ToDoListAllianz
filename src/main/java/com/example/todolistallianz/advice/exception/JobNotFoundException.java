package com.example.todolistallianz.advice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class JobNotFoundException extends RuntimeException{

    public JobNotFoundException() {
        super("Job Not Found");
    }
}
