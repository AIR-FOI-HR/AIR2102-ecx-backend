package com.ecxfoi.wbl.wienerbergerbackend.response;

public class WienerbergerResponse<T>
{
    private final boolean success;
    private final String message;
    private final T data;

    public WienerbergerResponse(final boolean success, final String message, final T data)
    {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public T getData()
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