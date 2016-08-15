package com.savdev.jpa.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.savdev.service.CrudService;

/**
 *
 */
public class CrudServiceBean implements CrudService {

    @PersistenceContext(unitName = "usersPersistenceUnit")
    EntityManager em;

    @Override
    public <T> T create(T t) {
        this.em.persist(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }

    @Override
    public <T> T find(Class type, Object id) {
        return (T) this.em.find(type, id);
    }

    @Override
    public <T> T update(T t) {
        return (T)this.em.merge(t);
    }

    @Override
    public void delete(Class type, Object id) {
        Object ref = this.em.getReference(type, id);
        this.em.remove(ref);
    }

    @Override
    public List findWithNamedQuery(String namedQueryName) {
        return this.em.createNamedQuery(namedQueryName).getResultList();
    }

    @Override
    public List findWithNamedQuery(String namedQueryName, int resultLimit) {
        return this.em.createNamedQuery(namedQueryName).
                setMaxResults(resultLimit).
                getResultList();
    }

    @Override
    public List findWithNamedQuery(String namedQueryName, Map<String, Object> parameters) {
        return findWithNamedQuery(namedQueryName, parameters, 0);
    }

    @Override
    public List findWithNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit) {
        Query query = this.em.createNamedQuery(namedQueryName);
        if(resultLimit > 0)
            query.setMaxResults(resultLimit);
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }
}
