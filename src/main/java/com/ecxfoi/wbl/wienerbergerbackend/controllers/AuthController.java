package com.ecxfoi.wbl.wienerbergerbackend.controllers;

import com.ecxfoi.wbl.wienerbergerbackend.auth.AuthenticationData;
import com.ecxfoi.wbl.wienerbergerbackend.auth.AuthenticationErrorData;
import com.ecxfoi.wbl.wienerbergerbackend.auth.AuthenticationRequest;
import com.ecxfoi.wbl.wienerbergerbackend.response.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.service.AuthService;
import com.ecxfoi.wbl.wienerbergerbackend.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController
{
    private final AuthService authService;

    public AuthController(@Autowired AuthService authService)
    {
        this.authService = authService;
    }

    @PostMapping(value = "/api/login")
    public ResponseEntity<WienerbergerResponse<?>> loginUser(@RequestBody AuthenticationRequest authenticationRequest)
    {
        try
        {
            String jwt = authService.authenticateUser(authenticationRequest.getEmail(), authenticationRequest.getPassword());

            if (StringUtils.isNotEmpty(jwt))
            {
                return ResponseEntity.ok(new WienerbergerResponse<>(true, Constants.SUCCESS, new AuthenticationData(jwt)));
            }
            else
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, Constants.INVALID_CREDENTIALS, new AuthenticationData(jwt)));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new WienerbergerResponse<>(false, "There was an error on our side, please try again later.", new AuthenticationErrorData(ex)));
        }
    }
}