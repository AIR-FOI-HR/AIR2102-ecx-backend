package com.ecxfoi.wbl.wienerbergerbackend.controller;

import com.ecxfoi.wbl.wienerbergerbackend.entities.User;
import com.ecxfoi.wbl.wienerbergerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/users")
    private List<User> getAllUsers()
    {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    private User getUser(@PathVariable("id") UUID id)
    {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    private UUID createUser(@RequestBody User user) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(user.getPassword().toCharArray(), salt, 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        user.setPassword(Base64.getEncoder().encodeToString(salt) + "." + Base64.getEncoder().encodeToString(hash));

        userService.create(user);
        return userService.findById(user.getId()).getId();
    }

    @PutMapping("/users/{id}")
    private void changeUser(@PathVariable("id") UUID id, @RequestBody User user)
    {
        userService.update(id, user);
    }

    @DeleteMapping("/users/{id}")
    private void deleteUser(@PathVariable("id") UUID id)
    {
        userService.delete(id);
    }
}
