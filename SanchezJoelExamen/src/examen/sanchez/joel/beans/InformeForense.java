package examen.sanchez.joel.beans;

public class InformeForense {
    private String idInforme;
    private String ADNPositivo;
    private int nivelRiesgo;
    private String conclusion;
    private String sanchezjoel;

    public InformeForense() {
        this.ADNPositivo = ADNPositivo;
        this.nivelRiesgo = nivelRiesgo;
        this.conclusion = conclusion;
        this.sanchezjoel = sanchezjoel;
    }

    public String getIdInforme() {
        return idInforme;
    }
    public void setIdInforme(String idInforme) {
        this.idInforme = idInforme;
    }
    public String getADNPositivo() {
        return ADNPositivo;
    }
    public void setADNPositivo(String ADNPositivo) {
        this.ADNPositivo = ADNPositivo;
    }
    public int getNivelRiesgo() {
        return nivelRiesgo;
    }
    public void setNivelRiesgo(int nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }
    public String getConclusion() {
        return conclusion;
    }
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
    public String getSanchezjoel() {
        return sanchezjoel;
    }
    public void setSanchezjoel(String sanchezjoel) {
        this.sanchezjoel = sanchezjoel;
    }

    @Override
    public String toString() {
        return "InformeForense{" +
                "idInforme='" + idInforme + '\'' +
                ", ADNPositivo='" + ADNPositivo + '\'' +
                ", nivelRiesgo=" + nivelRiesgo +
                ", conclusion='" + conclusion + '\'' +
                ", sanchezjoel='" + sanchezjoel + '\'' +
                '}';
    }
}
