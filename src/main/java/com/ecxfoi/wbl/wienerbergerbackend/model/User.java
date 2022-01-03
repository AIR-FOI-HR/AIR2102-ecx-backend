package com.ecxfoi.wbl.wienerbergerbackend.model;

import com.ecxfoi.wbl.wienerbergerbackend.exceptions.InvalidEmailException;
import com.ecxfoi.wbl.wienerbergerbackend.exceptions.InvalidNameException;
import com.ecxfoi.wbl.wienerbergerbackend.exceptions.InvalidPhoneNumberException;
import com.ecxfoi.wbl.wienerbergerbackend.exceptions.InvalidTitleException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @ManyToMany(mappedBy = "users")
    private Set<Customer> customers = new HashSet<>();

    @Column(name = "email", length = 320)
    private String email;

    /**
     * 30 chars for Salt, 64 Chars for SHA256 hash and 1 char for a dot in-between.
     * If hash is: HaSHzV341Aj, and salt is sAlT30, it should look like:
     * sAlT30.HaSHzV341Aj
     */
    @Column(name = "password", length = 69)
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

    public void setFaxNumber(String faxNumber) throws InvalidPhoneNumberException
    {
        if (StringUtils.length(faxNumber) == 0)
        {
            throw new InvalidPhoneNumberException("Fax number not provided!");
        }
        if (StringUtils.length(faxNumber) > 15)
        {
            throw new InvalidPhoneNumberException("Fax number is too long!");
        }
        if (StringUtils.length(faxNumber) < 5)
        {
            throw new InvalidPhoneNumberException("Fax number is too short!");
        }
        this.faxNumber = faxNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    @Test
    public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException
    {
        String patterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches())
        {
            this.phoneNumber = phoneNumber;
        }
        else
        {
            throw new InvalidPhoneNumberException("Phone number is wrong!");
        }
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName) throws InvalidNameException
    {
        if (StringUtils.length(lastName) == 0)
        {
            throw new InvalidNameException("Last name not provided!");
        }
        if (StringUtils.length(lastName) > 69)
        {
            throw new InvalidNameException("Last name is too long!");
        }
        if (StringUtils.length(lastName) < 3)
        {
            throw new InvalidNameException("Last name is too short!");
        }
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName) throws InvalidNameException
    {
        if (StringUtils.length(firstName) == 0)
        {
            throw new InvalidNameException("First name not provided!");
        }
        if (StringUtils.length(firstName) > 30)
        {
            throw new InvalidNameException("First name is too long!");
        }
        if (StringUtils.length(firstName) < 2)
        {
            throw new InvalidNameException("First name is too short!");
        }
        this.firstName = firstName;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title) throws InvalidTitleException
    {
        if (StringUtils.length(title) == 0)
        {
            throw new InvalidTitleException("Title not provided!");
        }
        if (StringUtils.length(title) > 15)
        {
            throw new InvalidTitleException("Title is too long!");
        }
        if (StringUtils.length(title) == 0)
        {
            throw new InvalidTitleException("Title not provided!");
        }
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

    public void setEmail(String email) throws InvalidEmailException
    {
        if (StringUtils.length(email) == 0)
        {
            throw new InvalidEmailException("Email is not provided");
        }
        if (StringUtils.length(email) > 320)
        {
            throw new InvalidEmailException("Email is too long!");
        }
        if (StringUtils.length(email) < 5)
        {
            throw new InvalidEmailException("Email is too short!");
        }
        if (!StringUtils.contains(email, '@'))
        {
            throw new InvalidEmailException("Email not valid.");
        }
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