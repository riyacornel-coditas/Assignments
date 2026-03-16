package com.example.UserReg.service;

import com.example.UserReg.entity.User;
import com.example.UserReg.exception.UserCredentialsNotValid;
import com.example.UserReg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImplementation {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;
    public void registerUser(User user) throws Throwable {
        if(userRepository.existsByUsername(user.getUserName())){
            throw new Throwable("Username Already exist");
        }else if(userRepository.existsByEmail(user.getEmail())){
            throw new Throwable("Email Already exist");
        }else{
            user.setPassword(encodePassword(user.getPassword()));
            userRepository.save(user);
        }

    }

    public String encodePassword(String password){
        return encoder.encode(password);
    }

    public String userLogin(String userNameOrEmail,String password) throws Throwable {
        if(!userRepository.existsByUsername(userNameOrEmail)){
            throw new Throwable("Username Does not exist");
        }
        if(encoder.matches(password,userRepository.getEncodedPassword(userNameOrEmail))){
            return "User Logged in Successfully";
        }else{
            throw new UserCredentialsNotValid("User Credentials Not valid");
        }

    }
}
