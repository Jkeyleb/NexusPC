package com.nexuspc.controller;

import com.nexuspc.service.ProductoService;
import com.nexuspc.service.ClienteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/dashboard-admin")
public class DashboardAdminServlet extends HttpServlet {

    private final ProductoService service =
            new ProductoService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "totalProductos",
                service.contarProductos());

        request.setAttribute(
                "stockBajo",
                service.contarStockBajo());

        request.setAttribute(
                "valorInventario",
                String.format("%.2f",
                        service.calcularValorInventario()));

        request.setAttribute(
                "totalClientes",
                clienteService.contarClientes());

        request.setAttribute(
                "ultimosProductos",
                service.ultimosProductos());

        request.setAttribute(
                "fechaActual",
                java.time.LocalDate.now());

        request.setAttribute(
                "contenido",
                "/views/admin/dashboard-admin.jsp");

        request.getRequestDispatcher(
                        "/layouts/admin-layout.jsp")
                .forward(request,response);

    }

    private final ClienteService clienteService =
            new ClienteService();
}