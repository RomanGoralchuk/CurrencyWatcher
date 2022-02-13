package com.currency.crypto.goralchuk.watcher.services;

import java.util.List;
import java.util.Optional;

public interface BaseService <T, ID>{
    T saveOrUpdate(T entity);

    Optional<T> findById(ID id);

    void deleteById(ID id);

    List<T> findAll();
}
