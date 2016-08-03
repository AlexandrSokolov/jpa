package com.savdev.jpa.component;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections4.Transformer;

import com.savdev.api.User;
import com.savdev.jpa.entity.UserEntity;
import com.savdev.jpa.repository.UserRepositoryService;
import com.savdev.service.GenericCrudService;

/**
 * Created by alexandr on 01.08.16.
 */
public class UserService implements GenericCrudService<User, Long> {

    private final Transformer<User, UserEntity> user2EntityTransformer = new Transformer<User, UserEntity>()
    {
        @Override
        public UserEntity transform(User input) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName(input.getName());
            return userEntity;
        }
    };

    private final Transformer<UserEntity, User> userEntity2UserTransformer = new Transformer<UserEntity, User>()
    {
        @Override
        public User transform(UserEntity input) {
            return input;
        }
    };

    @Inject
    UserRepositoryService userRepositoryService;

    /*
        Converts not jpa-managed business object object to entity
     */
    @Override
    public User create(User user) {
        return userRepositoryService.create(user2EntityTransformer.transform(user));
    }

    @Override
    public User update(User user) {
        return userRepositoryService.update(user2EntityTransformer.transform(user));
    }

    @Override
    public void delete(Long id) {
        userRepositoryService.delete(id);
    }

    @Override
    public User find(Long id) {
        return userRepositoryService.find(id);
    }

    @Override
    public List<User> findByIds(Iterable<Long> ids) {
        List<User> users = new ArrayList<>();
        for (UserEntity entity : userRepositoryService.findByIds(ids))
        {
            users.add(entity);
        }
        return users;
    }
}
