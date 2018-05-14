package com.github.rest.controller;

import com.github.rest.pojo.User;
import com.github.rest.response.PageInfo;
import com.github.rest.response.Response;
import com.github.rest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created By jiabin on 18-5-14.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping
    public Response getUser() {
        List<User> userList = userService.getUserPageList();
        logger.debug("查询用户 :" + userList);
        return Response.success(userList, new PageInfo(12L, 3, 4));
    }

    @GetMapping("/{id}")
    public Response getUser(@PathVariable("id") int id) {
        User user = (User) userService.getUser(id);
        logger.debug("查询用户 :" + user);
        return Response.success(user);
    }

    @PutMapping
    public Response addUser(@RequestBody @Valid User user) {
        user = userService.addUser(user);
        logger.debug("添加用户 :" + user);
        return Response.success(user);
    }
}
