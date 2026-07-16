package com.nexuspc.controller;

import com.nexuspc.service.ClienteService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editar-cliente")
public class EditarClienteServlet extends HttpServlet {

    private final ClienteService service =
            new ClienteService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id"));

        request.setAttribute(
                "cliente",
                service.buscarPorId(id));

        request.setAttribute(
                "contenido",
                "/views/admin/editar-cliente.jsp");

        request.getRequestDispatcher(
                        "/layouts/admin-layout.jsp")
                .forward(request,response);

    }

}