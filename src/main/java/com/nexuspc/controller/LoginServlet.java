package com.nexuspc.controller;

import com.nexuspc.model.User;
import com.nexuspc.service.AuthService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final AuthService authService =
            new AuthService();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        String usuario =
                request.getParameter("usuario");

        String password =
                request.getParameter("password");

        User user =
                authService.login(
                        usuario,
                        password
                );

        if (user == null) {

            response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "Credenciales inválidas"
            );

            return;
        }

        HttpSession session =
                request.getSession();

        session.setAttribute(
                "user",
                user
        );

        String rol =
                user.getRole()
                        .getNombre();

        switch (rol) {

            case "ADMIN":

                response.sendRedirect(
                        "views/admin/dashboard-admin.jsp"
                );

                break;

            case "VENDEDOR":

                response.sendRedirect(
                        "views/vendedor/dashboard-vendedor.jsp"
                );

                break;

            case "ALMACEN":

                response.sendRedirect(
                        "views/almacen/dashboard-almacen.jsp"
                );

                break;

            default:

                response.sendRedirect(
                        "views/auth/login.jsp"
                );
        }
    }
}