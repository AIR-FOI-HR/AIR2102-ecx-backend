package com.ecxfoi.wbl.wienerbergerbackend.auth;

import com.ecxfoi.wbl.wienerbergerbackend.models.WienerbergerResponseData;

public class AuthenticationData implements WienerbergerResponseData
{
    public final String jwt;

    public AuthenticationData(String jwt)
    {
        this.jwt = jwt;
    }
}