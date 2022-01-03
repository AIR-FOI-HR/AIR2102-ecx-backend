package com.ecxfoi.wbl.wienerbergerbackend.util;

import com.ecxfoi.wbl.wienerbergerbackend.model.TicketStatus;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

@Component
public class TicketStatusEnumConveter implements AttributeConverter<TicketStatus, String>
{
    @Override
    public String convertToDatabaseColumn(final TicketStatus ticketStatus)
    {
        return ticketStatus.toString();
    }

    @Override
    public TicketStatus convertToEntityAttribute(final String s)
    {
        return TicketStatus.valueOf(s);
    }
}