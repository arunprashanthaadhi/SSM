package com.ssm.webapp.controller;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;


public class RequestTrackingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("RequestTrackingFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        

        String ipAddress = request.getRemoteAddr();
        String uri = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();
        
        System.out.println("Request from IP " + ipAddress + " for " + uri + " using method " + method + " at " + System.currentTimeMillis());
        
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("RequestTrackingFilter destroyed");
    }
}
