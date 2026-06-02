package examen.sanchez.joel.dao;

import examen.sanchez.joel.beans.CentroForense;
import examen.sanchez.joel.motores.MotorSQL;

import java.util.ArrayList;

public abstract class CentroForenseDAO extends AbstractDAO<CentroForense> {

    public CentroForenseDAO(MotorSQL motorSQL) {
        super(motorSQL);
    }

    // Métodos específicos de satélite
    public abstract ArrayList<CentroForense> findByPais(String idAgencia);
    public abstract ArrayList<CentroForense> findByNivelSeguridad();
}
