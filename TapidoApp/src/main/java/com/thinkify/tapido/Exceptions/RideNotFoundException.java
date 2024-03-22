package com.thinkify.tapido.Exceptions;

public class RideNotFoundException extends RuntimeException
{
    public RideNotFoundException(String message)
    {
        super(message);
    }
}
