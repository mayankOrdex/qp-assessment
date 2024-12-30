package com.qp.assessment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
            .authorizeHttpRequests(authz -> authz
                
            		 // Deny 'available-items' for ADMIN but allow for USER
                    .requestMatchers("/rest/groceryitem/available-items").hasRole("USER")

                    // Admin access to all other grocery item endpoints
                    .requestMatchers("/rest/groceryitem/**").hasRole("ADMIN")

                    // User access to orders
                    .requestMatchers("/rest/order/**").hasRole("USER")
                
                // Any other request must be authenticated
                .anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults()) // Use Customizer.withDefaults() for HTTP Basic
            .build();
    }

    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        // Create an 'admin' user
        manager.createUser(
            User.withUsername("admin")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
                .build()
        );

        // Create a 'user' user
        manager.createUser(
            User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build()
        );

        return manager;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCrypt for password encoding
    }

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
            .userDetailsService(userDetailsService())
            .passwordEncoder(passwordEncoder());

        return authenticationManagerBuilder.build();
    }
}