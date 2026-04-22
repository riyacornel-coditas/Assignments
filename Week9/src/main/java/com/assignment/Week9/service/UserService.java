package com.assignment.Week9.service;

import com.assignment.Week9.dto.UserDto;
import com.assignment.Week9.entity.User;
import com.assignment.Week9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;

    private final PasswordEncoder encoder;


    public User createUser(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setPassword(encoder.encode(dto.getPassword()));

        return repo.save(user);
    }
}
