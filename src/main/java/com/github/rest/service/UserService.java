package com.github.rest.service;

import com.github.rest.pojo.User;

import java.util.List;

/**
 * Created By jiabin on 18-5-14.
 */
public interface UserService {
    boolean login(String uname, String passwd);

    User addUser(User user);

    User getUser(int id);

    List<User> getUserPageList();
}
