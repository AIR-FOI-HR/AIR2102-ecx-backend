package com.ecxfoi.wbl.wienerbergerbackend.models;

import com.ecxfoi.wbl.wienerbergerbackend.entities.User;

public class UserModel
{
    public String title;
    public String first_name;
    public String last_name;
    public String phone_number;
    public String fax_number;
    public String email;

    public UserModel(User user)
    {
        this.title = user.getTitle();
        this.first_name = user.getFirstName();
        this.last_name = user.getLastName();
        this.phone_number = user.getPhoneNumber();
        this.fax_number = user.getFaxNumber();
        this.email = user.getEmail();
    }
}