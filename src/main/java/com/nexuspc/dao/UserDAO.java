package com.nexuspc.dao;

import com.nexuspc.model.User;
import java.util.List;

public interface UserDAO {

    boolean register(User user);

    User findByUsername(String username);

    List<User> listar();

    User buscarPorId(int id);

    boolean actualizar(User user);

    boolean eliminar(int id);

    int contarUsuarios();
}