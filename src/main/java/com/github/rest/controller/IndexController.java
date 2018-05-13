package com.github.rest.controller;

import com.github.rest.annotation.IgnoreSecurity;
import com.github.rest.authorization.TokenManager;
import com.github.rest.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiabin on 2018/5/13.
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TokenManager tokenManager;


    @RequestMapping(name = "/login", method = RequestMethod.GET, produces = "application/json")
    @IgnoreSecurity
    public String index(@RequestParam("username")String username, @RequestParam("password") String password) {
        /*验证用户名密码*/
        return tokenManager.createToken(username);
    }

    @RequestMapping(name = "/response", method = RequestMethod.GET, produces = "application/json")
    public Response responseReturn() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "bob");
        map.put("old", "12");
        return new Response().success(map);
    }

}
