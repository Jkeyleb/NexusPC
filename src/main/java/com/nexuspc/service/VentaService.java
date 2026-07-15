package com.nexuspc.service;

import com.nexuspc.dao.VentaDAO;
import com.nexuspc.dao.impl.VentaDAOImpl;
import com.nexuspc.model.Venta;

import java.util.List;

public class VentaService {

    private final VentaDAO dao =
            new VentaDAOImpl();

    public boolean registrar(Venta venta){

        return dao.registrar(venta);

    }

    public List<Venta> listar(){

        return dao.listar();

    }

    public Venta buscarPorId(int id){

        return dao.buscarPorId(id);

    }

}