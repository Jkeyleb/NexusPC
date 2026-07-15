package com.nexuspc.service;

import com.nexuspc.dao.UserDAO;
import com.nexuspc.dao.impl.UserDAOImpl;
import com.nexuspc.model.User;

import java.util.List;

public class UserService {

    private final UserDAO dao = new UserDAOImpl();

    public List<User> listar() {
        return dao.listar();
    }

    public User buscarPorId(int id){
        return dao.buscarPorId(id);
    }

    public boolean actualizar(User user){
        return dao.actualizar(user);
    }

    public boolean eliminar(int id){
        return dao.eliminar(id);
    }

    public int contarUsuarios() {
        return dao.contarUsuarios();
    }

    public boolean registrar(User user) {
        return dao.register(user);
    }
}