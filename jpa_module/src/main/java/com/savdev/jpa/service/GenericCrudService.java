package com.savdev.jpa.service;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 */
public interface GenericCrudService<ER, EW extends ER, PK extends Serializable> {
    ER create(ER e);

//    TODO
//    ER update(TransactionalUpdater<ER, EW> transactionalUpdater);

    void delete(PK id);

    ER find(PK id);

    List<? extends ER> findByIds(Iterable<PK> ids);
}
