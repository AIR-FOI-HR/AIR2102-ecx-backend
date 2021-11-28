package com.ecxfoi.wbl.wienerbergerbackend.auth;

import com.ecxfoi.wbl.wienerbergerbackend.models.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.service.AuthService;
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
    @Autowired
    AuthService authService;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody AuthenticationRequest authenticationRequest)
    {
        final String jwt;

        try
        {
            jwt = authService.authenticateUser(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse(false, ex.getMessage(), new AuthenticationException(ex)));
        }

        return ResponseEntity.ok(new WienerbergerResponse(true, "Success!", new AuthenticationData(jwt)));
    }
}



















