package com.ecxfoi.wbl.wienerbergerbackend.repository;

import com.ecxfoi.wbl.wienerbergerbackend.model.DeliveryNotes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DeliveryNotesRepository extends JpaRepository<DeliveryNotes, Long>
{
    List<DeliveryNotes> getAllByOrderIdOrder(Long orderId);

    List<DeliveryNotes> getAllByDeliveryDateIsBetween(Date firstDate, Date lastDate);
}