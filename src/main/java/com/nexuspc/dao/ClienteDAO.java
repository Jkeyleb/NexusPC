package com.nexuspc.dao;

import com.nexuspc.model.Cliente;
import java.util.List;

public interface ClienteDAO {

    boolean registrar(Cliente cliente);

    List<Cliente> listar();

    Cliente buscarPorId(int id);

    boolean actualizar(Cliente cliente);

    boolean eliminar(int id);

    List<Cliente> buscar(String texto);

}