package com.ecxfoi.wbl.wienerbergerbackend.users;

import com.ecxfoi.wbl.wienerbergerbackend.models.UserModel;
import com.ecxfoi.wbl.wienerbergerbackend.models.WienerbergerResponse;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import com.ecxfoi.wbl.wienerbergerbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> getUser(@PathVariable("id") Long ID)
    {
        var context = SecurityContextHolder.getContext().getAuthentication();
        Long id;

        try
        {
            id = (Long) context.getPrincipal();
            if (id == null || !id.equals(ID))
            {
                throw new Exception("Invalid ID.");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new WienerbergerResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            UserModel userModel = userService.getUser(ID);
            return ResponseEntity.ok(new WienerbergerResponse<>(true, "User found!", userModel));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WienerbergerResponse<>(false, "User not found!", null));
        }
    }
}