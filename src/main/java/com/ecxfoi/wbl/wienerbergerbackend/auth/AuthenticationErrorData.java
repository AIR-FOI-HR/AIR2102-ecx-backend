package com.ecxfoi.wbl.wienerbergerbackend.auth;

import java.io.Serializable;

public class AuthenticationErrorData implements Serializable
{
    public Throwable cause;
    public Throwable[] suppressed;

    AuthenticationErrorData(Exception exception)
    {
        this.suppressed = exception.getSuppressed();
        this.cause = exception.getCause();
    }
}