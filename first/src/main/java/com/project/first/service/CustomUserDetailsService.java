package com.project.first.service;

import com.project.first.entity.Users;
import com.project.first.enums.Role;
import com.project.first.repository.UserDetailsRepository;
import com.project.first.requestdto.AddUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService {

    private final UserDetailsRepository userDetailsRepository;


    public void addAdmin(AddUserDto addUserDto) {
        Users u = new Users();
        u.setName(addUserDto.getName());
        u.setPassword(addUserDto.getPassword());
        u.setEmail(addUserDto.getEmail());
        u.setRole(Role.ADMIN);

        userDetailsRepository.save(u);
    }
}
