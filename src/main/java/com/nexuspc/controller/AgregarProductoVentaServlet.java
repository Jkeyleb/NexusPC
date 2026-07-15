package com.nexuspc.controller;

import com.nexuspc.model.DetalleVenta;
import com.nexuspc.model.Producto;
import com.nexuspc.service.ProductoService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/agregar-producto-venta")
public class AgregarProductoVentaServlet extends HttpServlet {

    private final ProductoService productoService =
            new ProductoService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        int idProducto = Integer.parseInt(
                request.getParameter("idProducto"));

        int cantidad = Integer.parseInt(
                request.getParameter("cantidad"));

        Producto producto =
                productoService.buscarPorId(idProducto);

        DetalleVenta detalle =
                new DetalleVenta();

        detalle.setProducto(producto);

        detalle.setCantidad(cantidad);

        detalle.setPrecioUnitario(
                producto.getPrecio());

        detalle.setSubtotal(
                producto.getPrecio()*cantidad);

        HttpSession session =
                request.getSession();

        List<DetalleVenta> carrito =
                (List<DetalleVenta>) session.getAttribute("carrito");

        if(carrito==null){

            carrito = new ArrayList<>();

        }

        boolean encontrado = false;

        for (DetalleVenta item : carrito) {

            if (item.getProducto().getIdProducto()
                    == detalle.getProducto().getIdProducto()) {

                item.setCantidad(
                        item.getCantidad() + cantidad);

                item.setSubtotal(
                        item.getCantidad()
                                * item.getPrecioUnitario());

                encontrado = true;

                break;
            }

        }

        if (!encontrado) {

            carrito.add(detalle);

        }

        session.setAttribute(
                "carrito",
                carrito);

        response.sendRedirect(
                request.getContextPath()
                        + "/nueva-venta");

    }

}