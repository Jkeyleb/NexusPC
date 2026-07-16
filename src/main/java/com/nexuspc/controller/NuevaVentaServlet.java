package com.nexuspc.controller;

import com.nexuspc.service.ClienteService;
import com.nexuspc.service.ProductoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/nueva-venta")
public class NuevaVentaServlet extends HttpServlet {

    private final ClienteService clienteService =
            new ClienteService();

    private final ProductoService productoService =
            new ProductoService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "clientes",
                clienteService.listar());

        request.setAttribute(
                "productos",
                productoService.listar());

        request.setAttribute(
                "contenido",
                "/views/admin/nueva-venta.jsp");

        HttpSession session =
                request.getSession();

        request.setAttribute(
                "idClienteSeleccionado",
                session.getAttribute("idClienteSeleccionado"));

        request.getRequestDispatcher(
                        "/layouts/admin-layout.jsp")
                .forward(request, response);

    }

}