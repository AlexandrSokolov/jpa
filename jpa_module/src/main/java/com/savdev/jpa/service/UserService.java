package com.savdev.jpa.service;

import com.savdev.api.User;

import java.util.List;

/**
 *
 */
public interface UserService {
    User create(User user);

    User find(Long id);

    //TODO
//    User update(User user);

    void delete(Long id);

    List<User> findByName(String name);
}
