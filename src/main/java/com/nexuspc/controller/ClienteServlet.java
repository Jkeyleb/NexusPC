package com.nexuspc.controller;

import com.nexuspc.model.Cliente;
import com.nexuspc.service.ClienteService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {

    private final ClienteService service = new ClienteService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "clientes",
                service.listar());

        request.getRequestDispatcher(
                        "/views/admin/lista-clientes.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Cliente cliente = new Cliente();

        cliente.setNombre(request.getParameter("nombre"));
        cliente.setTipo(request.getParameter("tipo"));
        cliente.setTelefono(request.getParameter("telefono"));
        cliente.setEmail(request.getParameter("email"));

        service.registrar(cliente);

        response.sendRedirect(
                request.getContextPath() + "/clientes");
    }
}