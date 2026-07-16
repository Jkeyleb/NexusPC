package com.nexuspc.controller;

import com.nexuspc.model.Venta;
import com.nexuspc.service.VentaService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/detalle-venta")
public class DetalleVentaServlet extends HttpServlet {

    private final VentaService ventaService =
            new VentaService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int idVenta = Integer.parseInt(
                request.getParameter("id"));

        Venta venta =
                ventaService.buscarPorId(idVenta);

        request.setAttribute(
                "venta",
                venta);

        request.setAttribute(
                "detalles",
                ventaService.listarDetalles(idVenta));

        request.setAttribute(
                "contenido",
                "/views/admin/detalle-venta.jsp");

        request.getRequestDispatcher(
                        "/layouts/admin-layout.jsp")
                .forward(request, response);

    }

}