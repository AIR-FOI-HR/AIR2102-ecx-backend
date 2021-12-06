package com.ecxfoi.wbl.wienerbergerbackend.users;

import com.ecxfoi.wbl.wienerbergerbackend.models.UserModel;
import com.ecxfoi.wbl.wienerbergerbackend.models.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import com.ecxfoi.wbl.wienerbergerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(method = RequestMethod.GET, value = "api/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long idParams)
    {
        if (authenticateForID(idParams))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));

        try
        {
            UserModel userModel = userService.getUserModel(idParams);
            return ResponseEntity.ok(new WienerbergerResponse<>(true, "User found!", userModel));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "User not found!", null));
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "api/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long idParams, @RequestBody UserModel userModel)
    {
        if (authenticateForID(idParams))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));

        try
        {
            userService.saveUserModel(idParams, userModel);
            return ResponseEntity.ok(new WienerbergerResponse<>(true, "User modified!", userModel));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "Error while modifying user!", ex.getMessage()));
        }
    }

    private boolean authenticateForID(@PathVariable("id") final Long idParams)
    {
        var context = SecurityContextHolder.getContext().getAuthentication();
        Long idJWT;
        try
        {
            idJWT = (Long) context.getPrincipal();
            if (idJWT == null || !idJWT.equals(idParams))
            {
                throw new Exception("Invalid idParams.");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return true;
        }
        return false;
    }
}