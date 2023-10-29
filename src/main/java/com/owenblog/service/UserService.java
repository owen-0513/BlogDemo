package com.owenblog.service;

import com.owenblog.entity.User;

/**
 * Created by owen on 2023/10/28.
 */
public interface UserService {

    User checkUser(String username, String password);
}
