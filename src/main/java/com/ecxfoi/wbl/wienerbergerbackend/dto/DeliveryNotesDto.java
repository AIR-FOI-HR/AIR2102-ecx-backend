package com.ecxfoi.wbl.wienerbergerbackend.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DeliveryNotesDto
{
    private Long id;
    private Long orderId;
    private String ShipToParty;
    private String deliveryAddress;
    private String deliveredDate;

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public Long getOrderId()
    {
        return orderId;
    }

    public void setOrderId(final Long orderId)
    {
        this.orderId = orderId;
    }

    public String getShipToParty()
    {
        return ShipToParty;
    }

    public void setShipToParty(final String shipToParty)
    {
        ShipToParty = shipToParty;
    }

    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }

    public void setDeliveryAddress(final String deliveryAddress)
    {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveredDate()
    {
        return deliveredDate;
    }

    public void setDeliveredDate(final String deliveredDate)
    {
        this.deliveredDate = deliveredDate;
    }
}