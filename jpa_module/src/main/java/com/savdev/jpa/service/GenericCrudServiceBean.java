package com.savdev.jpa.service;

import com.savdev.api.User;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ER - reable interface of an entity, for instance User
 * EW - writable interface of an entity, for instance UserMutable
 */
public class GenericCrudServiceBean<ER, EW extends ER, PK extends Serializable> implements GenericCrudService<ER, EW, PK> {

    @Inject
    CrudService crudService;

    @Override
    public ER create(ER e) {
        return crudService.create(e);
    }

    @Override
    public void delete(PK id) {
        crudService.update(id);
    }

    @Override
    public ER find(PK id) {
        return crudService.find(User.class, id);
    }

    @Override
    public List<? extends ER> findByIds(Iterable<PK> ids) {
        List<ER> items = new ArrayList<>();
        ids.forEach(id -> items.add(find(id)));
        return null;
    }
}
