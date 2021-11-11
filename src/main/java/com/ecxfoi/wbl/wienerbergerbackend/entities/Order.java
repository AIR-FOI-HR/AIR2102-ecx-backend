package com.ecxfoi.wbl.wienerbergerbackend.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Long idOrder;

    @ManyToOne
    @JoinColumn(name = "customer_po_number", referencedColumnName = "id_customer")
    private Customer customerPONumber;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "orders_materials", joinColumns = {@JoinColumn(name = "id_order")}, inverseJoinColumns = {@JoinColumn(name = "id_material")})
    private Set<Material> materials = new HashSet<Material>();

    @Temporal(TemporalType.DATE)
    @Column(name = "document_date")
    private Date documentDate;

    @Column(name = "status")
    private String status;

    @Column(name = "currency", length = 3)
    private String currency;

    @Lob
    @Column(name = "payment_term")
    private String paymentTerm;

    @Temporal(TemporalType.DATE)
    @Column(name = "wish_delivery_date")
    private Date wishDeliveryDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "first_possible_date")
    private Date firstPossibleDate;

    @Column(name = "net_worth")
    private Float netWorth;

    @Lob
    @Column(name = "additional_project_info")
    private String additionalProjectInfo;

    @Column(name = "incoterm", length = 2)
    private String incoterm;

    public String getIncoterm()
    {
        return incoterm;
    }

    public void setIncoterm(String incoterm)
    {
        this.incoterm = incoterm;
    }

    public String getAdditionalProjectInfo()
    {
        return additionalProjectInfo;
    }

    public void setAdditionalProjectInfo(String additionalProjectInfo)
    {
        this.additionalProjectInfo = additionalProjectInfo;
    }

    public Float getNetWorth()
    {
        return netWorth;
    }

    public void setNetWorth(Float netWorth)
    {
        this.netWorth = netWorth;
    }

    public Date getFirstPossibleDate()
    {
        return firstPossibleDate;
    }

    public void setFirstPossibleDate(Date firstPossibleDate)
    {
        this.firstPossibleDate = firstPossibleDate;
    }

    public Date getWishDeliveryDate()
    {
        return wishDeliveryDate;
    }

    public void setWishDeliveryDate(Date wishDeliveryDate)
    {
        this.wishDeliveryDate = wishDeliveryDate;
    }

    public String getPaymentTerm()
    {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm)
    {
        this.paymentTerm = paymentTerm;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Set<Material> getMaterials()
    {
        return materials;
    }

    public void addMaterials(Material material)
    {
        this.materials.add(material);
        material.getOrders().add(this);
    }

    public void removeUser(Material material)
    {
        this.materials.remove(material);
        material.getOrders().remove(this);
    }

    public Date getDocumentDate()
    {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate)
    {
        this.documentDate = documentDate;
    }

    public Customer getCustomerPONumber()
    {
        return customerPONumber;
    }

    public void setCustomerPONumber(Customer customerPONumber)
    {
        this.customerPONumber = customerPONumber;
    }

    public Long getOrderNumber()
    {
        return idOrder;
    }

    public void setOrderNumber(Long orderNumber)
    {
        this.idOrder = orderNumber;
    }
}
