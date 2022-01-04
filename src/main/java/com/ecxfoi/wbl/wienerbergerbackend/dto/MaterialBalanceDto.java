package com.ecxfoi.wbl.wienerbergerbackend.dto;

public class MaterialBalanceDto
{
    private String name;
    private Float cost;
    private Integer quantity;
    private Long materialNumber;

    public MaterialBalanceDto()
    {
    }

    public MaterialBalanceDto(final String name, final Float cost, final Integer quantity, final Long materialNumber)
    {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.materialNumber = materialNumber;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public Float getCost()
    {
        return cost;
    }

    public void setCost(final Float cost)
    {
        this.cost = cost;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(final Integer quantity)
    {
        this.quantity = quantity;
    }

    public Long getMaterialNumber()
    {
        return materialNumber;
    }

    public void setMaterialNumber(final Long materialNumber)
    {
        this.materialNumber = materialNumber;
    }
}
