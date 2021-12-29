package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.dto.TicketDto;
import com.ecxfoi.wbl.wienerbergerbackend.mapper.TicketMapper;
import com.ecxfoi.wbl.wienerbergerbackend.model.Ticket;
import com.ecxfoi.wbl.wienerbergerbackend.model.User;
import com.ecxfoi.wbl.wienerbergerbackend.repository.TicketRepository;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService
{
    private final TicketMapper ticketMapper = new TicketMapper();
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    public TicketService(@Autowired UserRepository userRepository, @Autowired TicketRepository ticketRepository)
    {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<TicketDto> getTicketsForUser(Long userId)
    {
        User user = userRepository.findUserById(userId);
        ArrayList<TicketDto> ticketDtos = new ArrayList<>();

        for (Ticket ticket : ticketRepository.findAllByTicketUser(user))
        {
            ticketDtos.add(ticketMapper.mapDto(ticket));
        }

        return ticketDtos;
    }

    public TicketDto getTicketDetails(final Long ticketId, final Long userId)
    {
        Ticket ticket = ticketRepository.findTicketByIdTicket(ticketId);

        if (ticket.getTicketUser().getId() != userId)
        {
            return null;
        }

        return ticketMapper.mapDto(ticket);
    }

    public void createTicket(final TicketDto ticketDto, final Long idUser)
    {
        ticketDto.setStatus("New");
        ticketDto.setResolve_message("");
        Ticket ticket = ticketMapper.map(ticketDto);
        ticket.setTicketUser(userRepository.findUserById(idUser));
        ticketRepository.save(ticket);
    }
}