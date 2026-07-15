package com.nexuspc.dao.impl;

import com.nexuspc.config.DBConnection;
import com.nexuspc.dao.UserDAO;
import com.nexuspc.model.Role;
import com.nexuspc.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean register(User user) {

        String sql =
                "INSERT INTO usuarios(nombre,usuario,password,id_rol) VALUES(?,?,?,?)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, user.getNombre());
            ps.setString(2, user.getUsuario());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getRole().getIdRol());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public User findByUsername(String username) {

        String sql = """
                SELECT u.*, r.nombre rol
                FROM usuarios u
                INNER JOIN roles r
                ON u.id_rol = r.id_rol
                WHERE usuario = ?
                """;

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Role role = new Role();
                role.setIdRol(rs.getInt("id_rol"));
                role.setNombre(rs.getString("rol"));

                User user = new User();
                user.setIdUsuario(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));
                user.setRole(role);

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> listar() {

        List<User> lista = new ArrayList<>();

        String sql = """
            SELECT u.id_usuario,
                   u.nombre,
                   u.usuario,
                   r.id_rol,
                   r.nombre AS rol
            FROM usuarios u
            INNER JOIN roles r
            ON u.id_rol = r.id_rol
            ORDER BY u.id_usuario
            """;

        try(Connection cn = DBConnection.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){

                User u = new User();

                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setUsuario(rs.getString("usuario"));

                Role role = new Role();
                role.setIdRol(rs.getInt("id_rol"));
                role.setNombre(rs.getString("rol"));

                u.setRole(role);

                lista.add(u);

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public User buscarPorId(int id){
        return null;
    }

    @Override
    public boolean actualizar(User user){
        return false;
    }

    @Override
    public boolean eliminar(int id){
        return false;
    }

    @Override
    public int contarUsuarios(){

        String sql="SELECT COUNT(*) FROM usuarios";

        try(Connection cn=DBConnection.getConnection();
            PreparedStatement ps=cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){

            if(rs.next()){
                return rs.getInt(1);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return 0;
    }
}