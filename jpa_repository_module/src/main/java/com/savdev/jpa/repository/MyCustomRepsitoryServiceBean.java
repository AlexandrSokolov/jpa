package com.savdev.jpa.repository;

import javax.inject.Inject;

import com.savdev.api.User;
import com.savdev.jpa.entity.UserEntity;
import com.savdev.service.CrudService;

/**
 *
 */
public class MyCustomRepsitoryServiceBean implements MyCustomRepositoryService {

    @Inject
    CrudService crudService;


    @Override
    public User create(User user) {
        return crudService.create(user);
    }

    @Override
    public void delete(long id) {
        crudService.delete(UserEntity.class, id);
    }
}
