package com.rest.davetlimsiniz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericDAO<E> extends JpaRepository<E, Long> {
}
