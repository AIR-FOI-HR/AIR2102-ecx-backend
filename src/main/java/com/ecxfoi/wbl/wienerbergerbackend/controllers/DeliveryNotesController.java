package com.ecxfoi.wbl.wienerbergerbackend.controllers;

import com.ecxfoi.wbl.wienerbergerbackend.dto.DeliveryNotesDto;
import com.ecxfoi.wbl.wienerbergerbackend.response.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.service.DeliveryNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DeliveryNotesController
{
    private final DeliveryNotesService deliveryNotesService;

    public DeliveryNotesController(@Autowired DeliveryNotesService deliveryNotesService)
    {
        this.deliveryNotesService = deliveryNotesService;
    }

    @GetMapping("/api/deliveries/{deliveryNoteId}")
    public ResponseEntity<WienerbergerResponse<DeliveryNotesDto>> getSingleDeliveryNotesById(@PathVariable Long deliveryNoteId)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            DeliveryNotesDto deliveryNotesDto = deliveryNotesService.getSingleById(deliveryNoteId);

            return ResponseEntity.ok(new WienerbergerResponse<>(true, "Success!", deliveryNotesDto));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "Delivery note with specified ID doesn’t exist.", null));
        }
    }

    @GetMapping("/api/deliveries/dates")
    public ResponseEntity<WienerbergerResponse<List<DeliveryNotesDto>>> getDeliveryNotesByDates(@RequestParam() String from, @RequestParam() String to)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            ArrayList<DeliveryNotesDto> deliveryNotesDto = (ArrayList<DeliveryNotesDto>) deliveryNotesService.getAllByDates(from, to);

            return ResponseEntity.ok(new WienerbergerResponse<>(true, "Success!", deliveryNotesDto));
        }
        catch (ParseException ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, ex.getMessage(), null));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "No delivery notes for a specified time period.", null));
        }
    }

    @GetMapping("/api/deliveries")
    public ResponseEntity<WienerbergerResponse<List<DeliveryNotesDto>>> getDeliveryNotesByOrderId(@RequestParam Long orderId)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            ArrayList<DeliveryNotesDto> deliveryNotesDto = (ArrayList<DeliveryNotesDto>) deliveryNotesService.getAllByOrderId(orderId);

            return ResponseEntity.ok(new WienerbergerResponse<>(true, "Success!", deliveryNotesDto));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "Delivery note with specified order number doesn’t exist.", null));
        }
    }
}