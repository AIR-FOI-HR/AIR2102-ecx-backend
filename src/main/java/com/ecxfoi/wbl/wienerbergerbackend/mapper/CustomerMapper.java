package com.ecxfoi.wbl.wienerbergerbackend.mapper;

import com.ecxfoi.wbl.wienerbergerbackend.dto.CustomerDto;
import com.ecxfoi.wbl.wienerbergerbackend.model.Customer;

public class CustomerMapper implements GenericMapper<CustomerDto, Customer>
{
    @Override
    public CustomerDto mapDto(final Customer entity)
    {
        if (entity == null)
        {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(entity.getId());
        customerDto.setName(entity.getName());
        customerDto.setAddressStreet(entity.getAddressStreet());
        customerDto.setAddressPostCode(entity.getAddressPostCode());
        customerDto.setAddressCity(entity.getAddressCity());
        customerDto.setAddressCountryCode(entity.getAddressCountryCode());

        return customerDto;
    }

    @Override
    public Customer map(final CustomerDto dto)
    {
        if (dto == null)
        {
            return null;
        }

        Customer customer = new Customer();
        customer.setId((dto.getId()));
        customer.setName(dto.getName());
        customer.setAddressStreet(dto.getAddressStreet());
        customer.setAddressPostCode(dto.getAddressPostCode());
        customer.setAddressCity(dto.getAddressCity());
        customer.setAddressCountryCode(dto.getAddressCountryCode());

        return customer;
    }
}