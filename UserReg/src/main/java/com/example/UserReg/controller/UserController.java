package com.example.UserReg.controller;

import com.example.UserReg.entity.User;
import com.example.UserReg.exception.ApplicationResponse;
import com.example.UserReg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import java.util.Map;

@RestController
@RequestMapping("/POST/api")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<ApplicationResponse> registerUser(@Valid @RequestBody User user){
        userService.registerUser(user);
        ApplicationResponse applicationResponse=new ApplicationResponse("User Registered Successfully");
        return new ResponseEntity<>(applicationResponse, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ApplicationResponse>loginUser(@RequestBody Map<String,String> loginRequest){
        userService.login(loginRequest.get("userNameorEmail"),loginRequest.get("password"));
        ApplicationResponse applicationResponse=new ApplicationResponse("User Logged In successfully");
        return new ResponseEntity<>(applicationResponse,HttpStatus.OK);
    }
}
