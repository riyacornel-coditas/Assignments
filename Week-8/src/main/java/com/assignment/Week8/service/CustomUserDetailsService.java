package com.assignment.Week8.service;

import com.assignment.Week8.dto.AddUser;
import com.assignment.Week8.entity.Users;
import com.assignment.Week8.repository.UserDetailsRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userDetailsRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users addUser(AddUser addUser) {
        Users user = new Users();

        user.setUsername(addUser.getUsername());
        user.setPassword(passwordEncoder.encode(addUser.getPassword()));
        user.setRole(addUser.getRole());

        userDetailsRepository.save(user);

        return user;
    }
}
