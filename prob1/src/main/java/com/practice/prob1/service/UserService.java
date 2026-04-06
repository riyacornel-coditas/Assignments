package com.practice.prob1.service;

import com.practice.prob1.dto.UserCreate;
import com.practice.prob1.entity.User;
import com.practice.prob1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(UserCreate userCreate)
    {
        User user = new User();
        user.setName(userCreate.getName());
        user.setRole(userCreate.getRole());
        user.setPassword(userCreate.getPassword());
        return userRepository.save(user);
    }

    public UserCreate login(UserCreate userCreate)
    {
        if("admin".equals(userCreate.getRole()) && "1234".equals(userCreate.getPassword()))
        {
            return userCreate;

        }

        throw new RuntimeException("Login unsuccessful");


    }
}
