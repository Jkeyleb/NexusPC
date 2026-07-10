package com.nexuspc.dao;

import com.nexuspc.model.Producto;
import java.util.List;

public interface ProductoDAO {

    boolean guardar(Producto producto);

    List<Producto> listar();

    Producto buscarPorId(int id);

    boolean actualizar(Producto producto);

    boolean eliminar(int id);

    int contarProductos();

    int contarStockBajo();

    double calcularValorInventario();
}