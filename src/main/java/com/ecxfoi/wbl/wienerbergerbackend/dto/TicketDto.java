package com.ecxfoi.wbl.wienerbergerbackend.dto;

import com.ecxfoi.wbl.wienerbergerbackend.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TicketDto
{
    private Long id;
    private User ticketUser;
    private String subject;
    private String status;
    private String message;
    private String resolve_message;

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public User getTicketUser()
    {
        return ticketUser;
    }

    public void setTicketUser(final User ticketUser)
    {
        this.ticketUser = ticketUser;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(final String subject)
    {
        this.subject = subject;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(final String status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(final String message)
    {
        this.message = message;
    }

    public String getResolve_message()
    {
        return resolve_message;
    }

    public void setResolve_message(final String resolve_message)
    {
        this.resolve_message = resolve_message;
    }
}