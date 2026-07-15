package com.nexuspc.dao;

import com.nexuspc.model.Venta;

import java.util.List;

public interface VentaDAO {

    boolean registrar(Venta venta);

    List<Venta> listar();

    Venta buscarPorId(int id);

}