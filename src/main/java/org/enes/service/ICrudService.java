package org.enes.service;

import java.util.Optional;

public interface ICrudService<T,ID> {
    T save(T t);
    T update(T t);
    Optional<T> findById(ID id);
    Iterable<T> findAll();
    T deleteById (ID id);
}
