package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.dto.OrderDto;
import com.ecxfoi.wbl.wienerbergerbackend.mapper.OrderMapper;
import com.ecxfoi.wbl.wienerbergerbackend.model.Customer;
import com.ecxfoi.wbl.wienerbergerbackend.model.Order;
import com.ecxfoi.wbl.wienerbergerbackend.model.User;
import com.ecxfoi.wbl.wienerbergerbackend.repository.CustomerRepository;
import com.ecxfoi.wbl.wienerbergerbackend.repository.OrderRepository;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService
{
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, UserRepository userRepository, CustomerRepository customerRepository)
    {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    public List<OrderDto> getOrdersForACustomer(Long userId, Long customerId)
    {
        List<OrderDto> orderDtos = new ArrayList<>();
        User user = userRepository.getById(userId);

        Customer selectedCompany = customerRepository.getAllByUsers(user).stream().filter(c -> c.getId().equals(customerId)).findAny().orElse(null);
        if (selectedCompany != null)
        {
            List<Order> orders = orderRepository.findAllByCustomerPONumber(selectedCompany);

            for (Order order : orders)
            {
                orderDtos.add(orderMapper.mapDto(order));
            }
        }

        return orderDtos;
    }
}