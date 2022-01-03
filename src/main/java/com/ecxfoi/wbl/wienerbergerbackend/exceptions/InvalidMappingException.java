package com.ecxfoi.wbl.wienerbergerbackend.exceptions;

public class InvalidMappingException extends Exception
{
    private final String message;

    public InvalidMappingException(String message)
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
