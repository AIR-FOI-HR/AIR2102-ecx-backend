package com.ecxfoi.wbl.wienerbergerbackend.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "users")
public class User
{
    @Id
    @GeneratedValue
    @Column(name = "ID_USER", nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "USERNAME", nullable = false, length = 45)
    private String name;

    @Column(name = "PASSWORD", length = 64)
    private String password;

    @Column(name = "EMAIL", length = 200)
    private String email;

    @Column(name = "AGE")
    private int age;

    public UUID getId()
    {
        return id;
    }

    public void setId(final UUID id)
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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(final int age)
    {
        this.age = age;
    }
}
