package com.ecxfoi.wbl.wienerbergerbackend.auth;

import java.io.Serializable;

public class AuthenticationErrorData implements Serializable
{
    private Throwable cause;
    private Throwable[] suppressed;

    public AuthenticationErrorData(Exception exception)
    {
        this.suppressed = exception.getSuppressed();
        this.cause = exception.getCause();
    }

    public Throwable getCause()
    {
        return cause;
    }

    public void setCause(final Throwable cause)
    {
        this.cause = cause;
    }

    public Throwable[] getSuppressed()
    {
        return suppressed;
    }

    public void setSuppressed(final Throwable[] suppressed)
    {
        this.suppressed = suppressed;
    }
}