package com.ecxfoi.wbl.wienerbergerbackend.controller;

import com.ecxfoi.wbl.wienerbergerbackend.entities.User;
import com.ecxfoi.wbl.wienerbergerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/users")
    private List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    private User getUser(@PathVariable("id") UUID id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    private UUID createUser(@RequestBody User user) {
        userService.create(user);
        return userService.findById(user.getId()).getId();
    }

    @PutMapping("/users/{id}")
    private void changeUser(@PathVariable("id") UUID id, @RequestBody User user) {
        userService.update(id, user);
    }

    @DeleteMapping("/users/{id}")
    private void deleteUser(@PathVariable("id") UUID id) {
        userService.delete(id);
    }
}
