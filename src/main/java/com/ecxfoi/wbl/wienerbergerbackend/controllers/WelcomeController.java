package com.ecxfoi.wbl.wienerbergerbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController
{
    @GetMapping(value = "/wienerberger")
    public String getWelcome()
    {
        return "Welcome to Wienerberger";
    }
}