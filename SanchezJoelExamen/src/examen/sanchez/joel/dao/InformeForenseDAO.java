package examen.sanchez.joel.dao;

import examen.sanchez.joel.beans.CentroForense;
import examen.sanchez.joel.beans.InformeForense;
import examen.sanchez.joel.motores.MotorSQL;

import java.util.ArrayList;

public abstract class InformeForenseDAO extends AbstractDAO<CentroForense> {

    public InformeForenseDAO(MotorSQL motorSQL) {
        super(motorSQL);
    }

    public abstract ArrayList<InformeForense> findByNicelRiesgo(String idInforme);

    public abstract void add(InformeForense i);
}
