package pe.edu.upc.arquiweb.dtos;

public class MetodoPagoDTO {

    private int idMetodo;
    private String tipo;
    private String numeroTelefonico;
    private String vencimiento;


    public int getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(int idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

}
