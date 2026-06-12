package com.nexuspc.controller;

import com.nexuspc.model.Producto;
import com.nexuspc.service.ProductoService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/producto")
public class ProductoServlet extends HttpServlet {

    private final ProductoService service =
            new ProductoService();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Producto producto =
                new Producto();

        producto.setNombre(
                request.getParameter("nombre"));

        producto.setDescripcion(
                request.getParameter("descripcion"));

        producto.setPrecio(
                Double.parseDouble(
                        request.getParameter("precio")));

        producto.setStock(
                Integer.parseInt(
                        request.getParameter("stock")));

        producto.setStockMinimo(
                Integer.parseInt(
                        request.getParameter("stockMinimo")));

        producto.setProveedor(
                request.getParameter("proveedor"));

        service.guardar(producto);

        response.sendRedirect(
                request.getContextPath()
                        +
                        "/inventario");
    }
}