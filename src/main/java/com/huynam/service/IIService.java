package com.huynam.service;

import java.util.List;

public interface IIService<T> {

    List<T> findAll();
    T findById(int id);
    void save(T p);
    void delete(int id);
    void edit(int id, T t);
    List<T> findByName(String name);
}
