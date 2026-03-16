package com.example.UserReg.service;

import com.example.UserReg.entity.User;

public interface UserService {

    public void registerUser(User user);

    public String encodePassword(String password);

    public User login(String userNameOrEmail,String password);


}
