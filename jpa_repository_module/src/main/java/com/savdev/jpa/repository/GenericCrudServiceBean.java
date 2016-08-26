package com.savdev.jpa.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.savdev.service.CrudService;
import com.savdev.service.GenericCrudService;

/**
 * E jpa entity, for instance UserEntity
 */
public class GenericCrudServiceBean<E, PK extends Serializable> implements GenericCrudService<E, PK> {

    final Class<E> entityType;

    @Inject
    CrudService crudService;

    public GenericCrudServiceBean(Class<E> entityType) {
        this.entityType = entityType;
    }

    @Override
    public E create(E e) {
        return crudService.create(e);
    }

    @Override
    public E update(E e) {
        return crudService.update(e);
    }

    @Override
    public void delete(PK id) {
        crudService.update(id);
    }

    @Override
    public E find(PK id) {
        return crudService.find(entityType, id);
    }

    @Override
    public List<E> findByIds(Iterable<PK> ids) {
        List<E> items = new ArrayList<>();
        ids.forEach(id -> items.add(find(id)));
        return null;
    }
}
