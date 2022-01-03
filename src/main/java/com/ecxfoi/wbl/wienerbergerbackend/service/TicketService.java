package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.dto.TicketDetailsDto;
import com.ecxfoi.wbl.wienerbergerbackend.dto.TicketDto;
import com.ecxfoi.wbl.wienerbergerbackend.mapper.TicketDetailsMapper;
import com.ecxfoi.wbl.wienerbergerbackend.mapper.TicketMapper;
import com.ecxfoi.wbl.wienerbergerbackend.model.TicketStatus;
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
    private final TicketMapper ticketMapper;
    private final TicketDetailsMapper ticketDetailsMapper;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    public TicketService(@Autowired UserRepository userRepository, @Autowired TicketRepository ticketRepository, TicketMapper  ticketMapper, TicketDetailsMapper ticketDetailsMapper)
    {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
        this.ticketDetailsMapper = ticketDetailsMapper;
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

    public TicketDetailsDto getTicketDetails(final Long ticketId, final Long userId)
    {
        Ticket ticket = ticketRepository.findTicketByIdTicket(ticketId);

        if (!ticket.getTicketUser().getId().equals(userId))
        {
            return null;
        }

        return ticketDetailsMapper.mapDto(ticket);
    }

    public void createTicket(final TicketDetailsDto ticketDto, final Long idUser)
    {
        ticketDto.setStatus(TicketStatus.New);
        ticketDto.setResolveMessage("");
        Ticket ticket = ticketDetailsMapper.map(ticketDto);
        ticket.setTicketUser(userRepository.findUserById(idUser));
        ticketRepository.save(ticket);
    }
}