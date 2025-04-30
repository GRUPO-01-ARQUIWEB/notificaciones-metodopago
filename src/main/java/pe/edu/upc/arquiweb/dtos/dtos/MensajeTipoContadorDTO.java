package pe.edu.upc.arquiweb.dtos.dtos;

public class MensajeTipoContadorDTO {
    private String tipo;
    private int cantidad;

    public MensajeTipoContadorDTO() {}

    public MensajeTipoContadorDTO(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
