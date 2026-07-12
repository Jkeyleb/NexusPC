package com.nexuspc.service;

import com.nexuspc.dao.ProductoDAO;
import com.nexuspc.dao.impl.ProductoDAOImpl;
import com.nexuspc.model.Producto;

import java.util.List;

public class ProductoService {

    private final ProductoDAO dao =
            new ProductoDAOImpl();

    public boolean guardar(
            Producto producto){

        return dao.guardar(producto);
    }

    public List<Producto> listar(){

        return dao.listar();
    }

    public Producto buscarPorId(int id){

        return dao.buscarPorId(id);
    }

    public boolean actualizar(
            Producto producto){

        return dao.actualizar(producto);
    }

    public boolean eliminar(int id){

        return dao.eliminar(id);
    }

    public int contarProductos(){

        return dao.contarProductos();
    }

    public int contarStockBajo(){

        return dao.contarStockBajo();
    }

    public double calcularValorInventario(){

        return dao.calcularValorInventario();
    }

    public List<Producto> buscar(String texto){

        return dao.buscar(texto);

    }

    public List<Producto> ultimosProductos(){

        return dao.ultimosProductos();

    }
}