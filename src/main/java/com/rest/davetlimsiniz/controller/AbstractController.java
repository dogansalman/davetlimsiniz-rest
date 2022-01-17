package com.rest.davetlimsiniz.controller;

import com.rest.davetlimsiniz.dto.GenericDTO;
import com.rest.davetlimsiniz.entity.GenericEntity;
import com.rest.davetlimsiniz.mapper.GenericMapper;
import com.rest.davetlimsiniz.service.GenericService;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


public class AbstractController<E extends GenericEntity, D extends GenericDTO> {
    @Autowired
    protected GenericService<E> service;
    @Autowired protected GenericMapper<E, D> mapper;

    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable Long id) throws Exception {
        E entity = service.findById(id);
        return new ResponseEntity<D>(mapper.clone(entity), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<D>> getAll() throws Exception {
        List<E> entities = service.getAll();
        return new ResponseEntity<List<D>>(mapper.toDtos(entities), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<D> create(@RequestBody D dto) throws Exception {
        // Todo id varsa bad request döndür.
        E entity = service.save(mapper.toEntity(dto));
        return new ResponseEntity<D>(mapper.clone(entity), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody D dto) throws Exception {
        E entity = service.findById(dto.getId());
        if(entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provide correct Id");
        }

        return new ResponseEntity<D>(dto, HttpStatus.OK);


    }

}
