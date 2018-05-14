package com.github.rest.service.impl;

import com.github.rest.pojo.User;
import com.github.rest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created By jiabin on 18-5-14.
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public boolean login(String uname, String passwd) {
        return true;
    }

    @Override
    public User addUser(User user) {
        return new User();
    }

    @Override
    public User getUser(int id) {
        return new User();
    }

    @Override
    public List<User> getUserPageList() {
        return Arrays.asList(new User(), new User());
    }
}
