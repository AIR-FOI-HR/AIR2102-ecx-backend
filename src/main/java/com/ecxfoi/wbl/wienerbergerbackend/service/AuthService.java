package com.ecxfoi.wbl.wienerbergerbackend.service;

import com.ecxfoi.wbl.wienerbergerbackend.model.User;
import com.ecxfoi.wbl.wienerbergerbackend.repository.UserRepository;
import com.ecxfoi.wbl.wienerbergerbackend.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Service
public class AuthService
{
    UserRepository userRepository;

    JwtUtil jwtUtil;

    public AuthService(@Autowired UserRepository userRepository, @Autowired JwtUtil jwtUtil)
    {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String authenticateUser(String email, String password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        User user;
        user = checkUser(email, password);

        if (user == null)
        {
            return "";
        }

        return jwtUtil.generateToken(user.getId());
    }

    private User checkUser(String emailProvided, String passwordProvided) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        User user = userRepository.findUserByEmail(emailProvided);

        if (user == null)
        {
            return null;
        }

        String salt = StringUtils.split(user.getPass(), '.')[0];
        String hashedPassword = StringUtils.split(user.getPass(), '.')[1];

        KeySpec spec = new PBEKeySpec(passwordProvided.toCharArray(), Base64.getDecoder().decode(salt), 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        String passwordProvidedHashed = Base64.getEncoder().encodeToString(factory.generateSecret(spec).getEncoded());

        if (!StringUtils.equals(passwordProvidedHashed, hashedPassword))
        {
            return null;
        }

        return user;
    }
}