package com.nexuspc.controller;

import com.nexuspc.model.*;
import com.nexuspc.service.ClienteService;
import com.nexuspc.service.UserService;
import com.nexuspc.service.VentaService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/registrar-venta")
public class RegistrarVentaServlet extends HttpServlet {

    private final VentaService ventaService =
            new VentaService();

    private final ClienteService clienteService =
            new ClienteService();

    private final UserService userService =
            new UserService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<DetalleVenta> carrito =
                (List<DetalleVenta>)
                        session.getAttribute("carrito");

        if(carrito == null || carrito.isEmpty()){

            response.sendRedirect(
                    request.getContextPath()
                            + "/ventas");

            return;
        }

        int idCliente =
                Integer.parseInt(
                        request.getParameter("idCliente"));

        Venta venta = new Venta();

        venta.setFecha(LocalDateTime.now());
        System.out.println("ID Cliente recibido: " + request.getParameter("idCliente"));
        venta.setCliente(
                clienteService.buscarPorId(idCliente));

        User usuario = (User) session.getAttribute("user");

        System.out.println("===== DEBUG =====");
        System.out.println("Usuario en sesión: " + usuario);

        if (usuario != null) {
            System.out.println("ID Usuario: " + usuario.getIdUsuario());
            System.out.println("Nombre: " + usuario.getNombre());
        }
        System.out.println("=================");

        venta.setUsuario(usuario);

        venta.setDetalles(carrito);

        double total = 0;

        for(DetalleVenta d : carrito){

            total += d.getSubtotal();

        }

        venta.setTotal(total);

        ventaService.registrar(venta);

        session.removeAttribute("carrito");

        session.removeAttribute("idClienteSeleccionado");

        response.sendRedirect(
                request.getContextPath()
                        + "/nueva-venta");

    }

}