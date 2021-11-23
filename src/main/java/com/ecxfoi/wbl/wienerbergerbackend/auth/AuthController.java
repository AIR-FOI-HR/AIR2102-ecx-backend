package com.ecxfoi.wbl.wienerbergerbackend.auth;

import com.ecxfoi.wbl.wienerbergerbackend.entities.User;
import com.ecxfoi.wbl.wienerbergerbackend.models.Response;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import com.ecxfoi.wbl.wienerbergerbackend.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.List;

@Controller
public class AuthController
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest)
    {
        String email = authenticationRequest.getEmail();
        String password = authenticationRequest.getPassword();

        User user;

        try
        {
            user = authenticateUser(email, password);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Response(false, ex.getMessage(), new AuthenticationException(ex)));
        }

        final String jwt = jwtUtil.generateToken(user.getId());

        String welcomeMessage = "Welcome, " + user.getFirstName() + "!";
        return ResponseEntity.ok(new Response(true, welcomeMessage, new AuthenticationResponse(jwt)));
    }

    private User authenticateUser(String emailProvided, String passwordProvided) throws Exception
    {
        List<User> userList = userRepository.findByEmail(emailProvided);
        if (userList.isEmpty())
        {
            throw new Exception("Please check your email!");
        }

        User user = userList.get(0);

        String salt = StringUtils.split(user.getPass(), '.')[0];
        String hashedPassword = StringUtils.split(user.getPass(), '.')[1];

        KeySpec spec = new PBEKeySpec(passwordProvided.toCharArray(), Base64.getDecoder().decode(salt), 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        String passwordProvidedHashed = Base64.getEncoder().encodeToString(factory.generateSecret(spec).getEncoded());

        if (!StringUtils.equals(passwordProvidedHashed, hashedPassword))
        {
            throw new Exception("Check your password and try again!");
        }

        return user;
    }
}



















