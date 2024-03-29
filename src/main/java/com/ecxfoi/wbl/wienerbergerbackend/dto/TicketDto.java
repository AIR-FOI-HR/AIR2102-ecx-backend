package com.ecxfoi.wbl.wienerbergerbackend.dto;

import com.ecxfoi.wbl.wienerbergerbackend.model.TicketStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TicketDto
{
    private Long id;
    private String subject;
    private TicketStatus status;

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(final String subject)
    {
        this.subject = subject;
    }

    public TicketStatus getStatus()
    {
        return status;
    }

    public void setStatus(final TicketStatus status)
    {
        this.status = status;
    }
}