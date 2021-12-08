package com.ecxfoi.wbl.wienerbergerbackend.customers;

import com.ecxfoi.wbl.wienerbergerbackend.models.CustomerModel;
import com.ecxfoi.wbl.wienerbergerbackend.models.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController
{
    CustomerService customerService;

    public CustomerController(@Autowired CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/api/companies", method = RequestMethod.GET)
    public ResponseEntity<?> getCompanies()
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));
        }

        List<CustomerModel> userCompanies = customerService.getUserCompanies(idJWT);
        return ResponseEntity.ok(new WienerbergerResponse<>(true, "Success!", userCompanies));
    }
}