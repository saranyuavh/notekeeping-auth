package com.notekeeping_auth.auth.service;

import com.notekeeping_auth.auth.entity.User;
import com.notekeeping_auth.auth.entity.UserPrincipal;
import com.notekeeping_auth.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        boolean isUserPresent = userRepository.existsByEmail(username);

        if(isUserPresent) {
            return new UserPrincipal(userRepository.getUserByEmail(username).orElse(new User()));
        }

        User user = userRepository.getUserByUsername(username).orElseThrow(() -> (new UsernameNotFoundException(username +" not registered")));

        return new UserPrincipal(user);
    }
}
