package com.savdev.jpa.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.savdev.api.User;
import com.savdev.service.CrudService;
import com.savdev.service.GenericCrudService;

/**
 * ER - reable interface of an entity, for instance User
 * EW - writable interface of an entity, for instance UserMutable
 */
public class GenericCrudServiceBean<E, PK extends Serializable> implements GenericCrudService<E, PK> {

    @Inject
    CrudService crudService;

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
        return crudService.find(User.class, id);
    }

    @Override
    public List<E> findByIds(Iterable<PK> ids) {
        List<E> items = new ArrayList<>();
        ids.forEach(id -> items.add(find(id)));
        return null;
    }
}
