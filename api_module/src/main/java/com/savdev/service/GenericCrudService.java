package com.savdev.service;

import java.io.Serializable;
import java.util.List;

/**
 * E jpa entity type, for instance UserEntity
 * PK entity id type, for instance Long
 */
public interface GenericCrudService<E, PK extends Serializable> {
    E create(E e);

    E update(E e);

    void delete(PK id);

    E find(PK id);

    List<E> findByIds(Iterable<PK> ids);
}
