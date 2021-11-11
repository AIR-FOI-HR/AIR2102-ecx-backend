package com.ecxfoi.wbl.wienerbergerbackend.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "customers")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer", nullable = false)
    private Long id;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "users_customers", joinColumns = {@JoinColumn(name = "id_customer")}, inverseJoinColumns = {@JoinColumn(name = "id_user")})
    private Set<User> users = new HashSet<User>();

    @Column(name = "name")
    private String name;

    @Column(name = "parw", length = 2)
    private String parw;

    @Column(name = "approved")
    private Character approved;

    @Column(name = "address_street")
    private String addressStreet;

    @Column(name = "address_post_code", length = 15)
    private String addressPostCode;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name = "address_country_code", length = 2)
    private String addressCountryCode;

    public Set<User> getUsers()
    {
        return users;
    }

    public void addUser(User user)
    {
        this.users.add(user);
        user.getCustomers().add(this);
    }

    public void removeUser(User user)
    {
        this.users.remove(user);
        user.getCustomers().remove(this);
    }

    public String getAddressCountryCode()
    {
        return addressCountryCode;
    }

    public void setAddressCountryCode(String addressCountryCode)
    {
        this.addressCountryCode = addressCountryCode;
    }

    public String getAddressCity()
    {
        return addressCity;
    }

    public void setAddressCity(String addressCity)
    {
        this.addressCity = addressCity;
    }

    public String getAddressPostCode()
    {
        return addressPostCode;
    }

    public void setAddressPostCode(String addressPostCode)
    {
        this.addressPostCode = addressPostCode;
    }

    public String getAddressStreet()
    {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet)
    {
        this.addressStreet = addressStreet;
    }

    public Character getApproved()
    {
        return approved;
    }

    public void setApproved(Character approved)
    {
        this.approved = approved;
    }

    public String getParw()
    {
        return parw;
    }

    public void setParw(String parw)
    {
        this.parw = parw;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
