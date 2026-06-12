package com.nexuspc.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/views/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse resp =
                (HttpServletResponse) response;

        HttpSession session =
                req.getSession(false);

        boolean logged =
                session != null &&
                        session.getAttribute("user") != null;

        String uri =
                req.getRequestURI();

        boolean publicPage =
                uri.contains("login.jsp")
                        ||
                        uri.contains("register.jsp");

        if (logged || publicPage) {

            chain.doFilter(
                    request,
                    response
            );

        } else {

            resp.sendRedirect(
                    req.getContextPath()
                            +
                            "/views/auth/login.jsp"
            );
        }
    }
}