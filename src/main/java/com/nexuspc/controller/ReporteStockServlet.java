package com.nexuspc.controller;

import com.nexuspc.service.ProductoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/reporte-stock")
public class ReporteStockServlet extends HttpServlet {

    private final ProductoService service =
            new ProductoService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "productos",
                service.listarStockBajo());

        request.setAttribute(
                "contenido",
                "/views/admin/reporte-stock.jsp");

        request.getRequestDispatcher(
                        "/layouts/admin-layout.jsp")
                .forward(request, response);
    }
}