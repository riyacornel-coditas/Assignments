package com.project.first.config;

import com.project.first.filters.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider)
    {
        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService,
                                                         PasswordEncoder passwordEncoder)
    {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationProvider authProvider)
    {
        http
                .authenticationProvider(authProvider)
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/users/add").permitAll()      //how will admin add company through same endpoint
                        .requestMatchers("/authenticate").permitAll()
                        .requestMatchers("/users/view/**").hasRole("ADMIN")
                        .requestMatchers("/submission/make").permitAll()
                        .requestMatchers("/enroll/employee").permitAll()
                        .requestMatchers("/employee/add/**").hasRole("COMPANY")
                        .requestMatchers("/employee/get/**").permitAll()
                        .requestMatchers("/courses/**").hasRole("ADMIN")
                        .requestMatchers("/company/**").hasRole("ADMIN")
                        .requestMatchers("/assignment/**").hasRole("ADMIN")
                );

        http.csrf(csrf-> csrf.disable());

        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
