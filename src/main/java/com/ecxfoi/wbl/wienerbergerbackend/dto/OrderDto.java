package com.ecxfoi.wbl.wienerbergerbackend.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderDto
{
    private Long id;
    private String status;
    private Date date;
    private String paymentMethod;
    private Date deliveryDate;

    public OrderDto()
    {
    }

    public OrderDto(final Long id, final String status, final Date date, final String paymentMethod, final Date deliveryDate)
    {
        this.id = id;
        this.status = status;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.deliveryDate = deliveryDate;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
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

    public Date getDate()
    {
        return date;
    }

    public void setDate(final Date date)
    {
        this.date = date;
    }

    public String getPaymentMethod()
    {
        return paymentMethod;
    }

    public void setPaymentMethod(final String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public Date getDeliveryDate()
    {
        return deliveryDate;
    }

    public void setDeliveryDate(final Date deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }
}