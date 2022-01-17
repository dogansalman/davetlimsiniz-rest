package com.rest.davetlimsiniz.service;

import com.rest.davetlimsiniz.entity.GenericEntity;

import java.util.List;

public interface GenericService <E extends GenericEntity> {
    E newEntity() throws Exception;
    E save(E entity) throws Exception;
    void delete(E entity) throws Exception;
    void deleteById(Long id) throws Exception;
    void deleteAll(List<E> entities) throws Exception;
    E findById(Long id) throws Exception;
    List<E> saveAll(List<E> entities) throws Exception;
    List<E> getAll() throws Exception;

    void flush();
}
