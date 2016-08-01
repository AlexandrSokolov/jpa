package com.savdev.jpa.service;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface CrudService {
    <T> T create(T t);

    <T> T find(Class type, Object id);

    <T> T update(T t);

    void delete(Class type, Object id);

    List findWithNamedQuery(String namedQueryName);

    List findWithNamedQuery(String namedQueryName, int resultLimit);

    List findWithNamedQuery(String namedQueryName, Map<String, Object> parameters);

    List findWithNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit);
}
