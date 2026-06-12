package com.nexuspc.controller;

import com.nexuspc.service.ProductoService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/eliminar-producto")
public class EliminarProductoServlet
        extends HttpServlet {

    private final ProductoService service =
            new ProductoService();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id =
                Integer.parseInt(
                        request.getParameter("id"));

        service.eliminar(id);

        response.sendRedirect(
                request.getContextPath()
                        +
                        "/inventario");
    }
}
