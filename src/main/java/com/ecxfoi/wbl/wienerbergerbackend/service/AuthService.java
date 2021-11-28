package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.entities.User;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import com.ecxfoi.wbl.wienerbergerbackend.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.List;

@Service
public class AuthService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    public String authenticateUser(String email, String password) throws Exception
    {
        User user;
        user = checkUser(email, password);

        return jwtUtil.generateToken(user.getId());
    }

    private User checkUser(String emailProvided, String passwordProvided) throws Exception
    {
        List<User> userList = userRepository.findByEmail(emailProvided);

        String errorMessage = "Invalid credentials";

        if (userList.isEmpty())
        {
            throw new Exception(errorMessage);
        }

        User user = userList.get(0);

        String salt = StringUtils.split(user.getPass(), '.')[0];
        String hashedPassword = StringUtils.split(user.getPass(), '.')[1];

        KeySpec spec = new PBEKeySpec(passwordProvided.toCharArray(), Base64.getDecoder().decode(salt), 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        String passwordProvidedHashed = Base64.getEncoder().encodeToString(factory.generateSecret(spec).getEncoded());

        if (!StringUtils.equals(passwordProvidedHashed, hashedPassword))
        {
            throw new Exception(errorMessage);
        }

        return user;
    }
}
