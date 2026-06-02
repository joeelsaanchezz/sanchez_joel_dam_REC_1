package examen.sanchez.joel.dao;

import examen.sanchez.joel.beans.CentroForense;
import examen.sanchez.joel.motores.MotorSQL;

import java.util.ArrayList;

public abstract class CentroForenseDAO extends AbstractDAO<CentroForense> {

    public CentroForenseDAO(MotorSQL motorSQL) {
        super(motorSQL);
    }

    public abstract ArrayList<CentroForense> findByPais(String idCentro);
}
