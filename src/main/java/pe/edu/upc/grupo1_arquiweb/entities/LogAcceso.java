package pe.edu.upc.grupo1_arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "LogAcceso")
public class LogAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogAcceso;

    @Column(name = "fechaAcceso", nullable = false)
    private LocalDate fechaAcceso;

    @Column(name = "ip", nullable = false)
    private String ip;

    @Column(name = "navegador", nullable = false)
    private String navegador;

    @Column(name = "sistemaOperativo", nullable = false)
    private String sistemaOperativo;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public LogAcceso() {
    }

    public LogAcceso(Long idLogAcceso, LocalDate fechaAcceso, String ip, String navegador, String sistemaOperativo, Users user) {
        this.idLogAcceso = idLogAcceso;
        this.fechaAcceso = fechaAcceso;
        this.ip = ip;
        this.navegador = navegador;
        this.sistemaOperativo = sistemaOperativo;
        this.user = user;
    }

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
