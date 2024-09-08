//package com.org.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//    private final JwtRequestFilter jwtRequestFilter;
//
//    public SecurityConfig(UserDetailsService userDetailsService, JwtRequestFilter jwtRequestFilter) {
//        this.userDetailsService = userDetailsService;
//        this.jwtRequestFilter = jwtRequestFilter;
//    }
//
//    // Password encoder bean
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // Use Spring Security's AuthenticationConfiguration to configure AuthenticationManager
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    // Security filter chain configuration
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .cors().and()  // Enable default CORS configuration
//            .csrf().disable()  // Disable CSRF protection for stateless applications
//            .authorizeRequests()
//                .requestMatchers("/api/auth/**").permitAll()  // Allow public access to these endpoints
//                .requestMatchers("/admin?**").hasAnyRole("admin")
//                .anyRequest().authenticated()  // All other endpoints require authentication
//            .and()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // Stateless session management
//            .and()
//            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);  // Add JWT filter before the authentication filter
//
//        return http.build();
//    }
//
//    // CORS configuration
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOriginPattern("*");  // Allow all origins (you can restrict this for better security)
//        config.addAllowedHeader("*");  // Allow all headers
//        config.addAllowedMethod("*");  // Allow all HTTP methods (GET, POST, etc.)
//        source.registerCorsConfiguration("/**", config);  // Apply this CORS configuration to all endpoints
//        return new CorsFilter(source);
//    }
//}
//package com.org.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//    private final JwtRequestFilter jwtRequestFilter;
//
//    public SecurityConfig(UserDetailsService userDetailsService, JwtRequestFilter jwtRequestFilter) {
//        this.userDetailsService = userDetailsService;
//        this.jwtRequestFilter = jwtRequestFilter;
//    }
//
//    // Password encoder bean
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // Use Spring Security's AuthenticationConfiguration to configure AuthenticationManager
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    // Security filter chain configuration
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .cors(cors -> cors
//                .configurationSource(request -> {
//                    CorsConfiguration config = new CorsConfiguration();
//                    config.setAllowCredentials(true);
//                    config.addAllowedOriginPattern("*");  // Allow all origins (you can restrict this for better security)
//                    config.addAllowedHeader("*");  // Allow all headers
//                    config.addAllowedMethod("*");  // Allow all HTTP methods (GET, POST, etc.)
//                    return config;
//                })
//            )
//            .csrf().disable()  // Disable CSRF protection for stateless applications
//            .authorizeRequests()
//                .requestMatchers("/api/auth/**").permitAll()  // Allow public access to these endpoints
//                .anyRequest().authenticated()  // All other endpoints require authentication
//            .and()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // Stateless session management
//            .and()
//            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);  // Add JWT filter before the authentication filter
//
//        return http.build();
//    }
//}
