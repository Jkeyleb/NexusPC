package com.nexuspc.service;

import com.nexuspc.dao.ClienteDAO;
import com.nexuspc.dao.impl.ClienteDAOImpl;
import com.nexuspc.model.Cliente;

import java.util.List;

public class ClienteService {

    private final ClienteDAO dao =
            new ClienteDAOImpl();

    public boolean registrar(Cliente cliente){

        return dao.registrar(cliente);

    }

    public List<Cliente> listar(){

        return dao.listar();

    }

    public Cliente buscarPorId(int id){
        return dao.buscarPorId(id);
    }

    public boolean actualizar(Cliente cliente){
        return dao.actualizar(cliente);
    }

    public boolean eliminar(int id){
        return dao.eliminar(id);
    }

    public List<Cliente> buscar(String texto){
        return dao.buscar(texto);
    }

}