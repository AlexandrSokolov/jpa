package com.savdev.jpa.repository;

import java.util.List;

import com.savdev.jpa.entity.UserEntity;
import com.savdev.service.GenericCrudService;

/**
 *
 */
public interface UserRepositoryService extends GenericCrudService<UserEntity, Long> {
    List<UserEntity> findByName(String name);
}
