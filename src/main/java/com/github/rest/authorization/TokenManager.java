package com.github.rest.authorization;

/**
 * Created by jiabin on 2018/5/13.
 */
public interface TokenManager {
    String createToken(String username);

    boolean checkToken(String token);

    void deleteToken(String token);
}
