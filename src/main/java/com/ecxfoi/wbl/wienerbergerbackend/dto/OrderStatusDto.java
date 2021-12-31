package com.ecxfoi.wbl.wienerbergerbackend.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderStatusDto
{
    private long id;
    private String status;

    public OrderStatusDto()
    {
    }

    public OrderStatusDto(final long id, final String status)
    {
        this.id = id;
        this.status = status;
    }

    public long getId()
    {
        return id;
    }

    public void setId(final long id)
    {
        this.id = id;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(final String status)
    {
        this.status = status;
    }
}