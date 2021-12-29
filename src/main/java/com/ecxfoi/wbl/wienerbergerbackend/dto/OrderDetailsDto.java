package com.ecxfoi.wbl.wienerbergerbackend.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderDetailsDto
{
    private Long id;
    private String name;
    private String status;
    private Date date;
    private String paymentMethod;
    private String currency;
    private Date deliveryDate;
    private String additionalProjectInfo;

    public OrderDetailsDto()
    {
    }

    public OrderDetailsDto(Long id, final String name, final String status, final Date date, final String paymentMethod, final String currency, final Date deliveryDate, final String additionalProjectInfo)
    {
        this.id = id;
        this.name = name;
        this.status = status;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.currency = currency;
        this.deliveryDate = deliveryDate;
        this.additionalProjectInfo = additionalProjectInfo;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
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

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(final String currency)
    {
        this.currency = currency;
    }

    public Date getDeliveryDate()
    {
        return deliveryDate;
    }

    public void setDeliveryDate(final Date deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }

    public String getAdditionalProjectInfo()
    {
        return additionalProjectInfo;
    }

    public void setAdditionalProjectInfo(final String additionalProjectInfo)
    {
        this.additionalProjectInfo = additionalProjectInfo;
    }
}