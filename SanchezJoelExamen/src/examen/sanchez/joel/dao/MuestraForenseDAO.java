package examen.sanchez.joel.dao;

import examen.sanchez.joel.beans.CentroForense;
import examen.sanchez.joel.beans.MuestraForense;
import examen.sanchez.joel.motores.MotorSQL;

import java.util.ArrayList;

public abstract class MuestraForenseDAO extends AbstractDAO<CentroForense> {

    public MuestraForenseDAO(MotorSQL motorSQL) {
        super(motorSQL);
    }

    public abstract ArrayList<MuestraForense> findByTipoPelo(String idMuestra);
}
