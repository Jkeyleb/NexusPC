package com.nexuspc.dao;

import com.nexuspc.model.Producto;
import java.util.List;

public interface ProductoDAO {

    boolean guardar(Producto producto);

    List<Producto> listar();

    List<Producto> buscar(String texto);

    List<Producto> ultimosProductos();

    Producto buscarPorId(int id);

    boolean actualizar(Producto producto);

    boolean eliminar(int id);

    int contarProductos();

    int contarStockBajo();

    double calcularValorInventario();

    List<Producto> listarStockBajo();
}