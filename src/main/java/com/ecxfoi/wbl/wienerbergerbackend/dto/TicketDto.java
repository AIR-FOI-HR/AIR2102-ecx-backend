package com.ecxfoi.wbl.wienerbergerbackend.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TicketDto
{
    private Long id;
    private String subject;
    private String status;
    private String message;
    private String resolveMessage;

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

    public String getResolveMessage()
    {
        return resolveMessage;
    }

    public void setResolveMessage(final String resolveMessage)
    {
        this.resolveMessage = resolveMessage;
    }
}