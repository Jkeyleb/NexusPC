package com.nexuspc.service;

import com.nexuspc.dao.ClienteDAO;
import com.nexuspc.dao.impl.ClienteDAOImpl;

public class ClienteService {

    private final ClienteDAO dao =
            new ClienteDAOImpl();

}