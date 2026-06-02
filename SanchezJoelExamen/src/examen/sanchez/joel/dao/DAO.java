package examen.sanchez.joel.dao;

import java.util.ArrayList;

public interface DAO<T> {
    void add(T obj);
    T find(String id);
    ArrayList<T> findAll();
    void update(String id, T obj);
    void delete(String id);
}
