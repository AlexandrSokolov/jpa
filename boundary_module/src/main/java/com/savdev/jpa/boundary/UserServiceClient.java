package com.savdev.jpa.boundary;

import javax.inject.Inject;

import com.savdev.api.User;
import com.savdev.jpa.component.UserService;

/**
 *
 */
public class UserServiceClient {

    @Inject
    UserService userService;

    public User create(UserDao user){
        return userService.create(user);
    }
}
