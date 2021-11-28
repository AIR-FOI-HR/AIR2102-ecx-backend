package com.ecxfoi.wbl.wienerbergerbackend.models;

import java.io.Serializable;

public class WienerbergerResponse implements Serializable
{
    final private boolean success;
    final private String message;
    final private WienerbergerResponseData data;

    public WienerbergerResponse(final boolean success, final String message, final WienerbergerResponseData data)
    {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public WienerbergerResponseData getData()
    {
        return data;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public String getMessage()
    {
        return message;
    }
}