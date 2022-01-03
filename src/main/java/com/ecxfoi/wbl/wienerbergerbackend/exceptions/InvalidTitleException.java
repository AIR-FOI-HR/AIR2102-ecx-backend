package com.ecxfoi.wbl.wienerbergerbackend.exceptions;

public class InvalidTitleException extends Exception
{
    private final String message;

    public InvalidTitleException(String message)
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