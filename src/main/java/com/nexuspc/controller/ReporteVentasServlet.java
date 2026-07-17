package com.nexuspc.controller;

import com.nexuspc.model.Venta;
import com.nexuspc.service.VentaService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/reporte-ventas")
public class ReporteVentasServlet extends HttpServlet {

    private final VentaService ventaService =
            new VentaService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String desde = request.getParameter("desde");
        String hasta = request.getParameter("hasta");

        List<Venta> ventas;

        if (desde != null && !desde.isEmpty()
                && hasta != null && !hasta.isEmpty()) {

            ventas = ventaService.listarPorFechas(desde, hasta);

        } else {

            ventas = ventaService.listar();

        }

        double totalVentas = 0;

        for (Venta venta : ventas) {

            totalVentas += venta.getTotal();

        }

        request.setAttribute("ventas", ventas);
        request.setAttribute("desde", desde);
        request.setAttribute("hasta", hasta);
        request.setAttribute("totalVentas", totalVentas);

        request.setAttribute(
                "contenido",
                "/views/admin/reporte-ventas.jsp");

        request.getRequestDispatcher(
                        "/layouts/admin-layout.jsp")
                .forward(request, response);

    }

}