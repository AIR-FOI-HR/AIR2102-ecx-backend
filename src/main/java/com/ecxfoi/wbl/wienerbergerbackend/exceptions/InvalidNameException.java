package com.ecxfoi.wbl.wienerbergerbackend.exceptions;

public class InvalidNameException extends Exception
{
    private final String message;

    public InvalidNameException(String message)
    {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}