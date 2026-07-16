package com.nexuspc.controller;

import com.nexuspc.service.ClienteService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/eliminar-cliente")
public class EliminarClienteServlet extends HttpServlet {

    private final ClienteService service =
            new ClienteService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id"));

        service.eliminar(id);

        response.sendRedirect(
                request.getContextPath()
                        + "/clientes");

    }

}