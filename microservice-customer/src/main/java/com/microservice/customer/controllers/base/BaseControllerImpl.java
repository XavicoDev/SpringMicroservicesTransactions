package com.microservice.customer.controllers.base;

import com.microservice.customer.dto.Base;
import com.microservice.customer.services.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long> {
    @Autowired
    protected S service;

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody E entity) {
        try {
            service.save(entity);
            return new ResponseEntity<>("Registro exitoso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Registro fallido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<?> getAll() throws Exception {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.finById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity<?> getExists(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.existsById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody E entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id,entity));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
