package examen.sanchez.joel.dao;

import examen.sanchez.joel.beans.CentroForense;
import examen.sanchez.joel.motores.MotorSQL;

import java.sql.ResultSet;
import java.util.ArrayList;


    public class CentroForenseDAOImpl extends CentroForenseDAO {

        public CentroForenseDAOImpl(MotorSQL motorSQL) {
            super(motorSQL);
        }

        @Override
        public ArrayList<CentroForense> findByPais(String pais) {
            motorSQL.connect();
            ArrayList<CentroForense> lista = new ArrayList<>();
            CentroForense c = null;
            motorSQL.prepare("SELECT * FROM CENTROS_FORENSES WHERE PAIS = ?");

            try {
                motorSQL.getPs().setString(1, pais);
                ResultSet rs = motorSQL.executeQuery();
                if (rs.next()) {
                    c = new CentroForense();
                    c.setIdCentro(rs.getString("ID"));
                    c.setNombre(rs.getString("NOMBRE"));
                    c.setPais(rs.getString("PAIS"));
                    c.setNivelSeguridad(rs.getInt("NIVEL_SEGURIDAD"));
                    c.setSanchezjoel(rs.getString("SANCHEZJOEL"));
                    lista.add(c);
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
        public void add(CentroForense c) {
            motorSQL.connect();
            // ADAPTAR: nombre de tabla y columnas
            String sql = "INSERT INTO CENTROS_FORENSES (NOMBRE, PAIS, NIVEL_SEGURIDAD, SANCHEZJOEL)"
                    + " VALUES (?,?,?,?)";
            motorSQL.prepare(sql);
            try {
                // ADAPTAR: setters según atributos del Bean
                motorSQL.getPs().setString(1, c.getNombre());
                motorSQL.getPs().setString(2, c.getPais());
                motorSQL.getPs().setInt(3, c.getNivelSeguridad());
                motorSQL.getPs().setString(4, c.getSanchezjoel());
                motorSQL.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                motorSQL.close();
            }
        }

        // ===================== FIND ALL =====================
        @Override
        public ArrayList<CentroForense> findAll() {
            motorSQL.connect();
            ArrayList<CentroForense> lista = new ArrayList<>();
            motorSQL.prepare("SELECT * FROM CENTROS_FORENSES");
            try {
                ResultSet rs = motorSQL.executeQuery();
                while (rs.next()) {
                    CentroForense c = new CentroForense();
                    c.setIdCentro(rs.getString("ID"));
                    c.setNombre(rs.getString("NOMBRE"));
                    c.setPais(rs.getString("PAIS"));
                    c.setNivelSeguridad(rs.getInt("NIVEL_SEGURIDAD"));
                    c.setSanchezjoel(rs.getString("SANCHEZJOEL"));
                    lista.add(c);
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
        public CentroForense find(String id) {
            motorSQL.connect();
            CentroForense c = null;
            // ADAPTAR: nombre de tabla
            motorSQL.prepare("SELECT * FROM CENTROS_FORENSES WHERE ID = ?");
            try {
                motorSQL.getPs().setString(1, id);
                ResultSet rs = motorSQL.executeQuery();
                if (rs.next()) {
                    c = new CentroForense();
                    c.setIdCentro(rs.getString("ID"));
                    c.setNombre(rs.getString("NOMBRE"));
                    c.setPais(rs.getString("PAIS"));
                    c.setNivelSeguridad(rs.getInt("NIVEL_SEGURIDAD"));
                    c.setSanchezjoel(rs.getString("SANCHEZJOEL"));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                motorSQL.close();
            }
            return c;
        }

        // ===================== UPDATE =====================
        @Override
        public void update(String id, CentroForense c) {
            motorSQL.connect();
            // ADAPTAR: nombre de tabla y columnas
            String sql = "UPDATE CENTROS_FORENSES SET NOMBRE=?, PAIS=?,"
                    + " NIVEL_SEGURIDAD=?, SANCHEZJOEL=? WHERE ID=?";
            motorSQL.prepare(sql);
            try {
                motorSQL.getPs().setString(1, c.getNombre());
                motorSQL.getPs().setString(2, c.getPais());
                motorSQL.getPs().setInt(3, c.getNivelSeguridad());
                motorSQL.getPs().setString(4, c.getSanchezjoel());
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
            // ADAPTAR: nombre de tabla
            motorSQL.prepare("DELETE FROM CENTROS_FORENSES WHERE ID = ?");
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

