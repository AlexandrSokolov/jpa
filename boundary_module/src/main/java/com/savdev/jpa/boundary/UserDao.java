package com.savdev.jpa.boundary;

import com.savdev.api.User;

/**
 *
 */
public class UserDao implements User {

    String name;

    @Override
    public String getName() {
        return name;
    }
}
