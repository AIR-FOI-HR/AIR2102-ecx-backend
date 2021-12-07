package com.ecxfoi.wbl.wienerbergerbackend.models;

import com.ecxfoi.wbl.wienerbergerbackend.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserModel
{
    @JsonIgnore
    public Long id;
    public String title;
    public String first_name;
    public String last_name;
    public String phone_number;
    public String fax_number;
    public String email;

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