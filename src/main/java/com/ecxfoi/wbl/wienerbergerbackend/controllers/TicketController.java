package com.ecxfoi.wbl.wienerbergerbackend.controllers;

import com.ecxfoi.wbl.wienerbergerbackend.dto.TicketDetailsDto;
import com.ecxfoi.wbl.wienerbergerbackend.dto.TicketDto;
import com.ecxfoi.wbl.wienerbergerbackend.response.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.service.TicketService;
import com.ecxfoi.wbl.wienerbergerbackend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController
{
    private final TicketService ticketService;

    public TicketController(@Autowired TicketService ticketService)
    {
        this.ticketService = ticketService;
    }

    @GetMapping(value = "/api/tickets")
    public ResponseEntity<WienerbergerResponse<List<TicketDto>>> getTickets()
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, Constants.INVALID_CREDENTIALS, null));
        }

        try
        {
            List<TicketDto> userTickets = ticketService.getTicketsForUser(idJWT);
            return ResponseEntity.ok(new WienerbergerResponse<>(true, Constants.SUCCESS, userTickets));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "Tickets not found!", null));
        }
    }

    @GetMapping(value = "/api/tickets/{id}")
    public ResponseEntity<WienerbergerResponse<TicketDetailsDto>> getDetailsForTicket(@PathVariable final Long id)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, Constants.INVALID_CREDENTIALS, null));
        }

        try
        {
            TicketDetailsDto userTicket = ticketService.getTicketDetails(id, idJWT);

            if (userTicket == null)
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "You are not permitted to read other user's tickets!", null));
            }

            return ResponseEntity.ok(new WienerbergerResponse<>(true, Constants.SUCCESS, userTicket));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "Ticket not found!", null));
        }
    }

    @PostMapping(value = "/api/tickets")
    public ResponseEntity<WienerbergerResponse<TicketDetailsDto>> createNewTicket(@RequestBody TicketDetailsDto ticketDto)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, Constants.INVALID_CREDENTIALS, null));
        }

        try
        {
            ticketService.createTicket(ticketDto, idJWT);
            return ResponseEntity.ok(new WienerbergerResponse<>(true, Constants.SUCCESS, ticketDto));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "Ticket couldn't be added!", null));
        }
    }
}