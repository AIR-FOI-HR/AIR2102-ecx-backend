package com.ecxfoi.wbl.wienerbergerbackend.mapper;

import com.ecxfoi.wbl.wienerbergerbackend.dto.TicketDetailsDto;
import com.ecxfoi.wbl.wienerbergerbackend.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketDetailsMapper implements GenericMapper<TicketDetailsDto, Ticket>
{
    @Override
    public TicketDetailsDto mapDto(final Ticket entity)
    {
        if (entity == null)
        {
            return null;
        }

        TicketDetailsDto ticketDto = new TicketDetailsDto();

        ticketDto.setId(entity.getIdTicket());
        ticketDto.setSubject(entity.getSubject());
        ticketDto.setStatus(entity.getStatus());
        ticketDto.setMessage(entity.getMessage());
        ticketDto.setResolveMessage(entity.getResolveMessage());

        return ticketDto;
    }

    @Override
    public Ticket map(final TicketDetailsDto dto)
    {
        if (dto == null)
        {
            return null;
        }

        Ticket ticket = new Ticket();

        ticket.setIdTicket(dto.getId());
        ticket.setSubject(dto.getSubject());
        ticket.setStatus(dto.getStatus());
        ticket.setMessage(dto.getMessage());
        ticket.setResolveMessage(dto.getResolveMessage());

        return ticket;
    }
}