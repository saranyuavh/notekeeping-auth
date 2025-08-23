package com.notekeeping_auth.auth.service;

import com.notekeeping_auth.auth.Exception.AuthException;
import com.notekeeping_auth.auth.dto.SignupRequest;
import com.notekeeping_auth.auth.dto.SignupResponse;
import com.notekeeping_auth.auth.entity.User;
import com.notekeeping_auth.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;
    @Autowired
    void setUserRepository(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public SignupResponse signup(SignupRequest signupRequest) throws AuthException {

        if(userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new AuthException("User with Email "+signupRequest.getEmail()+" Already Exists");
        }

        if(userRepository.existsByUsername(signupRequest.getUsername())) {
            throw new AuthException("User with Username "+signupRequest.getUsername()+" Already Exists");
        }

        SignupResponse response;
        try {
            String encryptedPassword = passwordEncoder.encode(signupRequest.getPassword());

            User user = new User().builder()
                    .email(signupRequest.getEmail())
                    .password(encryptedPassword)
                    .username(signupRequest.getUsername())
                    .firstName(signupRequest.getFirstName())
                    .lastName(signupRequest.getLastName())
                    .build();

            User createdUser = userRepository.save(user);

            response = new SignupResponse(createdUser.getId(), createdUser.getEmail(), createdUser.getUsername(), createdUser.getFirstName(), createdUser.getLastName());
        } catch (Exception e) {
            throw new AuthException(e.getMessage());
        }

        return response;

    }
}
