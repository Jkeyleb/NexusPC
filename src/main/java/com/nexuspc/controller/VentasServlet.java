package com.nexuspc.controller;

import com.nexuspc.service.VentaService;
import java.time.LocalDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/ventas")
public class VentasServlet extends HttpServlet {

    private final VentaService service =
            new VentaService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String fecha =
                request.getParameter("fecha");

        if (fecha != null && !fecha.isBlank()) {

            request.setAttribute(
                    "ventas",
                    service.buscarPorFecha(
                            LocalDate.parse(fecha)));

            request.setAttribute(
                    "fechaSeleccionada",
                    fecha);

        } else {

            request.setAttribute(
                    "ventas",
                    service.listar());

        }

        request.setAttribute(
                "contenido",
                "/views/admin/lista-ventas.jsp");

        request.getRequestDispatcher(
                        "/layouts/admin-layout.jsp")
                .forward(request, response);

    }

}