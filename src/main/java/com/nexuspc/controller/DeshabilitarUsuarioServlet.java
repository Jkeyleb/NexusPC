package com.nexuspc.controller;

import com.nexuspc.service.UserService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/deshabilitar-usuario")
public class DeshabilitarUsuarioServlet extends HttpServlet {

    private final UserService service =
            new UserService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id"));

        service.eliminar(id);

        response.sendRedirect(
                request.getContextPath()
                        + "/usuarios");

    }

}