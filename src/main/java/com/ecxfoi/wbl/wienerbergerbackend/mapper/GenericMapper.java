package com.ecxfoi.wbl.wienerbergerbackend.mapper;

import com.ecxfoi.wbl.wienerbergerbackend.exceptions.*;

public interface GenericMapper<D, E>
{
    D mapDto(E entity);

    E map(D dto) throws InvalidMappingException, InvalidTitleException, InvalidNameException, InvalidPhoneNumberException, InvalidEmailException;
}