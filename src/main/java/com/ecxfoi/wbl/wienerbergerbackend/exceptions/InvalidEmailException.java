package com.ecxfoi.wbl.wienerbergerbackend.exceptions;

public class InvalidEmailException extends Exception
{
    private final String message;

    public InvalidEmailException(String message)
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
