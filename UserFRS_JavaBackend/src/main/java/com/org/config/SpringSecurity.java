/*package com.org.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for API usage
            .authorizeRequests(authorize -> authorize
                .requestMatchers("/booking/**", "/flights/**").authenticated() // Protect user operations
                .anyRequest().permitAll() // Allow public access to other endpoints
            )
            .httpBasic(); // Use basic authentication for simplicity
        
        return http.build();
    }

    @Bean
    public UserDetailsService inMemoryUserDetailsService(PasswordEncoder passwordEncoder) {
        String username = "user";
        String rawPassword = "userpass"; // Set your raw password here

        String encodedPassword = passwordEncoder.encode(rawPassword); // Encode the raw password

        UserDetails user = User.builder()
                .username(username)
                .password(encodedPassword)
                .roles("USER")
                .build();
        
        System.out.println("In-Memory User Created:");
        System.out.println("Username: " + username);
        System.out.println("Encoded Password: " + encodedPassword); // Log the encoded password to console
        
        return new InMemoryUserDetailsManager(user); // Return the in-memory user details manager
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCryptPasswordEncoder as the password encoder
    }
}*/




package com.org.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for API usage
            .authorizeRequests(authorize -> authorize
                .requestMatchers("/booking/**", "/flights/**").authenticated() // Protect user operations
                .anyRequest().permitAll() // Allow public access to other endpoints
            )
            .httpBasic(); // Use basic authentication for simplicity
        
        return http.build();
    }

    @Bean
    public UserDetailsService inMemoryUserDetailsService() {
        String username = "user";
        String password = "userpass"; // Set your password here

        UserDetails user = User.withDefaultPasswordEncoder() // Simple password encoder
                .username(username)
                .password(password)
                .roles("USER")
                .build();
        
        System.out.println("In-Memory User Created:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password); // Manually print the password to console
        
        return new InMemoryUserDetailsManager(user); // Return the in-memory user details manager
    }
}

