package com.nexuspc.controller;

import com.nexuspc.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editar-usuario")
public class EditarUsuarioServlet extends HttpServlet {

    private final UserService service =
            new UserService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id"));

        request.setAttribute(
                "usuario",
                service.buscarPorId(id));

        request.setAttribute(
                "contenido",
                "/views/admin/editar-usuario.jsp");

        request.getRequestDispatcher(
                        "/layouts/admin-layout.jsp")
                .forward(request, response);

    }

}