package com.nexuspc.dao.impl;

import com.nexuspc.config.DBConnection;
import com.nexuspc.dao.ProductoDAO;
import com.nexuspc.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public boolean guardar(Producto producto) {

        if (producto.getNombre() == null || producto.getNombre().isBlank()
                || producto.getStock() < 0) {

            System.out.println("Producto invalido: nombre vacio o stock negativo.");
            return false;
        }

        String sql = """
                INSERT INTO productos
                (
                    nombre,
                    descripcion,
                    precio,
                    stock,
                    stock_minimo,
                    proveedor
                )
                VALUES
                (?,?,?,?,?,?)
                """;

        try(
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ){

            ps.setString(1,
                    producto.getNombre());

            ps.setString(2,
                    producto.getDescripcion());

            ps.setDouble(3,
                    producto.getPrecio());

            ps.setInt(4,
                    producto.getStock());

            ps.setInt(5,
                    producto.getStockMinimo());

            ps.setString(6,
                    producto.getProveedor());

            return ps.executeUpdate() > 0;

        }catch(Exception ex){

            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Producto> listar() {

        List<Producto> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM productos";

        try(
                Connection conn =
                        DBConnection.getConnection();

                Statement st =
                        conn.createStatement();

                ResultSet rs =
                        st.executeQuery(sql)
        ){

            while(rs.next()){

                Producto p =
                        new Producto();

                p.setIdProducto(
                        rs.getInt("id_producto"));

                p.setNombre(
                        rs.getString("nombre"));

                p.setDescripcion(
                        rs.getString("descripcion"));

                p.setPrecio(
                        rs.getDouble("precio"));

                p.setStock(
                        rs.getInt("stock"));

                p.setStockMinimo(
                        rs.getInt("stock_minimo"));

                p.setProveedor(
                        rs.getString("proveedor"));

                lista.add(p);
            }

        }catch(Exception ex){

            ex.printStackTrace();
        }

        return lista;
    }

    @Override
    public Producto buscarPorId(int id) {

        String sql =
                "SELECT * FROM productos WHERE id_producto=?";

        try(
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ){

            ps.setInt(1,id);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()){

                Producto p =
                        new Producto();

                p.setIdProducto(
                        rs.getInt("id_producto"));

                p.setNombre(
                        rs.getString("nombre"));

                p.setDescripcion(
                        rs.getString("descripcion"));

                p.setPrecio(
                        rs.getDouble("precio"));

                p.setStock(
                        rs.getInt("stock"));

                p.setStockMinimo(
                        rs.getInt("stock_minimo"));

                p.setProveedor(
                        rs.getString("proveedor"));

                return p;
            }

        }catch(Exception ex){

            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean actualizar(
            Producto producto) {

        String sql = """
            UPDATE productos
            SET nombre=?,
                descripcion=?,
                precio=?,
                stock=?,
                stock_minimo=?,
                proveedor=?
            WHERE id_producto=?
            """;

        try(
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ){

            ps.setString(
                    1,
                    producto.getNombre());

            ps.setString(
                    2,
                    producto.getDescripcion());

            ps.setDouble(
                    3,
                    producto.getPrecio());

            ps.setInt(
                    4,
                    producto.getStock());

            ps.setInt(
                    5,
                    producto.getStockMinimo());

            ps.setString(
                    6,
                    producto.getProveedor());

            ps.setInt(
                    7,
                    producto.getIdProducto());

            return ps.executeUpdate() > 0;

        }catch(Exception ex){

            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean eliminar(int id) {

        String sql =
                "DELETE FROM productos WHERE id_producto=?";

        try(
                Connection conn =
                        DBConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ){

            ps.setInt(1,id);

            return ps.executeUpdate() > 0;

        }catch(Exception ex){

            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public int contarProductos() {

        String sql =
                "SELECT COUNT(*) FROM productos";

        try(
                Connection conn =
                        DBConnection.getConnection();

                Statement st =
                        conn.createStatement();

                ResultSet rs =
                        st.executeQuery(sql)
        ){

            if(rs.next()){

                return rs.getInt(1);
            }

        }catch(Exception ex){

            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int contarStockBajo() {

        String sql =
                """
                SELECT COUNT(*)
                FROM productos
                WHERE stock <= stock_minimo
                """;

        try(
                Connection conn =
                        DBConnection.getConnection();

                Statement st =
                        conn.createStatement();

                ResultSet rs =
                        st.executeQuery(sql)
        ){

            if(rs.next()){

                return rs.getInt(1);
            }

        }catch(Exception ex){

            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public double calcularValorInventario() {

        String sql =
                """
                SELECT SUM(precio * stock)
                FROM productos
                """;

        try(
                Connection conn =
                        DBConnection.getConnection();

                Statement st =
                        conn.createStatement();

                ResultSet rs =
                        st.executeQuery(sql)
        ){

            if(rs.next()){

                return rs.getDouble(1);
            }

        }catch(Exception ex){

            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Producto> buscar(String texto) {

        List<Producto> lista = new ArrayList<>();

        String sql = """
        SELECT *
        FROM productos
        WHERE nombre LIKE ?
           OR proveedor LIKE ?
        ORDER BY nombre
        """;

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            String filtro = "%" + texto + "%";

            ps.setString(1, filtro);
            ps.setString(2, filtro);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Producto p = new Producto();

                p.setIdProducto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setStockMinimo(rs.getInt("stock_minimo"));
                p.setProveedor(rs.getString("proveedor"));

                lista.add(p);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    @Override
    public List<Producto> ultimosProductos() {

        List<Producto> lista = new ArrayList<>();

        String sql = """
            SELECT *
            FROM productos
            ORDER BY id_producto DESC
            LIMIT 5
            """;

        try (
                Connection conn = DBConnection.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {

            while (rs.next()) {

                Producto p = new Producto();

                p.setIdProducto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setStockMinimo(rs.getInt("stock_minimo"));
                p.setProveedor(rs.getString("proveedor"));

                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public List<Producto> listarStockBajo() {

        List<Producto> lista = new ArrayList<>();

        String sql = """
            SELECT *
            FROM productos
            WHERE stock <= stock_minimo
            ORDER BY stock ASC
            """;

        try (
                Connection cn = DBConnection.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Producto p = new Producto();

                p.setIdProducto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setStockMinimo(rs.getInt("stock_minimo"));
                p.setProveedor(rs.getString("proveedor"));

                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

}