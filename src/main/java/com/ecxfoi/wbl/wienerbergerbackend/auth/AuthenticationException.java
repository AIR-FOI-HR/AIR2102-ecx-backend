package com.ecxfoi.wbl.wienerbergerbackend.auth;

import com.ecxfoi.wbl.wienerbergerbackend.models.Data;

public class AuthenticationException implements Data
{
    public Throwable cause;
    public Throwable[] suppressed;

    AuthenticationException(Exception exception)
    {
        this.suppressed = exception.getSuppressed();
        this.cause = exception.getCause();
    }
}
