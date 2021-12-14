package com.ecxfoi.wbl.wienerbergerbackend.mapper;

import com.ecxfoi.wbl.wienerbergerbackend.dto.UserDto;
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
        userDto.setTitle(entity.getTitle());
        userDto.setFirst_name(entity.getFirstName());
        userDto.setLast_name(entity.getLastName());
        userDto.setPhone_number(entity.getPhoneNumber());
        userDto.setFax_number(entity.getFaxNumber());
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
        user.setFirstName(dto.getFirst_name());
        user.setLastName(dto.getLast_name());
        user.setPhoneNumber(dto.getPhone_number());
        user.setFaxNumber(dto.getFax_number());
        user.setEmail(dto.getEmail());

        return user;
    }
}