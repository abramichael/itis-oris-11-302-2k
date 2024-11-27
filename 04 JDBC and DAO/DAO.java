package org.example.zeroproject.dao;

import java.util.List;

public interface DAO<T> {
    void create(T x);
    void update(T x);
    void delete(int id);
    T get(int id);
    List<T> getAll();
}
