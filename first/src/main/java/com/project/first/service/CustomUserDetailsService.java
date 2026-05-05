package com.project.first.service;

import com.project.first.repository.UserDetailsRepository;
import com.project.first.requestdto.AddUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService {

    private final UserDetailsRepository userDetailsRepository;


    public void addUser(AddUserDto addUserDto) {
    }
}
