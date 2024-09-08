//package com.org.config;
//
//import java.io.IOException;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class CorsFilter implements Filter {
//
//    public CorsFilter(UrlBasedCorsConfigurationSource source) {
//        super();
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//
//        // Add CORS headers to the response
//        response.setHeader("Access-Control-Allow-Origin", "*"); // Allow all origins (in production, specify the origin)
//        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//
//        // Handle preflight request for OPTIONS method
//        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
//            response.setStatus(HttpServletResponse.SC_OK);
//        } else {
//            chain.doFilter(req, res); // Pass the request along the filter chain
//        }
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Initialization logic if needed
//    }
//
//    @Override
//    public void destroy() {
//        // Cleanup logic if needed
//    }
//}
