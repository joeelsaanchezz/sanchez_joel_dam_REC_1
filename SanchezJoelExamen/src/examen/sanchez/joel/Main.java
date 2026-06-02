package examen.sanchez.joel;

import examen.sanchez.joel.beans.CentroForense;
import examen.sanchez.joel.dao.CentroForenseDAOImpl;
import examen.sanchez.joel.motores.MotorFactory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CentroForenseDAOImpl dao =
                new CentroForenseDAOImpl(MotorFactory.create(MotorFactory.POSTGRE));

        dao.check();

        // ADAPTAR: datos de prueba según tu Bean
        CentroForense nueva = new CentroForense("C4", "Albania", 3, "sanchezJoel");
        dao.add(nueva);
        System.out.println("ADD: OK");

        // PRUEBA FIND ALL
        System.out.println("=== FIND ALL ===");
        ArrayList<CentroForense> lista = dao.findAll();
        for (CentroForense c : lista) {
            System.out.println(c);
        }

        // PRUEBA FIND BY ID
        System.out.println("=== FIND ID ===");
        CentroForense encontrada = dao.find("1");
        System.out.println(encontrada);

        // PRUEBA UPDATE
        // ADAPTAR: datos de actualización
        CentroForense actualizada = new CentroForense("C2", "Suiza", 2, "sanchezJoel");
        dao.update("2", actualizada);
        System.out.println("UPDATE: OK");

        // PRUEBA DELETE
        dao.delete("1");
        System.out.println("DELETE: OK");

        // PRUEBA FIND BY GENERO (método específico)
        System.out.println("=== FIND BY PAIS ===");
        ArrayList<CentroForense> scifi = dao.findByPais("Sci-Fi");
        for (CentroForense c : scifi) {
            System.out.println(c);
        }
    }
}
