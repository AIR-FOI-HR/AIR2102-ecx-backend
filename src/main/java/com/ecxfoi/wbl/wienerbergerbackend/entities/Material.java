package com.ecxfoi.wbl.wienerbergerbackend.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "materials")
public class Material
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material", nullable = false)
    private Long materialNumber;

    @ManyToMany(mappedBy = "materials")
    private Set<Order> orders = new HashSet<Order>();

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

    public Set<Order> getOrders()
    {
        return orders;
    }

    public void addOrders(Order order)
    {
        this.orders.add(order);
        order.getMaterials().add(this);
    }

    public void removeUser(Order order)
    {
        this.orders.remove(order);
        order.getMaterials().remove(this);
    }

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
