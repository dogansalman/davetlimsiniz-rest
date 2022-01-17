package com.rest.davetlimsiniz.service;

import com.rest.davetlimsiniz.dao.GenericDAO;
import com.rest.davetlimsiniz.entity.GenericEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackFor = Throwable.class)
public abstract class AbstractService<E extends GenericEntity> implements GenericService<E> {

    @Autowired protected GenericDAO<E> dao;

    @PersistenceContext
    protected EntityManager em;

    @Override
    public E newEntity() throws Exception {
        E entity = getSourceTypeEntity().newInstance();
        return entity;
    }
    private Class<E> getSourceTypeEntity() {
        Class<?>[] typeArgs = GenericTypeResolver.resolveTypeArguments(getClass(), GenericService.class);
        return (Class<E>) typeArgs[0];
    }

    @Override
    public E save(E entity) throws Exception {
        return dao.saveAndFlush(entity);
    }

    @Override
    public void delete(E entity) throws Exception {
        dao.delete(entity);
        flush();
    }

    @Override
    public void deleteAll(List<E> entities) throws Exception {
        this.dao.deleteAll(entities);
        flush();
    }

    @Override
    public void deleteById(Long id) throws Exception {
        dao.deleteById(id);
        flush();
    }

    @Override
    public E findById(Long id) throws Exception {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<E> saveAll(List<E> entities) throws Exception {
        List<E> saveAll = new ArrayList<>();
        for (E entity : entities) {
            saveAll.add(save(entity));
        }
        return saveAll;
    }

    @Override
    public List<E> getAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public void flush() {
        dao.flush();
    }
}
