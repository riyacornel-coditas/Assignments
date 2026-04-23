package com.assignment.Week9.service;

import com.assignment.Week9.dto.UserDto;
import com.assignment.Week9.entity.User;
import com.assignment.Week9.enums.Role;
import com.assignment.Week9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;

    private final PasswordEncoder encoder;


    public void createSuperAdmin(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(Role.SUPER_ADMIN);
        user.setPassword(encoder.encode(dto.getPassword()));

        repo.save(user);
    }

    public void createAdmin(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(Role.ADMIN);
        user.setPassword(encoder.encode(dto.getPassword()));

        repo.save(user);
    }

    public void createClientAdmin(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(Role.CLIENT_ADMIN);
        user.setPassword(encoder.encode(dto.getPassword()));

        repo.save(user);
    }

    public void createCandidate(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(Role.CANDIDATE);
        user.setPassword(encoder.encode(dto.getPassword()));

        repo.save(user);
    }
}
