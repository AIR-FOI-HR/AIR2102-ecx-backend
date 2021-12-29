package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.dto.OrderDetailsDto;
import com.ecxfoi.wbl.wienerbergerbackend.dto.OrderDto;
import com.ecxfoi.wbl.wienerbergerbackend.mapper.OrderDetailsMapper;
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
    private final OrderDetailsMapper orderDetailsMapper;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, UserRepository userRepository, CustomerRepository customerRepository, OrderDetailsMapper orderDetailsMapper)
    {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.orderDetailsMapper = orderDetailsMapper;
    }

    public List<OrderDto> getOrdersForACustomer(Long userId, Long customerId)
    {
        List<OrderDto> orderDtos = new ArrayList<>();
        User user = userRepository.findUserById(userId);

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

    public OrderDetailsDto getOrderDetails(Long userId, Long orderId)
    {
        User user = userRepository.findUserById(userId);
        Order order = orderRepository.findOrderByIdOrder(orderId);

        boolean customerBelongsToCurrentUser = user != null && customerRepository.getAllByUsers(user).contains(order.getCustomerPONumber());

        return customerBelongsToCurrentUser ? orderDetailsMapper.mapDto(order) : null;
    }
}