package com.ecxfoi.wbl.wienerbergerbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "delivery_notes")
public class DeliveryNotes
{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id_order")
    Order order;

    @ManyToOne
    @JoinColumn(name = "party_id_customer")
    Customer party;

    @Temporal(TemporalType.DATE)
    @Column(name = "delivery_date")
    private Date deliveryDate;

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public Date getDeliveryDate()
    {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }

    public Customer getParty()
    {
        return party;
    }

    public void setParty(Customer party)
    {
        this.party = party;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }
}