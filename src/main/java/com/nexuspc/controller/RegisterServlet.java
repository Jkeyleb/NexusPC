package com.nexuspc.controller;

import com.nexuspc.model.Role;
import com.nexuspc.model.User;
import com.nexuspc.service.AuthService;
import com.nexuspc.util.BCryptUtil;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final AuthService authService =
            new AuthService();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        String nombre =
                request.getParameter("nombre");

        String usuario =
                request.getParameter("usuario");

        String password =
                request.getParameter("password");

        int idRol =
                Integer.parseInt(
                        request.getParameter("rol")
                );

        Role role = new Role();
        role.setIdRol(idRol);

        User user = new User();
        user.setNombre(nombre);
        user.setUsuario(usuario);
        user.setPassword(
                BCryptUtil.hashPassword(password)
        );
        user.setRole(role);

        boolean registrado =
                authService.register(user);

        if (registrado) {

            response.sendRedirect(
                    "views/auth/login.jsp"
            );

        } else {

            response.getWriter()
                    .println("Error al registrar");
        }
    }
}