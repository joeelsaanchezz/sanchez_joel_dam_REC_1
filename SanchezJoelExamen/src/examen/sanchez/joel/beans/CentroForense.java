package examen.sanchez.joel.beans;

public class CentroForense {
    private String idCentro;
    private String nombre;
    private String pais;
    private int nivelSeguridad;
    private String sanchezjoel;

    public CentroForense(String nombre, String pais, int nivelSeguridad, String sanchezjoel) {
        this.nombre = nombre;
        this.pais = pais;
        this.nivelSeguridad = nivelSeguridad;
        this.sanchezjoel = sanchezjoel;
    }

    public String getIdCentro() {
        return idCentro;
    }
    public void setIdCentro(String idCentro) {
        this.idCentro = idCentro;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public int getNivelSeguridad() {
        return nivelSeguridad;
    }
    public void setNivelSeguridad(int nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }
    public String getSanchezjoel() {
        return sanchezjoel;
    }
    public void setSanchezjoel(String sanchezjoel) {
        this.sanchezjoel = sanchezjoel;
    }

    @Override
    public String toString() {
        return "CentroForense{" +
                "idCentro='" + idCentro + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", nivelSeguridad=" + nivelSeguridad +
                ", sanchezjoel='" + sanchezjoel + '\'' +
                '}';
    }
}
