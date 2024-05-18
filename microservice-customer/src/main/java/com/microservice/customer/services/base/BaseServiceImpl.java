package com.microservice.customer.services.base;

import com.microservice.customer.dto.Base;
import com.microservice.customer.repositories.base.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {
    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E,ID> baseRepository){
        this.baseRepository=baseRepository;
    }

    @Override
    public List<E> findAll() throws Exception {
        List<E> entities=baseRepository.findAll();
        return entities;
    }

    @Override
    public E finById(ID id) throws Exception {
        Optional<E> entity=baseRepository.findById(id);
        return entity.get();
    }

    @Override
    public boolean existsById(ID id) throws Exception {
        return baseRepository.existsById(id);
    }

    @Override
    public E save(E entity) throws Exception {
        entity=baseRepository.save(entity);
        return entity;
    }

    @Override
    public E update(ID id, E entity) throws Exception {
        Optional<E> entityOptional=baseRepository.findById(id);
        E entityUpdate=entityOptional.get();
        entityUpdate= baseRepository.save(entity);
        return entityUpdate;
    }

    @Override
    public boolean delete(ID id) throws Exception {
        if(baseRepository.existsById(id)){
            baseRepository.deleteById(id);
            return true;
        }
        else {
            throw new Exception();
        }
    }
}
