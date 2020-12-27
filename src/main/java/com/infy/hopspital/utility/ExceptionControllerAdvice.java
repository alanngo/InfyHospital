package com.infy.hopspital.utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // exception handler
@Slf4j // gives us a logger
public class ExceptionControllerAdvice
{
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorInfo> handleGeneralException(Exception e)
    {
        log.error(e.getMessage());
        ErrorInfo error = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ErrorInfo> handleNullPointerException(NullPointerException e)
    {
        log.error(e.getMessage());
        ErrorInfo error = new ErrorInfo(HttpStatus.NOT_FOUND.value(), "NullPointerException");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
