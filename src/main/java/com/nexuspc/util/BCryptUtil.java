package com.nexuspc.util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {

    public static String hashPassword(
            String password) {

        return BCrypt.hashpw(
                password,
                BCrypt.gensalt()
        );
    }

    public static boolean verifyPassword(
            String password,
            String hash) {

        return BCrypt.checkpw(
                password,
                hash
        );
    }
}