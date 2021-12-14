package com.ecxfoi.wbl.wienerbergerbackend.mapper;

public interface GenericMapper<D, E>
{
    D mapDto(E entity);

    E map(D dto) throws Exception;
}