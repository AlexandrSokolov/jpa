package com.savdev.jpa.repository;

import java.util.List;

import com.google.common.collect.ImmutableMap;
import com.savdev.jpa.entity.UserEntity;

/**
 *
 */
public class UserRepositoryServiceBean extends GenericCrudServiceBean<UserEntity, Long> implements UserRepositoryService {

    //do not create crud service here, otherwise you hide it in parent:
    //@Inject
    //CrudService crudService;

    @Override
    public List<UserEntity> findByName(String name) {
        return crudService.findWithNamedQuery(UserEntity.FIND_BY_NAME, ImmutableMap.of("name", name));
    }
}
