package examen.sanchez.joel.dao;

import examen.sanchez.joel.motores.MotorSQL;

import java.util.ArrayList;

public abstract class AbstractDAO<T> implements DAO<T> {

    protected MotorSQL motorSQL;

    public AbstractDAO(MotorSQL motorSQL) {
        this.motorSQL = motorSQL;
    }

    public void check() {
        motorSQL.connect();
        System.out.println("Check OK");
        motorSQL.close();
    }

    @Override public abstract void add(T obj);
    @Override public abstract T find(String id);
    @Override public abstract ArrayList<T> findAll();
    @Override public abstract void update(String id, T obj);
    @Override public abstract void delete(String id);
}
