package com.project.first.service;

import com.project.first.entity.Company;
import com.project.first.entity.Users;
import com.project.first.enums.CompanyStatus;
import com.project.first.enums.Role;
import com.project.first.repository.CompanyRepository;
import com.project.first.repository.UserDetailsRepository;
import com.project.first.requestdto.AddUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


    private final PasswordEncoder passwordEncoder;

    private final UserDetailsRepository userDetailsRepository;
    private final CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String name) {

        Users user = userDetailsRepository.findByName(name)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getName())
                .password(user.getPassword())
                .build();
    }

    public void add(AddUserDto addUserDto) {


        Role role = Role.valueOf(addUserDto.getRole());

        if(role==Role.ADMIN) {
            if(userDetailsRepository.findByEmail(addUserDto.getEmail()).isPresent())
            {
                throw new RuntimeException("email already exists");
            }
            Users u = new Users();
            u.setName(addUserDto.getName());
            u.setPassword(passwordEncoder.encode(addUserDto.getPassword()));
            u.setEmail(addUserDto.getEmail());
            u.setRole(Role.ADMIN);

            userDetailsRepository.save(u);
        }

        else if(role==Role.COMPANY)
        {
            if(companyRepository.existsByName(addUserDto.getCompanyName()))
            {
                throw new RuntimeException("Company already exists");
            }
            Company c = new Company();
            c.setName(addUserDto.getCompanyName());
            c.setType(addUserDto.getCompanyType());
            c.setCompanyStatus(CompanyStatus.ACTIVE);

            companyRepository.save(c);
        }
    }
}
