package com.nexuspc.dao.impl;

import com.nexuspc.config.DBConnection;
import com.nexuspc.dao.UserDAO;
import com.nexuspc.model.Role;
import com.nexuspc.model.User;

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
}