package com.ecxfoi.wbl.wienerbergerbackend.models;

import com.ecxfoi.wbl.wienerbergerbackend.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserModel
{
    @JsonIgnore
    private Long id;
    private String title;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String fax_number;
    private String email;

    public void setId(final Long id)
    {
        this.id = id;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public void setFirst_name(final String first_name)
    {
        this.first_name = first_name;
    }

    public void setLast_name(final String last_name)
    {
        this.last_name = last_name;
    }

    public void setPhone_number(final String phone_number)
    {
        this.phone_number = phone_number;
    }

    public void setFax_number(final String fax_number)
    {
        this.fax_number = fax_number;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public UserModel(User user)
    {
        this.id = user.getId();
        this.title = user.getTitle();
        this.first_name = user.getFirstName();
        this.last_name = user.getLastName();
        this.phone_number = user.getPhoneNumber();
        this.fax_number = user.getFaxNumber();
        this.email = user.getEmail();
    }

    public Long getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public String getLast_name()
    {
        return last_name;
    }

    public String getPhone_number()
    {
        return phone_number;
    }

    public String getFax_number()
    {
        return fax_number;
    }

    public String getEmail()
    {
        return email;
    }

    public UserModel(final String title, final String first_name, final String last_name, final String phone_number, final String fax_number, final String email)
    {
        this.title = title;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.fax_number = fax_number;
        this.email = email;
    }
}