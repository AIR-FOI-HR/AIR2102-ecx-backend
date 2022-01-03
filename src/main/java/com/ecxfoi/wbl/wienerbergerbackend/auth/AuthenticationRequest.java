package com.ecxfoi.wbl.wienerbergerbackend.auth;

public class AuthenticationRequest
{
    private final String password;
    private final String email;

    public AuthenticationRequest(final String password, final String email)
    {
        this.password = password;
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }
}