package com.thinkify.tapido.Exceptions;
import org.springframework.http.HttpStatus;
public class ExceptionResponse
{
    private String message;
    private long timestamp;
    private HttpStatus statusCode;

    public ExceptionResponse(String message, long timestamp, HttpStatus statusCode)
    {
        this.message = message;
        this.timestamp = timestamp;
        this.statusCode = statusCode;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatusCode()
    {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode)
    {
        this.statusCode = statusCode;
    }
}
