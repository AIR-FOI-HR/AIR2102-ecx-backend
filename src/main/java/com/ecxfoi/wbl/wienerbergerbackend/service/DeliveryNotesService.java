package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.dto.DeliveryNotesDto;
import com.ecxfoi.wbl.wienerbergerbackend.mapper.DeliveryNotesMapper;
import com.ecxfoi.wbl.wienerbergerbackend.model.DeliveryNotes;
import com.ecxfoi.wbl.wienerbergerbackend.repository.DeliveryNotesRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DeliveryNotesService
{
    DeliveryNotesRepository deliveryNotesRepository;
    DeliveryNotesMapper deliveryNotesMapper;

    public DeliveryNotesService(@Autowired DeliveryNotesRepository deliveryNotesRepository)
    {
        this.deliveryNotesRepository = deliveryNotesRepository;
        deliveryNotesMapper = new DeliveryNotesMapper();
    }

    public DeliveryNotesDto getSingleById(Long id)
    {
        return deliveryNotesMapper.mapDto(deliveryNotesRepository.getById(id));
    }


    public List<DeliveryNotesDto> getAllByDates(String start, String end) throws ParseException, NotFoundException
    {
        Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(start);
        Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(end);

        ArrayList<DeliveryNotes> deliveryList = (ArrayList<DeliveryNotes>) deliveryNotesRepository.getAllByDeliveryDateIsBetween(dateStart, dateEnd);
        return getDeliveryNotesDtos(deliveryList);
    }

    public List<DeliveryNotesDto> getAllByOrderId(Long id) throws NotFoundException
    {
        ArrayList<DeliveryNotes> delivery = (ArrayList<DeliveryNotes>) deliveryNotesRepository.getAllByOrderIdOrder(id);

        return getDeliveryNotesDtos(delivery);
    }

    private ArrayList<DeliveryNotesDto> getDeliveryNotesDtos(final ArrayList<DeliveryNotes> deliveryList) throws NotFoundException
    {
        ArrayList<DeliveryNotesDto> deliveryNotesDtos = new ArrayList<>();

        if (deliveryList.isEmpty())
        {
            throw new NotFoundException("Empty list passed");
        }

        for (DeliveryNotes deliveryNotes : deliveryList)
        {
            deliveryNotesDtos.add(deliveryNotesMapper.mapDto(deliveryNotes));
        }

        return deliveryNotesDtos;
    }
}