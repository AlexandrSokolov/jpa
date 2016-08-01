package com.savdev.jpa.service;

import com.google.common.collect.ImmutableMap;
import com.savdev.api.User;
import com.savdev.api.UserMutable;
import com.savdev.jpa.entity.UserEntity;

import javax.inject.Inject;
import java.util.List;

/**
 *
 */
public class UserServiceBean extends GenericCrudServiceBean<User, UserMutable, Long> implements UserService {

    @Inject
    CrudService crudService;

    @Override
    public List<User> findByName(String name) {
        return crudService.findWithNamedQuery(UserEntity.FIND_BY_NAME, ImmutableMap.of("name", name));
    }
}
