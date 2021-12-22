package com.ecxfoi.wbl.wienerbergerbackend.repository;

import com.ecxfoi.wbl.wienerbergerbackend.model.Ticket;
import com.ecxfoi.wbl.wienerbergerbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>
{
    Ticket findTicketByIdTicket(Long id);

    List<Ticket> findAllByTicketUser(User user);
}