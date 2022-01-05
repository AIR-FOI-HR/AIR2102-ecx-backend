package com.ecxfoi.wbl.wienerbergerbackend.controllers;

import com.ecxfoi.wbl.wienerbergerbackend.dto.MaterialBalanceDto;
import com.ecxfoi.wbl.wienerbergerbackend.response.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.service.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialBalanceController
{
    private final MaterialService materialService;

    public MaterialBalanceController(MaterialService materialService)
    {
        this.materialService = materialService;
    }

    @RequestMapping(value = "/api/companies/materials/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<WienerbergerResponse<List<MaterialBalanceDto>>> getMaterialBalanceForUser(@PathVariable Long customerId)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            List<MaterialBalanceDto> materialBalanceDtos = materialService.getMaterialsForCustomer(idJWT, customerId);

            if (materialBalanceDtos.size() == 0)
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "User has no materials", null));
            }

            return ResponseEntity.ok(new WienerbergerResponse<>(true, "Success!", materialBalanceDtos));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "Materials not found!", null));
        }
    }
}