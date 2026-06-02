package examen.sanchez.joel.dao;

import examen.sanchez.joel.beans.InformeForense;
import examen.sanchez.joel.motores.MotorSQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InformeForenseDAOImpl {


    public class InformeForenseDAOImpl extends InformeForenseDAO {

        public InformeForenseDAOImpl(MotorSQL motorSQL) {
            super(motorSQL);
        }

        @Override
        public void add(InformeForense i) {
            MotorSQL.connect();
            try {
                PreparedStatement ps = MotorSQL.connect().prepareStatement(
                        "INSERT INTO AGENCIAS VALUES (?, ?, ?, ?)");
                ps.setString(1, i.getIdInforme());
                ps.setString(2, i.getADNPositivo());
                ps.setInt(3, i.getNivelRiesgo());
                ps.setString(4, i.getConclusion());
                ps.setString(5, i.getSanchezjoel());
                ps.executeUpdate();
                System.out.println("Agencia añadida: " + i.getIdInforme());
            } catch (SQLException e) { System.out.println("[ERROR] " + e.getMessage()); }
            finally { motorSQL.close(); }
        }

        @Override
        public InformeForense find(String id) {
            motorSQL.connect();
            InformeForense informe = null;
            try {
                PreparedStatement ps = motorSQL.getConnection().prepareStatement(
                        "SELECT * FROM AGENCIAS WHERE ID_AGENCIA = ?");
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    agencia = new Agencia(rs.getString("ID_AGENCIA"),
                            rs.getString("NOMBRE"), rs.getString("PAIS"),
                            rs.getInt("FECHA_FUND"));
                }
            } catch (SQLException e) { System.out.println("[ERROR] " + e.getMessage()); }
            finally { motorSQL.close(); }
            return agencia;
        }

        @Override
        public ArrayList<Agencia> findAll() {
            motorSQL.connect();
            ArrayList<Agencia> lista = new ArrayList<>();
            try {
                PreparedStatement ps = motorSQL.getConnection().prepareStatement(
                        "SELECT * FROM AGENCIAS");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    lista.add(new Agencia(rs.getString("ID_AGENCIA"),
                            rs.getString("NOMBRE"), rs.getString("PAIS"),
                            rs.getInt("FECHA_FUND")));
                }
            } catch (SQLException e) { System.out.println("[ERROR] " + e.getMessage()); }
            finally { motorSQL.close(); }
            return lista;
        }

        @Override
        public void update(String id, Agencia a) {
            motorSQL.connect();
            try {
                PreparedStatement ps = motorSQL.getConnection().prepareStatement(
                        "UPDATE AGENCIAS SET NOMBRE=?, PAIS=?, FECHA_FUND=? WHERE ID_AGENCIA=?");
                ps.setString(1, a.getNombre());
                ps.setString(2, a.getPais());
                ps.setInt(3, a.getFechaFundacion());
                ps.setString(4, id);
                ps.executeUpdate();
            } catch (SQLException e) { System.out.println("[ERROR] " + e.getMessage()); }
            finally { motorSQL.close(); }
        }

        @Override
        public void delete(String id) {
            motorSQL.connect();
            try {
                PreparedStatement ps = motorSQL.getConnection().prepareStatement(
                        "DELETE FROM AGENCIAS WHERE ID_AGENCIA = ?");
                ps.setString(1, id);
                ps.executeUpdate();
            } catch (SQLException e) { System.out.println("[ERROR] " + e.getMessage()); }
            finally { motorSQL.close(); }
        }

        @Override
        public ArrayList<Agencia> findByPais(String pais) {
            motorSQL.connect();
            ArrayList<Agencia> lista = new ArrayList<>();
            try {
                PreparedStatement ps = motorSQL.getConnection().prepareStatement(
                        "SELECT * FROM AGENCIAS WHERE PAIS = ?");
                ps.setString(1, pais);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    lista.add(new Agencia(rs.getString("ID_AGENCIA"),
                            rs.getString("NOMBRE"), rs.getString("PAIS"),
                            rs.getInt("FECHA_FUND")));
                }
            } catch (SQLException e) { System.out.println("[ERROR] " + e.getMessage()); }
            finally { motorSQL.close(); }
            return lista;
        }

        @Override
        public ArrayList<Agencia> findByFechaFundacion(int year) {
            motorSQL.connect();
            ArrayList<Agencia> lista = new ArrayList<>();
            try {
                PreparedStatement ps = motorSQL.getConnection().prepareStatement(
                        "SELECT * FROM AGENCIAS WHERE FECHA_FUND = ?");
                ps.setInt(1, year);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    lista.add(new Agencia(rs.getString("ID_AGENCIA"),
                            rs.getString("NOMBRE"), rs.getString("PAIS"),
                            rs.getInt("FECHA_FUND")));
                }
            } catch (SQLException e) { System.out.println("[ERROR] " + e.getMessage()); }
            finally { motorSQL.close(); }
            return lista;
        }
    }

}
