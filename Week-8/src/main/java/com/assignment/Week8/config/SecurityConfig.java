package com.assignment.Week8.config;


import com.assignment.Week8.filters.JwtAuthFilter;
import com.assignment.Week8.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationProvider authProvider) throws Exception{
        http
                .authenticationProvider(authProvider)
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/users/**").permitAll()
                                .requestMatchers("/authenticate").permitAll()
                                .requestMatchers("/tasks/get/alltasks").hasRole("ADMIN")
                                .anyRequest().authenticated()
//                        .anyRequest().permitAll()
                );
//                .httpBasic(Customizer.withDefaults());

        http.csrf(csrf->csrf.disable());

        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        //http.formLogin(form -> form.disable()) ;  // ❗ disable default login
               // .httpBasic(basic -> basic.disable()); // ❗ disable basic auth

        return http.build();

    }

//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//        return new CustomUserDetailsService();
//    }


    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService
                                                       , PasswordEncoder passwordEncoder)
    {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationProvider provider) {
        return new ProviderManager(provider);
    }
}


