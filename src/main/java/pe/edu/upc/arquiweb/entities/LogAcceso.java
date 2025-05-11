package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="LogAcceso")
public class LogAcceso {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idLog;

    @Column(name = "ip", nullable = false)
    private String ip;

    @Column(name = "navegador", nullable = false, length = 100)
    private String navegador;

    @Column(name = "sistemaOperativo", nullable = false, length = 100)
    private String sistemaOperativo;

    @Column(name = "fechaAcceso", nullable = false)
    private LocalDate fechaAcceso;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    public LogAcceso() {
    }

    public LogAcceso(int idLog, String ip, String navegador, String sistemaOperativo, LocalDate fechaAcceso, Usuario usuario) {
        this.idLog = idLog;
        this.ip = ip;
        this.navegador = navegador;
        this.sistemaOperativo = sistemaOperativo;
        this.fechaAcceso = fechaAcceso;
        this.usuario = usuario;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
