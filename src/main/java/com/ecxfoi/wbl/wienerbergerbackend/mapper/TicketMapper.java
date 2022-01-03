package com.ecxfoi.wbl.wienerbergerbackend.mapper;

import com.ecxfoi.wbl.wienerbergerbackend.dto.TicketDto;
import com.ecxfoi.wbl.wienerbergerbackend.model.Ticket;

public class TicketMapper implements GenericMapper<TicketDto, Ticket>
{
    @Override
    public TicketDto mapDto(final Ticket entity)
    {
        if (entity == null)
        {
            return null;
        }
        TicketDto ticketDto = new TicketDto();

        ticketDto.setId(entity.getIdTicket());
        ticketDto.setSubject(entity.getSubject());
        ticketDto.setStatus(entity.getStatus());
        ticketDto.setMessage(entity.getMessage());
        ticketDto.setResolveMessage(entity.getResolveMessage());

        return ticketDto;
    }

    @Override
    public Ticket map(final TicketDto dto)
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