package com.ecxfoi.wbl.wienerbergerbackend.dto;

public class CustomerDto
{

    private Long id;
    private String name;
    private String addressStreet;
    private String addressPostCode;
    private String addressCity;
    private String addressCountryCode;

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getAddressStreet()
    {
        return addressStreet;
    }

    public void setAddressStreet(final String addressStreet)
    {
        this.addressStreet = addressStreet;
    }

    public String getAddressPostCode()
    {
        return addressPostCode;
    }

    public void setAddressPostCode(final String addressPostCode)
    {
        this.addressPostCode = addressPostCode;
    }

    public String getAddressCity()
    {
        return addressCity;
    }

    public void setAddressCity(final String addressCity)
    {
        this.addressCity = addressCity;
    }

    public String getAddressCountryCode()
    {
        return addressCountryCode;
    }

    public void setAddressCountryCode(final String addressCountryCode)
    {
        this.addressCountryCode = addressCountryCode;
    }
}