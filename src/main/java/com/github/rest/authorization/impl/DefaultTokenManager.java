package com.github.rest.authorization.impl;

import com.github.rest.authorization.TokenManager;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jiabin on 2018/5/13.
 */
@Component("tokenManager")
public class DefaultTokenManager implements TokenManager {
    private static Map<String, String> tokenMap = new ConcurrentHashMap<>();


    @Override
    public String createToken(String username) {
        String token = UUID.randomUUID().toString();
        tokenMap.put(token, username);
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        return  isNotEmpty(token) && tokenMap.containsKey(token);
    }

    @Override
    public void deleteToken(String token) {
        tokenMap.remove(token);
    }

    private boolean isNotEmpty(String str) {
        if (str != null && str.length() != 0) {
            return true;
        }
        return false;
    }
}
