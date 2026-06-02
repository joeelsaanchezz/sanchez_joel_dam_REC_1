package examen.sanchez.joel.motores;

public class MotorFactory {

    public static final String POSTGRE  = "POSTGRE";
    public static final String MARIADB  = "MARIADB";

    public static MotorSQL create(String motor) {
        switch (motor) {
            case POSTGRE: return new PostgreMotorSQL();
            default:
                throw new IllegalArgumentException("Motor no soportado: " + motor);
        }
    }
}
