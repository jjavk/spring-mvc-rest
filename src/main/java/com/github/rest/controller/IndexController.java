package com.github.rest.controller;

import com.github.rest.annotation.IgnoreSecurity;
import com.github.rest.authorization.TokenManager;
import com.github.rest.response.PageInfo;
import com.github.rest.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by jiabin on 2018/5/13.
 */
@RestController
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TokenManager tokenManager;


    @IgnoreSecurity
    @GetMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        /*验证用户名密码*/
        return tokenManager.createToken(username);
    }

    @IgnoreSecurity
    @GetMapping("/response")
    public Response responseReturn() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "bob");
        map.put("old", "12");
        return Response.success(map);
    }

    @IgnoreSecurity
    @GetMapping("/page")
    public Response page() {
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));
        PageInfo pageInfo = new PageInfo(12L, 1, 4);
        return Response.success(list, pageInfo);
    }
}
