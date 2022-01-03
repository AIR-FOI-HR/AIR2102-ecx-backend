package com.ecxfoi.wbl.wienerbergerbackend.controllers;

import com.ecxfoi.wbl.wienerbergerbackend.dto.CustomerDto;
import com.ecxfoi.wbl.wienerbergerbackend.response.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.service.CustomerService;
import com.ecxfoi.wbl.wienerbergerbackend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController
{
    private final CustomerService customerService;

    public CustomerController(@Autowired CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping(value = "/api/companies")
    public ResponseEntity<?> getCompanies()
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, Constants.INVALID_CREDENTIALS, null));
        }

        List<CustomerDto> userCompanies = customerService.getUserCompanies(idJWT);
        return ResponseEntity.ok(new WienerbergerResponse<>(true, Constants.SUCCESS, userCompanies));
    }
}