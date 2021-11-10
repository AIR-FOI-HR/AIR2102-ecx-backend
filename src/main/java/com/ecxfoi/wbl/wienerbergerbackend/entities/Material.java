package com.ecxfoi.wbl.wienerbergerbackend.entities;

import javax.persistence.*;

@Entity
public class Material
{
    @Id
    @GeneratedValue
    @Column(name = "material_number", nullable = false)
    private Long materialNumber;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private Float cost;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "quantity_designation", length = 5)
    private String quantityDesignation;

    public String getQuantityDesignation()
    {
        return quantityDesignation;
    }

    public void setQuantityDesignation(String quantityDesignation)
    {
        this.quantityDesignation = quantityDesignation;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Float getCost()
    {
        return cost;
    }

    public void setCost(Float cost)
    {
        this.cost = cost;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
