//package com.interview.ps.service;
//
//import com.interview.ps.dto.AddUser;
//import com.interview.ps.entity.Users;
//import com.interview.ps.enums.Role;
//import com.interview.ps.repository.UserDetailsRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserDetailsRepository userDetailsRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//
//        Users user = userDetailsRepository.findByUsername(username)
//                .orElseThrow(()->new UsernameNotFoundException("User not found"));
//
//        return org.springframework.security.core.userdetails.User
//                .builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .build();
//    }
//
//
//    public void addUser(AddUser user) {
//
//        Users u = new Users();
//        u.setUsername(user.getUsername());
//        u.setPassword(passwordEncoder.encode(user.getPassword()));
//        u.setRole(Role.USER);
//
//        userDetailsRepository.save(u);
//    }
//
//    public void addAdmin(AddUser user) {
//
//        Users u = new Users();
//        u.setUsername(user.getUsername());
//        u.setPassword(passwordEncoder.encode(user.getPassword()));
//        u.setRole(Role.ADMIN);
//
//        userDetailsRepository.save(u);
//    }
//
//
//}
