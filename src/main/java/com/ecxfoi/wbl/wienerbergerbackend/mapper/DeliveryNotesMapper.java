package com.ecxfoi.wbl.wienerbergerbackend.mapper;

import com.ecxfoi.wbl.wienerbergerbackend.dto.DeliveryNotesDto;
import com.ecxfoi.wbl.wienerbergerbackend.exceptions.*;
import com.ecxfoi.wbl.wienerbergerbackend.model.DeliveryNotes;

public class DeliveryNotesMapper implements GenericMapper<DeliveryNotesDto, DeliveryNotes>
{
    @Override
    public DeliveryNotesDto mapDto(final DeliveryNotes entity)
    {
        if (entity == null)
        {
            return null;
        }

        DeliveryNotesDto deliveryNotesDto = new DeliveryNotesDto();

        deliveryNotesDto.setId(entity.getId());
        deliveryNotesDto.setOrderId(entity.getOrder().getIdOrder());
        deliveryNotesDto.setShipToParty(entity.getParty().getName());

        String address = entity.getParty().getAddressStreet() + entity.getParty().getAddressCity() + entity.getParty().getAddressPostCode();
        deliveryNotesDto.setDeliveryAddress(address);

        deliveryNotesDto.setDeliveredDate(entity.getDeliveryDate().toString());

        return deliveryNotesDto;
    }

    @Override
    public DeliveryNotes map(final DeliveryNotesDto dto) throws InvalidMappingException, InvalidTitleException, InvalidNameException, InvalidPhoneNumberException, InvalidEmailException
    {
        throw new InvalidMappingException("Can't map DeliveryNotedDto to DeliveryNotes!");
    }
}