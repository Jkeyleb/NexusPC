package com.nexuspc.controller;

import com.nexuspc.model.Producto;
import com.nexuspc.service.ProductoService;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editar-producto")
public class EditarProductoServlet extends HttpServlet {

    private final ProductoService service =
            new ProductoService();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        int id =
                Integer.parseInt(
                        request.getParameter("id"));

        Producto producto =
                service.buscarPorId(id);

        request.setAttribute(
                "producto",
                producto);

        request.setAttribute(
                "contenido",
                "/views/admin/editar-producto.jsp");

        request.getRequestDispatcher(
                        "/layouts/admin-layout.jsp")
                .forward(
                        request,
                        response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Producto p =
                new Producto();

        p.setIdProducto(
                Integer.parseInt(
                        request.getParameter("id")));

        p.setNombre(
                request.getParameter("nombre"));

        p.setDescripcion(
                request.getParameter("descripcion"));

        p.setPrecio(
                Double.parseDouble(
                        request.getParameter("precio")));

        p.setStock(
                Integer.parseInt(
                        request.getParameter("stock")));

        p.setStockMinimo(
                Integer.parseInt(
                        request.getParameter("stockMinimo")));

        p.setProveedor(
                request.getParameter("proveedor"));

        service.actualizar(p);

        response.sendRedirect(
                request.getContextPath()
                        +
                        "/nuevo-producto");
    }
}
