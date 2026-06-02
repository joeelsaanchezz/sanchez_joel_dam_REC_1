package examen.sanchez.joel.dao;

import examen.sanchez.joel.beans.CentroForense;
import examen.sanchez.joel.beans.InformeForense;
import examen.sanchez.joel.dao.InformeForenseDAO;
import examen.sanchez.joel.motores.MotorSQL;

import java.sql.ResultSet;
import java.util.ArrayList;

public class InformeForenseDAOImpl extends InformeForenseDAO {

    public InformeForenseDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }

    @Override
    public ArrayList<InformeForense> findByNivelRiesgo(String nivelRiesgo) {
        motorSQL.connect();
        ArrayList<InformeForense> lista = new ArrayList<>();
        InformeForense i = null;
        motorSQL.prepare("SELECT * FROM INFORMES_FORENSES WHERE NIVEL_RIESGO = ?");
        try {
            motorSQL.getPs().setString(1, nivelRiesgo);
            ResultSet rs = motorSQL.executeQuery();
            if (rs.next()) {
                i = new InformeForense();
                i.setIdInforme(rs.getString("ID"));
                i.setADNPositivo(rs.getString("ADN_POSITIVO"));
                i.setNivelRiesgo(rs.getInt("NIVEL_RIESGO"));
                i.setConclusion(rs.getString("CONCLUSION"));
                i.setSanchezjoel(rs.getString("SANCHEZJOEL"));
                lista.add(i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            motorSQL.close();
        }
        return lista;
    }


    // ===================== ADD =====================
    @Override
    public void add(InformeForense i) {
        motorSQL.connect();
        // ADAPTAR: nombre de tabla y columnas
        String sql = "INSERT INTO INFORMES_FORENSES (ADN_POSITIVO, NIVEL_RIESGO, CONCLUSION, SANCHEZJOEL)"
                + " VALUES (?,?,?,?,?)";
        motorSQL.prepare(sql);
        try {
            motorSQL.getPs().setString(1, i.getADNPositivo());
            motorSQL.getPs().setInt(2, i.getNivelRiesgo());
            motorSQL.getPs().setString(3, i.getConclusion());
            motorSQL.getPs().setString(4, i.getSanchezjoel());
            motorSQL.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            motorSQL.close();
        }
    }

    @Override
    public InformeForense find(String id) {
        return null;
    }

    // ===================== FIND ALL =====================
    @Override
    public ArrayList<InformeForense> findAll() {
        motorSQL.connect();
        ArrayList<InformeForense> lista = new ArrayList<>();
        motorSQL.prepare("SELECT * FROM INFORMES_FORENSES");
        try {
            ResultSet rs = motorSQL.executeQuery();
            while (rs.next()) {
                InformeForense i = new InformeForense();
                i.setIdInforme(rs.getString("ID"));
                i.setADNPositivo(rs.getString("ADN_POSITIVO"));
                i.setNivelRiesgo(rs.getInt("NIVEL_RIESGO"));
                i.setConclusion(rs.getString("CONCLUSION"));
                i.setSanchezjoel(rs.getString("SANCHEZJOEL"));
                lista.add(i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            motorSQL.close();
        }
        return lista;
    }

    // ===================== FIND BY ID =====================
    @Override
    public InformeForense find(int id) {
        motorSQL.connect();
        InformeForense i = null;
        motorSQL.prepare("SELECT * FROM INFORMES_FORENSES WHERE ID = ?");
        try {
            motorSQL.getPs().setInt(1, id);
            ResultSet rs = motorSQL.executeQuery();
            if (rs.next()) {
                i = new InformeForense();
                i.setIdInforme(rs.getString("ID"));
                i.setADNPositivo(rs.getString("ADN_POSITIVO"));
                i.setNivelRiesgo(rs.getInt("NIVEL_RIESGO"));
                i.setConclusion(rs.getString("CONCLUSION"));
                i.setSanchezjoel(rs.getString("SANCHEZJOEL"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            motorSQL.close();
        }
        return i;
    }

    // ===================== UPDATE =====================
    @Override
    public void update(String id, InformeForense i) {
        motorSQL.connect();
        String sql = "UPDATE INFORMES_FORENSES SET ADN_POSITIVO=?, NIVEL_RIESGO=?,"
                + " CONCLUSION=?, SANCHEZJOEL=? WHERE ID=?";
        motorSQL.prepare(sql);
        try {
            motorSQL.getPs().setString(1, i.getADNPositivo());
            motorSQL.getPs().setInt(2, i.getNivelRiesgo());
            motorSQL.getPs().setString(3, i.getConclusion());
            motorSQL.getPs().setString(4, i.getSanchezjoel());
            motorSQL.getPs().setString(5, id);
            motorSQL.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            motorSQL.close();
        }
    }

    // ===================== DELETE =====================
    @Override
    public void delete(String id) {
        motorSQL.connect();
        motorSQL.prepare("DELETE FROM INFORMES_FORENSES WHERE ID = ?");
        try {
            motorSQL.getPs().setString(1, id);
            motorSQL.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            motorSQL.close();
        }
    }
}
