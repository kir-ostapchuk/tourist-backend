package com.ostapchuk.backend.tourist.handler;

import com.ostapchuk.backend.tourist.exception.EntityNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public String methodArgumentNotValidException(final EntityNotFoundException ex) {
        return ex.getMessage();
    }
}
