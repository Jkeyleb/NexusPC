package com.nexuspc.service;
import com.nexuspc.util.BCryptUtil;
import com.nexuspc.dao.UserDAO;
import com.nexuspc.dao.impl.UserDAOImpl;
import com.nexuspc.model.User;

public class AuthService {

    private final UserDAO userDAO =
            new UserDAOImpl();

    public boolean register(User user) {

        return userDAO.register(user);
    }

    public User findByUsername(String username) {

        return userDAO.findByUsername(username);
    }

    public User login(String username,
                      String password) {

        User user =
                userDAO.findByUsername(username);

        if (user == null) {
            return null;
        }

        boolean valid =
                BCryptUtil.verifyPassword(
                        password,
                        user.getPassword()
                );

        if (!valid) {
            return null;
        }

        return user;
    }
}
