package com.ecxfoi.wbl.wienerbergerbackend.controllers;

import com.ecxfoi.wbl.wienerbergerbackend.dto.UserDto;
import com.ecxfoi.wbl.wienerbergerbackend.response.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.service.UserService;
import com.ecxfoi.wbl.wienerbergerbackend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    UserService userService;

    public UserController(@Autowired UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping(value = "api/user")
    public ResponseEntity<?> getUser()
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, Constants.INVALID_CREDENTIALS, null));
        }

        try
        {
            UserDto userDto = userService.getUserDto(idJWT);
            return ResponseEntity.ok(new WienerbergerResponse<>(true, "User found!", userDto));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "User not found!", null));
        }
    }

    @PutMapping(value = "api/user")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = context != null ? (Long) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, Constants.INVALID_CREDENTIALS, null));
        }

        userDto.setId(idJWT);

        try
        {
            userService.saveUserDto(userDto);
            return ResponseEntity.ok(new WienerbergerResponse<>(true, "User modified!", userDto));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "Error while modifying user!", ex.getMessage()));
        }
    }
}