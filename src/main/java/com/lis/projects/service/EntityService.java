package com.lis.projects.service;

import java.util.Collection;

public interface EntityService<T> {
    Collection<T> getAll();
    T getById(Long id);
    T save(T entity);
    void deleteById(Long id);
}