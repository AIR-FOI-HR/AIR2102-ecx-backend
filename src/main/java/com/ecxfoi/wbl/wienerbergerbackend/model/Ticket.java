package com.ecxfoi.wbl.wienerbergerbackend.model;

import com.ecxfoi.wbl.wienerbergerbackend.util.TicketStatusEnumConveter;

import javax.persistence.*;

@Entity(name = "tickets")
public class Ticket
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket", nullable = false)
    private Long idTicket;

    @ManyToOne
    @JoinColumn(name = "ticket_user", referencedColumnName = "id_user")
    private User ticketUser;

    @Column(name = "subject")
    private String subject;

    @Column(name = "status")
    @Convert(converter = TicketStatusEnumConveter.class)
    private TicketStatus status;

    @Column(name = "message")
    private String message;

    @Column(name = "resolve_message")
    private String resolveMessage;

    public Long getIdTicket()
    {
        return idTicket;
    }

    public void setIdTicket(final Long idTicket)
    {
        this.idTicket = idTicket;
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

    public TicketStatus getStatus()
    {
        return status;
    }

    public void setStatus(final TicketStatus status)
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