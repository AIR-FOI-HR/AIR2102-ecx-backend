package com.ecxfoi.wbl.wienerbergerbackend.auth;

import com.ecxfoi.wbl.wienerbergerbackend.models.WienerbergerResponseData;

public class AuthenticationException implements WienerbergerResponseData
{
    public Throwable cause;
    public Throwable[] suppressed;

    AuthenticationException(Exception exception)
    {
        this.suppressed = exception.getSuppressed();
        this.cause = exception.getCause();
    }
}
