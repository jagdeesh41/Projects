package com.thinkify.tapido.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling
{
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handler(RideNotFoundException rideNotFoundException)
    {
        ExceptionResponse exception=new ExceptionResponse(rideNotFoundException.getMessage(),System.currentTimeMillis(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
    }

}
