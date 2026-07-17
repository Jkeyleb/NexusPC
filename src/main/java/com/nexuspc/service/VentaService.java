package com.nexuspc.service;
import java.time.LocalDate;
import com.nexuspc.dao.VentaDAO;
import com.nexuspc.dao.impl.VentaDAOImpl;
import com.nexuspc.model.Venta;
import com.nexuspc.model.DetalleVenta;
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

    public List<DetalleVenta> listarDetalles(int idVenta){

        return dao.listarDetalles(idVenta);

    }

    public List<Venta> buscarPorFecha(LocalDate fecha){

        return dao.buscarPorFecha(fecha);

    }

    public List<Venta> listarPorFechas(
            String desde,
            String hasta){

        return dao.listarPorFechas(
                desde,
                hasta);

    }


}