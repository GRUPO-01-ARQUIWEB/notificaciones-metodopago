package pe.edu.upc.grupo1_arquiweb.dtos;

import java.time.LocalDate;

public class LogAccesoDTO {

    private Long idLogAcceso;
    private LocalDate fechaAcceso;
    private String ip;
    private String navegador;
    private String sistemaOperativo;
    private Long idUser;

    public Long getIdLogAcceso() {
        return idLogAcceso;
    }

    public void setIdLogAcceso(Long idLogAcceso) {
        this.idLogAcceso = idLogAcceso;
    }

    public LocalDate getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(LocalDate fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
