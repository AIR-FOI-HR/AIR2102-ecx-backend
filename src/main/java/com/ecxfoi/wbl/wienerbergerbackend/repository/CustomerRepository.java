package com.ecxfoi.wbl.wienerbergerbackend.repository;

import com.ecxfoi.wbl.wienerbergerbackend.model.Customer;
import com.ecxfoi.wbl.wienerbergerbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    List<Customer> getAllByUsers(User user);
}