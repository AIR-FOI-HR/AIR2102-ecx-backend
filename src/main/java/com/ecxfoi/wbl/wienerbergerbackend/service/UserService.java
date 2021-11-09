package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.entities.User;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id).get();
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public void update(UUID id, User user) {
        if (user.getId() == id) {
            userRepository.deleteById(user.getId());
            userRepository.save(user);
        }
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
