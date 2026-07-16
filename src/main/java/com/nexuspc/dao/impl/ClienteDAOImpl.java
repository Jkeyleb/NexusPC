package com.nexuspc.dao.impl;
import com.nexuspc.config.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.nexuspc.dao.ClienteDAO;
import com.nexuspc.model.Cliente;

import java.util.List;

public class ClienteDAOImpl implements ClienteDAO{

    @Override
    public boolean registrar(Cliente cliente) {

        String sql = """
        INSERT INTO clientes
        (nombre,tipo,telefono,email)
        VALUES (?,?,?,?)
        """;

        try(
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTipo());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());

            return ps.executeUpdate() > 0;

        }catch(Exception e){

            e.printStackTrace();

        }

        return false;

    }

    @Override
    public List<Cliente> listar() {

        List<Cliente> lista = new ArrayList<>();

        String sql = """
SELECT *
FROM clientes
WHERE activo = TRUE
ORDER BY id_cliente DESC
""";

        try(
                Connection conn = DBConnection.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ){

            while(rs.next()){

                Cliente c = new Cliente();

                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setTipo(rs.getString("tipo"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));

                lista.add(c);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return lista;

    }

    @Override
    public Cliente buscarPorId(int id){

        String sql="""
SELECT *
FROM clientes
WHERE id_cliente=?
AND activo=TRUE
""";

        try(
                Connection conn=DBConnection.getConnection();
                PreparedStatement ps=conn.prepareStatement(sql)
        ){

            ps.setInt(1,id);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                Cliente c=new Cliente();

                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setTipo(rs.getString("tipo"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));

                return c;

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return null;

    }

    @Override
    public boolean actualizar(Cliente cliente){

        String sql="""
            UPDATE clientes
            SET nombre=?,
                tipo=?,
                telefono=?,
                email=?
            WHERE id_cliente=?
            """;

        try(
                Connection conn=DBConnection.getConnection();
                PreparedStatement ps=conn.prepareStatement(sql)
        ){

            ps.setString(1,cliente.getNombre());
            ps.setString(2,cliente.getTipo());
            ps.setString(3,cliente.getTelefono());
            ps.setString(4,cliente.getEmail());
            ps.setInt(5,cliente.getIdCliente());

            return ps.executeUpdate()>0;

        }catch(Exception e){

            e.printStackTrace();

        }

        return false;

    }

    @Override
    public boolean eliminar(int id){

        String sql = """
    UPDATE clientes
    SET activo = FALSE
    WHERE id_cliente = ?
    """;

        try(
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){

            ps.setInt(1,id);

            return ps.executeUpdate()>0;

        }catch(Exception e){

            e.printStackTrace();

        }

        return false;

    }

    @Override
    public List<Cliente> buscar(String texto) {

        List<Cliente> lista = new ArrayList<>();

        String sql = """
                SELECT *
                FROM clientes
                WHERE activo=TRUE
                AND (
                    nombre LIKE ?
                    OR email LIKE ?
                )
                ORDER BY id_cliente DESC
            """;

        try(
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){

            String filtro="%"+texto+"%";

            ps.setString(1,filtro);
            ps.setString(2,filtro);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                Cliente c=new Cliente();

                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setTipo(rs.getString("tipo"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));

                lista.add(c);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return lista;

    }

    public int contarClientes() {

        String sql = "SELECT COUNT(*) FROM clientes";

        try (Connection cn = DBConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}