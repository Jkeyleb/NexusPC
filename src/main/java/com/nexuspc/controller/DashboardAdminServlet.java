package com.nexuspc.controller;

import com.nexuspc.service.ProductoService;

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
                service.calcularValorInventario());

        request.setAttribute(
                "ultimosProductos",
                service.ultimosProductos());

        request.getRequestDispatcher(
                        "/views/admin/dashboard-admin.jsp")
                .forward(request,response);

    }
}