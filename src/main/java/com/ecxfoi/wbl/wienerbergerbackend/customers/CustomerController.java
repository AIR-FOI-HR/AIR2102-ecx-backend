package com.ecxfoi.wbl.wienerbergerbackend.customers;

import com.ecxfoi.wbl.wienerbergerbackend.models.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.service.CustomerService;
import com.ecxfoi.wbl.wienerbergerbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController
{
    CustomerService customerService;
    JwtUtil jwtUtil;

    public CustomerController(@Autowired CustomerService customerService, @Autowired JwtUtil jwtUtil)
    {
        this.customerService = customerService;
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping(value = "/api/companies", method = RequestMethod.GET)
    public ResponseEntity<?> getCompanies()
    {
        var context = SecurityContextHolder.getContext().getAuthentication();
        Long id;

        try
        {
            id = (Long)context.getPrincipal();
            if(id == null){
                throw new Exception("Invalid ID.");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));
        }

        var userCompanies = customerService.getUserCompanies(id);
        return ResponseEntity.ok(new WienerbergerResponse<>(true, "Success!", userCompanies));
    }
}