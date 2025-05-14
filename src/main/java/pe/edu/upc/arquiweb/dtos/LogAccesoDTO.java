package pe.edu.upc.arquiweb.dtos;



import java.time.LocalDate;

public class LogAccesoDTO {

    private int idLog;

    private String ip;

    private String navegador;

    private String sistemaOperativo;

    private LocalDate fechaAcceso;


    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public LocalDate getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(LocalDate fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

}

