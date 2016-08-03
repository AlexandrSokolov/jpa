package com.savdev.jpa.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.savdev.jpa.entity.UserEntity;

/**
 *
 */
public class UserRepositoryServiceBeanTest extends RepositoryServiceTestBase {

    public static final String USER_NAME = "Test Name";

    UserRepositoryServiceBean userRepositoryServiceBean;

    @Before
    public void instantiate() {
        this.userRepositoryServiceBean = new UserRepositoryServiceBean();
        this.userRepositoryServiceBean.crudService = crudServiceInstance();
    }

    @Test
    public void createUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(USER_NAME);
        Assert.assertEquals(0, userEntity.getId());
        UserEntity createdUserEntity = userRepositoryServiceBean.create(userEntity);
        Assert.assertTrue(createdUserEntity.getId() > 0);
        Assert.assertEquals(userEntity.getName(), createdUserEntity.getName());
    }
}
