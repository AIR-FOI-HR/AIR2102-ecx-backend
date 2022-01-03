package com.ecxfoi.wbl.wienerbergerbackend.exceptions;

public class InvalidPhoneNumberException extends Exception
{
    private final String message;

    public InvalidPhoneNumberException(String message)
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