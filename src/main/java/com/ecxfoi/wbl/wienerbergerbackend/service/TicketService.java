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
        ticketDtos.add(ticketMapper.mapDto(ticketRepository.findAllByTicketUser(user)));

        return ticketDtos;
    }

    public TicketDto getTicketForUser(final Long ticketId)
    {
        Ticket ticket = ticketRepository.findTicketByIdTicket(ticketId);
        TicketDto ticketDto = ticketMapper.mapDto(ticket);

        return ticketDto;
    }

    public void saveTickedDto(final TicketDto ticketDto, final Long id)
    {
        ticketDto.setId(id);
        Ticket ticket = ticketMapper.map(ticketDto);
        ticketRepository.save(ticket);
    }
}