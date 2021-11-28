package com.ecxfoi.wbl.wienerbergerbackend.repository;

import com.ecxfoi.wbl.wienerbergerbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findUserByEmail(String email);
}