package com.ecxfoi.wbl.wienerbergerbackend.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
public class User
{
    @Id
    @GeneratedValue
    @Column(name = "id_user", nullable = false)
    private Long id;

    @ManyToMany(mappedBy = "users")
    private Set<Customer> customers = new HashSet<Customer>();

    @Column(name = "email", length = 320)
    private String email;

    /**
     * 30 chars for Salt, 64 Chars for SHA256 hash and 1 char for a dot in-between.
     * If hash is: HaSHzV341Aj, and salt is sAlT30, it should look like:
     * sAlT30.HaSHzV341Aj
     */
    @Column(name = "password", length = 95)
    private String password;

    @Column(name = "title", length = 15)
    private String title;

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "fax_number", length = 15)
    private String faxNumber;


    public void addCustomer(Customer customer)
    {
        this.customers.add(customer);
        customer.getUsers().add(this);
    }

    public void removeCustomer(Customer customer)
    {
        this.customers.remove(customer);
        customer.getUsers().remove(this);
    }

    public Set<Customer> getCustomers()
    {
        return customers;
    }

    public void setCustomers(final Set<Customer> customer)
    {
        this.customers = customer;
    }

    public String getFaxNumber()
    {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber)
    {
        this.faxNumber = faxNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPass()
    {
        return password;
    }

    public void setPass(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
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
