package com.rest.davetlimsiniz.mapper;

import java.util.List;

public interface GenericMapper <E, D> {
    D clone(E entity);
    List<D> toDtos(List<E> entities);
    E toEntity(D dto);
}
