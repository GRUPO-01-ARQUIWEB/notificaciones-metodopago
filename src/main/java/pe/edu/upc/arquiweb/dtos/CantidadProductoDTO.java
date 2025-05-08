package pe.edu.upc.arquiweb.dtos;

public class CantidadProductoDTO {

    private String Nombre;
    private int CantidadProductos;


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCantidadProductos() {
        return CantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        CantidadProductos = cantidadProductos;
    }
}
