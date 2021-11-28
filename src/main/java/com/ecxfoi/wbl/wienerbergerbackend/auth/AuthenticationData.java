package com.ecxfoi.wbl.wienerbergerbackend.auth;

import java.io.Serializable;

public class AuthenticationData implements Serializable
{
    public final String jwt;

    public AuthenticationData(String jwt)
    {
        this.jwt = jwt;
    }
}