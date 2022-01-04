package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.dto.MaterialBalanceDto;
import com.ecxfoi.wbl.wienerbergerbackend.mapper.MaterialBalanceMapper;
import com.ecxfoi.wbl.wienerbergerbackend.model.Customer;
import com.ecxfoi.wbl.wienerbergerbackend.model.Material;
import com.ecxfoi.wbl.wienerbergerbackend.model.Order;
import com.ecxfoi.wbl.wienerbergerbackend.model.User;
import com.ecxfoi.wbl.wienerbergerbackend.repository.CustomerRepository;
import com.ecxfoi.wbl.wienerbergerbackend.repository.MaterialRepository;
import com.ecxfoi.wbl.wienerbergerbackend.repository.OrderRepository;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialService
{
    private final MaterialRepository materialRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final MaterialBalanceMapper materialBalanceMapper;

    public MaterialService(MaterialRepository materialRepository, UserRepository userRepository, OrderRepository orderRepository, CustomerRepository customerRepository, MaterialBalanceMapper materialBalanceMapper)
    {
        this.materialRepository = materialRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.materialBalanceMapper = materialBalanceMapper;
    }

    public List<MaterialBalanceDto> getMaterialsForCustomer(Long userId, Long customerId)
    {
        User user = userRepository.findUserById(userId);
        List<MaterialBalanceDto> materialBalanceDtos = new ArrayList<>();

        Customer selectedCompany = customerRepository.getAllByUsers(user).stream().filter(c -> c.getId().equals(customerId)).findAny().orElse(null);
        if (selectedCompany != null)
        {
            List<Order> orders = orderRepository.findAllByCustomerPONumber(selectedCompany);

            for (Order order : orders)
            {
                for (Material material : order.getMaterials())
                {
                    if (materialBalanceDtos.stream().noneMatch(dto -> dto.getMaterialNumber().equals(material.getMaterialNumber())))
                    {
                        materialBalanceDtos.add(materialBalanceMapper.mapDto(material));
                    }
                    else
                    {
                        materialBalanceDtos.stream()
                                .filter(dto -> dto.getMaterialNumber().equals(material.getMaterialNumber()))
                                .forEach(dto -> {
                                    int newQuantity = dto.getQuantity() + material.getQuantity();
                                    dto.setQuantity(newQuantity);
                                });
                    }
                }
            }
        }

        return materialBalanceDtos;
    }
}