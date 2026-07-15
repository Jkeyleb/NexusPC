package com.nexuspc.controller;

import com.nexuspc.model.Role;
import com.nexuspc.model.User;
import com.nexuspc.service.UserService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/registrar-usuario")
public class RegistrarUsuarioServlet extends HttpServlet {

    private final UserService service =
            new UserService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        User user = new User();

        user.setNombre(
                request.getParameter("nombre"));

        user.setUsuario(
                request.getParameter("usuario"));

        user.setPassword(
                request.getParameter("password"));

        Role role = new Role();

        role.setIdRol(
                Integer.parseInt(
                        request.getParameter("idRol")));

        user.setRole(role);

        service.registrar(user);

        response.sendRedirect(
                request.getContextPath()
                        + "/usuarios");

    }

}