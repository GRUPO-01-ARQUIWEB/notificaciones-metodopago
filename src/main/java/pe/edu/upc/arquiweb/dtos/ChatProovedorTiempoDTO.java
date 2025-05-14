package pe.edu.upc.arquiweb.dtos;

public class ChatProovedorTiempoDTO {
    private Integer anio;
    private Integer mes;
    private Long cantidadChats;

    public ChatProovedorTiempoDTO(Integer anio, Integer mes, Long cantidadChats) {
        this.anio = anio;
        this.mes = mes;
        this.cantidadChats = cantidadChats;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Long getCantidadChats() {
        return cantidadChats;
    }

    public void setCantidadChats(Long cantidadChats) {
        this.cantidadChats = cantidadChats;
    }
}
