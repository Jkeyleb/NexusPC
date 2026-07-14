package com.nexuspc.controller;

import com.nexuspc.service.ProductoService;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/inventario")
public class InventarioServlet extends HttpServlet {

    private final ProductoService service =
            new ProductoService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String buscar = request.getParameter("buscar");

        if (buscar != null && !buscar.trim().isEmpty()) {

            request.setAttribute(
                    "productos",
                    service.buscar(buscar));

        } else {

            request.setAttribute(
                    "productos",
                    service.listar());
        }

        request.setAttribute(
                "totalProductos",
                service.contarProductos());

        request.setAttribute(
                "stockBajo",
                service.contarStockBajo());

        request.setAttribute(
                "valorInventario",
                service.calcularValorInventario());

        request.setAttribute(
                "contenido",
                "/views/admin/lista-productos.jsp");

        request.getRequestDispatcher(
                        "/layouts/admin-layout.jsp")
                .forward(request,response);
    }
}