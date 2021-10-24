package com.ecxfoi.wbl.wienerbergerbackend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @RequestMapping(value = "/wienerberger", method = RequestMethod.GET)
    public String getWelcome() {
        return "Welcome to Wienerberger";
    }
}