package pe.edu.upc.projecarqui.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tienda")
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTienda;

    @Column(name ="nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name ="descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name ="ubicacion", nullable = false, length = 50)
    private String ubicacion;

    @Column(name ="telefono", nullable = false)
    private int telefono;

    @Column(name ="correoElectronico", nullable = false, length = 50)
    private String correoElectronico;

    @Column(name ="latitud", nullable = false)
    private double latitud;

    @Column(name ="longitud", nullable = false)
    private double longitud;

    public Tienda() {
    }

    public Tienda(int idTienda, String nombre, String descripcion, String ubicacion, int telefono, String correoElectronico, double latitud, double longitud) {
        this.idTienda = idTienda;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
