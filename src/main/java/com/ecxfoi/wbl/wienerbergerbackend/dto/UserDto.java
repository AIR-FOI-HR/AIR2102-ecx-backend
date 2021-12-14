package com.ecxfoi.wbl.wienerbergerbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDto
{
    @JsonIgnore
    private Long id;
    private String title;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String faxNumber;
    private String email;

    public UserDto()
    {
    }

    public UserDto(final String title, final String firstName, final String lastName, final String phoneNumber, final String faxNumber, final String email)
    {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.email = email;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName)
    {
        this.lastName = lastName;
    }

    public void setPhoneNumber(final String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setFaxNumber(final String faxNumber)
    {
        this.faxNumber = faxNumber;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public Long getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getFaxNumber()
    {
        return faxNumber;
    }

    public String getEmail()
    {
        return email;
    }

}