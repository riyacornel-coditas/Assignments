package com.interview.ps.config;

import com.interview.ps.filters.JwtAuthFilter;
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

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationProvider authProvider)
    {
        http
                .authenticationProvider(authProvider)
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/create/admin").permitAll()
                        .requestMatchers("/create/user").permitAll()
                        .requestMatchers("/authenticate").permitAll()
                        .requestMatchers("/aircrafts/add").hasRole("ADMIN")
                        .requestMatchers("/aircrafts/getall").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/airlines/add/{id}").hasRole("ADMIN")
                        .requestMatchers("/airlines/getall").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/airports/add").hasRole("ADMIN")
                        .requestMatchers("/airports/getall").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/booking/make").hasRole("USER")
                        .requestMatchers("/flights/add").hasRole("ADMIN")
                        .requestMatchers("/flights/get/**").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/payments/add/details").hasRole("USER")
                        .requestMatchers("/payments/make/**").hasRole("USER")
                        .requestMatchers("/flights/getall").hasAnyRole("USER","ADMIN")

                );

        http.csrf(csrf-> csrf.disable());

        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }



}
