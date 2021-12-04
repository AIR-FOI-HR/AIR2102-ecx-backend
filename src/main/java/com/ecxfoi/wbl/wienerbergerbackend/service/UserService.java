package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.entities.User;
import com.ecxfoi.wbl.wienerbergerbackend.models.UserModel;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public UserModel getUser(Long ID)
    {
        User user = userRepository.findUserById(ID);
        return new UserModel(user);
    }
}