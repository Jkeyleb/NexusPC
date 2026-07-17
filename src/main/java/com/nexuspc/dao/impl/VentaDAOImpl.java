package com.nexuspc.dao.impl;
import java.time.LocalDate;
import com.nexuspc.config.DBConnection;
import com.nexuspc.dao.VentaDAO;
import com.nexuspc.model.Cliente;
import com.nexuspc.model.DetalleVenta;
import com.nexuspc.model.User;
import com.nexuspc.model.Venta;
import com.nexuspc.model.Producto;
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

        List<Venta> lista = new ArrayList<>();

        String sql = """
    SELECT
        v.id_venta,
        v.fecha,
        c.nombre AS cliente,
        u.nombre AS vendedor,
        v.total
    FROM ventas v
    INNER JOIN clientes c
        ON v.id_cliente = c.id_cliente
    INNER JOIN usuarios u
        ON v.id_usuario = u.id_usuario
    ORDER BY v.fecha DESC
    """;

        try(
                Connection cn = DBConnection.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ){

            while(rs.next()){

                Venta venta = new Venta();

                venta.setIdVenta(
                        rs.getInt("id_venta"));

                venta.setFecha(
                        rs.getTimestamp("fecha")
                                .toLocalDateTime());

                venta.setTotal(
                        rs.getDouble("total"));

                // Cliente
                com.nexuspc.model.Cliente cliente =
                        new com.nexuspc.model.Cliente();

                cliente.setNombre(
                        rs.getString("cliente"));

                venta.setCliente(cliente);

                // Usuario
                com.nexuspc.model.User usuario =
                        new com.nexuspc.model.User();

                usuario.setNombre(
                        rs.getString("vendedor"));

                venta.setUsuario(usuario);

                lista.add(venta);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return lista;

    }

    @Override
    public Venta buscarPorId(int id) {

        Venta venta = null;

        try (
                Connection cn = DBConnection.getConnection()
        ) {

            String sql = """
        SELECT v.id_venta,
               v.fecha,
               v.total,

               c.id_cliente,
               c.nombre AS cliente,

               u.id_usuario,
               u.nombre AS vendedor

        FROM ventas v
        INNER JOIN clientes c
            ON v.id_cliente = c.id_cliente

        INNER JOIN usuarios u
            ON v.id_usuario = u.id_usuario

        WHERE v.id_venta = ?
        """;

            PreparedStatement ps =
                    cn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                venta = new Venta();

                venta.setIdVenta(
                        rs.getInt("id_venta"));

                venta.setFecha(
                        rs.getTimestamp("fecha")
                                .toLocalDateTime());

                venta.setTotal(
                        rs.getDouble("total"));

                Cliente cliente = new Cliente();

                cliente.setIdCliente(
                        rs.getInt("id_cliente"));

                cliente.setNombre(
                        rs.getString("cliente"));

                venta.setCliente(cliente);

                User usuario = new User();

                usuario.setIdUsuario(
                        rs.getInt("id_usuario"));

                usuario.setNombre(
                        rs.getString("vendedor"));

                venta.setUsuario(usuario);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return venta;

    }

    @Override
    public List<DetalleVenta> listarDetalles(int idVenta) {

        List<DetalleVenta> lista = new ArrayList<>();

        String sql = """
    SELECT
        p.nombre,
        d.cantidad,
        d.precio_unitario,
        d.subtotal
    FROM detalle_venta d
    INNER JOIN productos p
        ON d.id_producto = p.id_producto
    WHERE d.id_venta = ?
    """;

        try(
                Connection cn = DBConnection.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)
        ){

            ps.setInt(1, idVenta);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Producto producto = new Producto();

                producto.setNombre(
                        rs.getString("nombre"));

                DetalleVenta detalle =
                        new DetalleVenta();

                detalle.setProducto(producto);

                detalle.setCantidad(
                        rs.getInt("cantidad"));

                detalle.setPrecioUnitario(
                        rs.getDouble("precio_unitario"));

                detalle.setSubtotal(
                        rs.getDouble("subtotal"));

                lista.add(detalle);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return lista;

    }

    @Override
    public List<Venta> buscarPorFecha(LocalDate fecha) {

        List<Venta> lista = new ArrayList<>();

        String sql = """
    SELECT
        v.id_venta,
        v.fecha,
        c.nombre AS cliente,
        u.nombre AS vendedor,
        v.total
    FROM ventas v
    INNER JOIN clientes c
        ON v.id_cliente = c.id_cliente
    INNER JOIN usuarios u
        ON v.id_usuario = u.id_usuario
    WHERE DATE(v.fecha) = ?
    ORDER BY v.fecha DESC
    """;

        try(
                Connection cn = DBConnection.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)
        ){

            ps.setDate(1, java.sql.Date.valueOf(fecha));

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Venta venta = new Venta();

                venta.setIdVenta(rs.getInt("id_venta"));

                venta.setFecha(
                        rs.getTimestamp("fecha")
                                .toLocalDateTime());

                venta.setTotal(rs.getDouble("total"));

                Cliente cliente = new Cliente();
                cliente.setNombre(rs.getString("cliente"));
                venta.setCliente(cliente);

                User usuario = new User();
                usuario.setNombre(rs.getString("vendedor"));
                venta.setUsuario(usuario);

                lista.add(venta);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return lista;

    }

    @Override
    public List<Venta> listarPorFechas(
            String desde,
            String hasta) {

        List<Venta> lista = new ArrayList<>();

        String sql = """
        SELECT
            v.id_venta,
            v.fecha,
            v.total,
            c.nombre AS cliente,
            u.nombre AS vendedor
        FROM ventas v
        INNER JOIN clientes c
            ON v.id_cliente = c.id_cliente
        INNER JOIN usuarios u
            ON v.id_usuario = u.id_usuario
        WHERE DATE(v.fecha)
              BETWEEN ? AND ?
        ORDER BY v.fecha
        """;

        try(
                Connection cn = DBConnection.getConnection();
                PreparedStatement ps =
                        cn.prepareStatement(sql)
        ){

            ps.setString(1, desde);
            ps.setString(2, hasta);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Venta venta = new Venta();

                venta.setIdVenta(
                        rs.getInt("id_venta"));

                venta.setFecha(
                        rs.getTimestamp("fecha")
                                .toLocalDateTime());

                venta.setTotal(
                        rs.getDouble("total"));

                Cliente cliente = new Cliente();
                cliente.setNombre(
                        rs.getString("cliente"));

                venta.setCliente(cliente);

                User usuario = new User();
                usuario.setNombre(
                        rs.getString("vendedor"));

                venta.setUsuario(usuario);

                lista.add(venta);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return lista;

    }

}