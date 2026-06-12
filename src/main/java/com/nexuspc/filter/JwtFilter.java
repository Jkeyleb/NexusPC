package com.nexuspc.filter;

import com.nexuspc.util.JwtUtil;

import io.jsonwebtoken.Claims;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/api/*")
public class JwtFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        String header =
                req.getHeader("Authorization");

        if (header == null ||
                !header.startsWith("Bearer ")) {

            ((HttpServletResponse) response)
                    .sendError(401);

            return;
        }

        String token =
                header.substring(7);

        try {

            Claims claims =
                    JwtUtil.validateToken(
                            token
                    );

            req.setAttribute(
                    "claims",
                    claims
            );

            chain.doFilter(
                    request,
                    response
            );

        } catch (Exception ex) {

            ((HttpServletResponse) response)
                    .sendError(401);
        }
    }
}