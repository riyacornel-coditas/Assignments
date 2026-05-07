package com.project.first.service;

import com.project.first.entity.Company;
import com.project.first.entity.Users;
import com.project.first.enums.CompanyStatus;
import com.project.first.enums.Role;
import com.project.first.repository.CompanyRepository;
import com.project.first.repository.UserDetailsRepository;
import com.project.first.requestdto.AddUserDto;
import jakarta.transaction.Transactional;
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

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String name) {

        Users user = userDetailsRepository.findByName(name)
                .orElse(null);

        if(user!=null) {
            return org.springframework.security.core.userdetails.User
                    .builder()
                    .username(user.getName())
                    .password(user.getPassword())
                    .roles(user.getRole().name())
                    .build();
        }

        Company company = companyRepository.findByName(name).orElse(null);

        if(company!=null)
        {
            return org.springframework.security.core.userdetails.User
                    .builder()
                    .username(company.getName())
                    .password(company.getPassword())
                    .roles("COMPANY")
                    .build();
        }
        throw new UsernameNotFoundException("User not found");
    }

    @Transactional
    public void createUser(AddUserDto addUserDto) {


        Role role = Role.valueOf(addUserDto.getRole());

        if(role==Role.ADMIN) {
            if(userDetailsRepository.findByEmail(addUserDto.getEmail()).isPresent())
            {
                throw new RuntimeException("email already exists");
            }
            if(addUserDto.getName() == null || addUserDto.getName().isBlank()) {
                throw new RuntimeException("name is required");
            }

            if(addUserDto.getPassword() == null || addUserDto.getPassword().isBlank()) {
                throw new RuntimeException("password is required");
            }

            if(addUserDto.getEmail() == null || addUserDto.getEmail().isBlank()) {
                throw new RuntimeException("email is required");
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
            if(addUserDto.getCompanyName() == null || addUserDto.getCompanyName().isBlank()) {
                throw new RuntimeException("companyName is required");
            }

            if(addUserDto.getCompanyType() == null || addUserDto.getCompanyType().isBlank()) {
                throw new RuntimeException("companyType is required");
            }

            if(addUserDto.getPassword() == null || addUserDto.getPassword().isBlank()) {
                throw new RuntimeException("password is required");
            }

            Company c = new Company();
            c.setName(addUserDto.getCompanyName());
            c.setType(addUserDto.getCompanyType());
            c.setCompanyStatus(CompanyStatus.ACTIVE);
            c.setPassword(passwordEncoder.encode(addUserDto.getPassword()));

            companyRepository.save(c);
        }
    }
}
