package com.ecxfoi.wbl.wienerbergerbackend.mapper;

import com.ecxfoi.wbl.wienerbergerbackend.dto.UserDto;
import com.ecxfoi.wbl.wienerbergerbackend.exceptions.*;
import com.ecxfoi.wbl.wienerbergerbackend.model.User;

public class UserMapper implements GenericMapper<UserDto, User>
{
    @Override
    public UserDto mapDto(final User entity)
    {
        if (entity == null)
        {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setTitle(entity.getTitle());
        userDto.setFirstName(entity.getFirstName());
        userDto.setLastName(entity.getLastName());
        userDto.setPhoneNumber(entity.getPhoneNumber());
        userDto.setFaxNumber(entity.getFaxNumber());
        userDto.setEmail(entity.getEmail());

        return userDto;
    }

    @Override
    public User map(final UserDto dto) throws Exception
    {
        if (dto == null)
        {
            return null;
        }

        User user = new User();
        user.setId(dto.getId());
        user.setTitle(dto.getTitle());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setFaxNumber(dto.getFaxNumber());
        user.setEmail(dto.getEmail());

        return user;
    }
}