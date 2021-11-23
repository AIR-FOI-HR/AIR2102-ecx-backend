package com.ecxfoi.wbl.wienerbergerbackend.auth;

import com.ecxfoi.wbl.wienerbergerbackend.models.Data;

public class AuthenticationResponse implements Data
{
    public final String jwt;

    public AuthenticationResponse(String jwt)
    {
        this.jwt = jwt;
    }
}