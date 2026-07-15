package com.nexuspc.dao.impl;

import com.nexuspc.dao.VentaDAO;
import com.nexuspc.model.Venta;
import com.nexuspc.config.DBConnection;
import com.nexuspc.model.DetalleVenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOImpl implements VentaDAO {

    @Override
    public boolean registrar(Venta venta) {

        Connection cn = null;

        try{

            cn = DBConnection.getConnection();

            cn.setAutoCommit(false);

            String sqlVenta = """
        INSERT INTO ventas
        (fecha,id_cliente,id_usuario,total)
        VALUES(?,?,?,?)
        """;

            PreparedStatement psVenta =
                    cn.prepareStatement(
                            sqlVenta,
                            Statement.RETURN_GENERATED_KEYS);

            psVenta.setTimestamp(
                    1,
                    Timestamp.valueOf(
                            venta.getFecha()));

            psVenta.setInt(
                    2,
                    venta.getCliente().getIdCliente());

            psVenta.setInt(
                    3,
                    venta.getUsuario().getIdUsuario());

            psVenta.setDouble(
                    4,
                    venta.getTotal());

            psVenta.executeUpdate();

            ResultSet rs =
                    psVenta.getGeneratedKeys();

            int idVenta = 0;

            if(rs.next()){

                idVenta = rs.getInt(1);

            }

            String sqlDetalle = """
INSERT INTO detalle_venta
(id_venta,id_producto,cantidad,precio_unitario,subtotal)
VALUES(?,?,?,?,?)
""";

            String sqlStock = """
UPDATE productos
SET stock = stock - ?
WHERE id_producto = ?
""";

            PreparedStatement psStock =
                    cn.prepareStatement(sqlStock);

            PreparedStatement psDetalle =
                    cn.prepareStatement(sqlDetalle);

            for (DetalleVenta d : venta.getDetalles()) {

                psDetalle.setInt(1, idVenta);
                psDetalle.setInt(2, d.getProducto().getIdProducto());
                psDetalle.setInt(3, d.getCantidad());
                psDetalle.setDouble(4, d.getPrecioUnitario());
                psDetalle.setDouble(5, d.getSubtotal());

                psDetalle.executeUpdate();

                // ========= DESCONTAR STOCK =========

                psStock.setInt(1, d.getCantidad());

                psStock.setInt(2,
                        d.getProducto().getIdProducto());

                psStock.executeUpdate();
            }

            cn.commit();

            return true;

        }catch(Exception e){

            try{

                if(cn!=null){

                    cn.rollback();

                }

            }catch(Exception ex){

                ex.printStackTrace();

            }

            e.printStackTrace();

        }finally{

            try{

                if(cn!=null){

                    cn.setAutoCommit(true);

                    cn.close();

                }

            }catch(Exception e){

                e.printStackTrace();

            }

        }

        return false;

    }

    @Override
    public List<Venta> listar() {

        return new ArrayList<>();

    }

    @Override
    public Venta buscarPorId(int id) {

        return null;

    }

}