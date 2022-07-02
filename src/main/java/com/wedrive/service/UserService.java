package com.wedrive.service;

import com.wedrive.model.User;

import java.util.List;

public interface UserService {
    Boolean checkEmail(User user);
    List<User> findAllUser();
    void saveUser(User user);
}
