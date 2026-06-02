package examen.sanchez.joel.motores;

import java.sql.DriverManager;

public class PostgreMotorSQL extends MotorSQL {

    // ADAPTAR: pon tu endpoint, usuario y contraseña de AWS
    private static final String URL =
            "bd-alberto2.cfgg2uas0zti.us-east-1.rds.amazonaws.com:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345678";
    private static final String DRIVER = "org.postgresql.Driver";

    public PostgreMotorSQL() {
        super(URL, USER, PASSWORD, DRIVER);
    }

    @Override
    public void connect() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("CONEXION OK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
