package examen.sanchez.joel.beans;

public class MuestraForense {
    private String idMuestra;
    private int codigoCaso;
    private String tipoMuestra;
    private String fechaRecogida;
    private String esadoCustodia;
    private CentroForense centroForense;
    private InformeForense informeForense;
    private String sanchezjoel;


    public MuestraForense(int codigoCaso, String tipoMuestra, String fechaRecogida, String esadoCustodia, CentroForense centroForense, InformeForense informeForense, String sanchezjoel) {
        this.codigoCaso = codigoCaso;
        this.tipoMuestra = tipoMuestra;
        this.fechaRecogida = fechaRecogida;
        this.esadoCustodia = esadoCustodia;
        this.centroForense = centroForense;
        this.informeForense = informeForense;
        this.sanchezjoel = sanchezjoel;
    }

    public int getCodigoCaso() {
        return codigoCaso;
    }
    public void setCodigoCaso(int codigoCaso) {
        this.codigoCaso = codigoCaso;
    }
    public String getTipoMuestra() {
        return tipoMuestra;
    }
    public void setTipoMuestra(String tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }
    public String getFechaRecogida() {
        return fechaRecogida;
    }
    public void setFechaRecogida(String fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }
    public String getEsadoCustodia() {
        return esadoCustodia;
    }
    public void setEsadoCustodia(String esadoCustodia) {
        this.esadoCustodia = esadoCustodia;
    }
    public CentroForense getCentroForense() {
        return centroForense;
    }
    public void setCentroForense(CentroForense centroForense) {
        this.centroForense = centroForense;
    }
    public InformeForense getInformeForense() {
        return informeForense;
    }
    public void setInformeForense(InformeForense informeForense) {
        this.informeForense = informeForense;
    }
    public String getSanchezjoel() {
        return sanchezjoel;
    }
    public void setSanchezjoel(String sanchezjoel) {
        this.sanchezjoel = sanchezjoel;
    }

    @Override
    public String toString() {
        return "MuestraForense{" +
                "idMuestra='" + idMuestra + '\'' +
                ", codigoCaso=" + codigoCaso +
                ", tipoMuestra='" + tipoMuestra + '\'' +
                ", fechaRecogida='" + fechaRecogida + '\'' +
                ", esadoCustodia='" + esadoCustodia + '\'' +
                ", centroForense=" + centroForense +
                ", informeForense=" + informeForense +
                ", sanchezjoel='" + sanchezjoel + '\'' +
                '}';
    }
}
