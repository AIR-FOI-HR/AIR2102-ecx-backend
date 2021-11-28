package com.ecxfoi.wbl.wienerbergerbackend.auth;

import java.io.Serializable;

public class AuthenticationException implements Serializable
{
    public Throwable cause;
    public Throwable[] suppressed;

    AuthenticationException(Exception exception)
    {
        this.suppressed = exception.getSuppressed();
        this.cause = exception.getCause();
    }
}