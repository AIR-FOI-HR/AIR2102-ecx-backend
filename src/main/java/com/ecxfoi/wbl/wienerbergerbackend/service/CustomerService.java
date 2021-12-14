package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.dto.CustomerDto;
import com.ecxfoi.wbl.wienerbergerbackend.mapper.CustomerMapper;
import com.ecxfoi.wbl.wienerbergerbackend.model.Customer;
import com.ecxfoi.wbl.wienerbergerbackend.model.User;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService
{
    private final CustomerMapper customerMapper = new CustomerMapper();
    private final UserRepository userRepository;

    public CustomerService(@Autowired UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<CustomerDto> getUserCompanies(Long userId)
    {
        User user = userRepository.findUserById(userId);
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer c : user.getCustomers())
        {
            customerDtos.add(customerMapper.mapDto(c));
        }

        return customerDtos;
    }
}