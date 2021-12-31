package com.ecxfoi.wbl.wienerbergerbackend.repository;

import com.ecxfoi.wbl.wienerbergerbackend.model.Customer;
import com.ecxfoi.wbl.wienerbergerbackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{
    Order findOrderByIdOrder(Long id);

    List<Order> findAllByCustomerPONumber(Customer customer);
}