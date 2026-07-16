package com.nexuspc.controller;

import com.nexuspc.model.User;
import com.nexuspc.service.AuthService;
import com.nexuspc.util.JwtUtil;
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
        String token =
                JwtUtil.generateToken(
                        user.getUsuario(),
                        user.getRole().getNombre()
                );

        session.setAttribute(
                "jwt",
                token
        );

        session.setAttribute(
                "user",
                user
        );

        String rol =
                user.getRole()
                        .getNombre();

        switch (rol) {

            case "ADMIN":
            case "VENDEDOR":
            case "ALMACEN":

                response.sendRedirect(
                        request.getContextPath()
                                + "/dashboard-admin");

                break;

            default:

                response.sendRedirect(
                        request.getContextPath()
                                + "/views/auth/login.jsp");

                break;
        }
    }
}