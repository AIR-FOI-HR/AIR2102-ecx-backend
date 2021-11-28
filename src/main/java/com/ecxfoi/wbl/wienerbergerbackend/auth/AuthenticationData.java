package com.ecxfoi.wbl.wienerbergerbackend.auth;

public class AuthenticationData
{
    public final String jwt;

    public AuthenticationData(String jwt)
    {
        this.jwt = jwt;
    }
}