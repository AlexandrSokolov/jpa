package com.savdev.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

import com.savdev.service.CrudService;

/**
 *
 */
public class RepositoryServiceTestBase {

    EntityManager entityManager;
    CrudServiceBean crudService;

    public CrudService crudServiceInstance(){
        return crudService;
    }

    @Before
    public void initEntityManagerAndStartTransaction(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("usersPersistenceUnit");
        this.crudService = new CrudServiceBean();
        this.entityManager = emf.createEntityManager();
        crudService.em = entityManager;
        this.entityManager.getTransaction().begin();
    }

    @After
    public void stopTransaction(){
        this.entityManager.getTransaction().commit();
    }
}
