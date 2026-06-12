package com.nexuspc.filter;

import com.nexuspc.model.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter({
        "/views/admin/*",
        "/views/vendedor/*",
        "/views/almacen/*"
})
public class RoleFilter implements Filter {

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

        User user =
                (User) session.getAttribute("user");

        String role =
                user.getRole().getNombre();

        String uri =
                req.getRequestURI();

        if (uri.contains("/admin/")
                &&
                !role.equals("ADMIN")) {

            resp.sendError(403);
            return;
        }

        if (uri.contains("/vendedor/")
                &&
                !role.equals("VENDEDOR")) {

            resp.sendError(403);
            return;
        }

        if (uri.contains("/almacen/")
                &&
                !role.equals("ALMACEN")) {

            resp.sendError(403);
            return;
        }

        chain.doFilter(
                request,
                response
        );
    }
}