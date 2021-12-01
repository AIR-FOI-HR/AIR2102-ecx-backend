package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.entities.User;
import com.ecxfoi.wbl.wienerbergerbackend.models.CustomerModel;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import com.ecxfoi.wbl.wienerbergerbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService
{
    UserRepository userRepository;
    JwtUtil jwtUtil;

    public CustomerService(@Autowired UserRepository userRepository, @Autowired JwtUtil jwtUtil)
    {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public List<CustomerModel> getUserCompanies(Long userId)
    {
        User user = userRepository.findUserById(userId);
        ArrayList<CustomerModel> customerModels = new ArrayList<>();

        for (var c : user.getCustomers())
        {
            CustomerModel customerModel = new CustomerModel();
            customerModel.id = c.getId();
            customerModel.name = c.getName();
            customerModel.addressStreet = c.getAddressStreet();
            customerModel.addressPostCode = c.getAddressPostCode();
            customerModel.addressCity = c.getAddressCity();
            customerModel.addressCountryCode = c.getAddressCountryCode();
            customerModels.add(customerModel);
        }

        return customerModels;
    }
}