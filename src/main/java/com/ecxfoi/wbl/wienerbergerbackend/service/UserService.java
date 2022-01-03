package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.dto.UserDto;
import com.ecxfoi.wbl.wienerbergerbackend.exceptions.*;
import com.ecxfoi.wbl.wienerbergerbackend.mapper.UserMapper;
import com.ecxfoi.wbl.wienerbergerbackend.model.User;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository)
    {
        this.userRepository = userRepository;
        this.userMapper = new UserMapper();
    }

    public UserDto getUserDto(Long id)
    {
        User user = userRepository.findUserById(id);
        return userMapper.mapDto(user);
    }

    public void saveUserDto(final UserDto userDto) throws InvalidNameException, InvalidPhoneNumberException, InvalidTitleException, InvalidEmailException
    {
        User updatedUser = userMapper.map(userDto);

        if (updatedUser.getId() != null)
        {
            User oldUser = userRepository.getById(updatedUser.getId());
            updatedUser.setPass(oldUser.getPass());
        }

        userRepository.save(updatedUser);
    }
}