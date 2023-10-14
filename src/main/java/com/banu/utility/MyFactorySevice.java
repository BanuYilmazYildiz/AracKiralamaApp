package com.banu.utility;

import java.util.List;
import java.util.Optional;

public class MyFactorySevice <R extends MyFactoryRepository,T,ID>{

    R repository;

    public MyFactorySevice(R repository){
        this.repository=repository;
    }

    public T save(T t){
        repository.save(t);
        return t;
    }

    public T update(T t){
        repository.update(t);
        return t;
    }
    public Iterable<T> saveAll(Iterable<T> entities){
        repository.saveAll(entities);
        return entities;
    }

    public void deleteById(ID id){
        repository.deleteById(id);
    }

    public Optional<T> finById(ID id){
       return   repository.findById(id);
    }

    public boolean existById(ID id){
        return repository.existById(id);
    }

    public List<T> findALl() {
        return repository.findALl();
    }

    public List<T> findByColumnNameAndValue(String columnName, String value) {
        return repository.findByColumnNameAndValue(columnName,value);
    }

    public List<T> findByEntity(T entity) {
        return repository.findByEntity(entity);
    }


}
