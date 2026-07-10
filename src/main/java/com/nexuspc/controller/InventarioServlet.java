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
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        request.setAttribute(
                "productos",
                service.listar()
        );

        request.setAttribute(
                "totalProductos",
                service.contarProductos());

        request.setAttribute(
                "stockBajo",
                service.contarStockBajo());

        request.setAttribute(
                "valorInventario",
                service.calcularValorInventario());

        request.getRequestDispatcher(
                "/views/admin/lista-productos.jsp"
        ).forward(
                request,
                response
        );
    }
}