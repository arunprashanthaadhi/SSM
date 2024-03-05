package com.ssm.webapp.controller;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String path = request.getRequestURI().substring(request.getContextPath().length());

        if (path.startsWith("/login")) { 
            chain.doFilter(req, res);
        } else {
            if (session != null && session.getAttribute("username") != null) {
                chain.doFilter(req, res);
            } else {
                response.sendRedirect("login.html"); 
            }
        }
    }
}
