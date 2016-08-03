package com.savdev.jpa.repository;

import com.savdev.api.User;

/**
 *
 */
public interface MyCustomRepositoryService {
    User create(User user);
    void delete(long id);
}
