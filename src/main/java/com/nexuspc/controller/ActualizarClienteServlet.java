package com.nexuspc.controller;

import com.nexuspc.model.Cliente;
import com.nexuspc.service.ClienteService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/actualizar-cliente")
public class ActualizarClienteServlet extends HttpServlet {

    private final ClienteService service =
            new ClienteService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        Cliente cliente =
                new Cliente();

        cliente.setIdCliente(
                Integer.parseInt(
                        request.getParameter("id")));

        cliente.setNombre(
                request.getParameter("nombre"));

        cliente.setTipo(
                request.getParameter("tipo"));

        cliente.setTelefono(
                request.getParameter("telefono"));

        cliente.setEmail(
                request.getParameter("email"));

        service.actualizar(cliente);

        response.sendRedirect(
                request.getContextPath()
                        + "/clientes");

    }

}