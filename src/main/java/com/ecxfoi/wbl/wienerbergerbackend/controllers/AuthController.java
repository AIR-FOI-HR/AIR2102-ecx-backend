package com.ecxfoi.wbl.wienerbergerbackend.controllers;

import com.ecxfoi.wbl.wienerbergerbackend.auth.AuthenticationData;
import com.ecxfoi.wbl.wienerbergerbackend.auth.AuthenticationErrorData;
import com.ecxfoi.wbl.wienerbergerbackend.auth.AuthenticationRequest;
import com.ecxfoi.wbl.wienerbergerbackend.response.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController
{
    private final AuthService authService;

    public AuthController(@Autowired AuthService authService)
    {
        this.authService = authService;
    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody AuthenticationRequest authenticationRequest)
    {
        try
        {
            String jwt = authService.authenticateUser(authenticationRequest.getEmail(), authenticationRequest.getPassword());

            if (StringUtils.isNotEmpty(jwt))
            {
                return ResponseEntity.ok(new WienerbergerResponse<>(true, "Success!", new AuthenticationData(jwt)));
            }
            else
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", new AuthenticationData(jwt)));
            }
        }
        catch (Exception ex)
        {
            System.out.println("- Error logging in");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new WienerbergerResponse<>(false, "There was an error on our side, please try again later.", new AuthenticationErrorData(ex)));
        }
    }
}