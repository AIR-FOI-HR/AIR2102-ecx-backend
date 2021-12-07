package com.ecxfoi.wbl.wienerbergerbackend.users;

import com.ecxfoi.wbl.wienerbergerbackend.models.UserModel;
import com.ecxfoi.wbl.wienerbergerbackend.models.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import com.ecxfoi.wbl.wienerbergerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    UserRepository userRepository;
    UserService userService;

    public UserController(@Autowired UserRepository userRepository, @Autowired UserService userService)
    {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "api/user")
    public ResponseEntity<?> getUser()
    {
        Long idJWT;

        try
        {
            idJWT = getIdFromJWT();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            UserModel userModel = userService.getUserModel(idJWT);
            return ResponseEntity.ok(new WienerbergerResponse<>(true, "User found!", userModel));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "User not found!", null));
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "api/user")
    public ResponseEntity<?> updateUser(@RequestBody UserModel userModel)
    {
        Long idJWT;
        try
        {
            idJWT = getIdFromJWT();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));
        }
        userModel.id = idJWT;
        try
        {
            userService.saveUserModel(userModel);
            return ResponseEntity.ok(new WienerbergerResponse<>(true, "User modified!", userModel));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "Error while modifying user!", ex.getMessage()));
        }
    }

    private Long getIdFromJWT() throws Exception
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT = (Long) context.getPrincipal();
        if (idJWT == null)
        {
            throw new Exception("Invalid idJWT.");
        }
        return idJWT;
    }
}