package com.nexuspc.dao.impl;

import com.nexuspc.dao.ClienteDAO;
import com.nexuspc.model.Cliente;

import java.util.List;

public class ClienteDAOImpl implements ClienteDAO{

    @Override
    public boolean registrar(Cliente cliente) {
        return false;
    }

    @Override
    public List<Cliente> listar() {
        return null;
    }

    @Override
    public Cliente buscarPorId(int id) {
        return null;
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    @Override
    public List<Cliente> buscar(String texto) {
        return null;
    }
}