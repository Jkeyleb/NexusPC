package com.nexuspc.dao;

import com.nexuspc.model.User;

public interface UserDAO {

    boolean register(User user);

    User findByUsername(String username);
}