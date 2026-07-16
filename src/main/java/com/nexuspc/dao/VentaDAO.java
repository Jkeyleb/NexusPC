package com.nexuspc.dao;

import com.nexuspc.model.Venta;
import com.nexuspc.model.DetalleVenta;
import java.util.List;

public interface VentaDAO {

    boolean registrar(Venta venta);

    List<Venta> listar();

    Venta buscarPorId(int id);

    List<DetalleVenta> listarDetalles(int idVenta);

    List<Venta> buscarPorFecha(java.time.LocalDate fecha);

}