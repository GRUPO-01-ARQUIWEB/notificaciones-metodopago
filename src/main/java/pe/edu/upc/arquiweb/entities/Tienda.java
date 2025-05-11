package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name ="Tienda")
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTienda;

    @NotBlank(message = "El nombre de la tienda no puede estar vacío")
    @Size(max = 70, message = "El nombre de la tienda no puede tener más de 70 caracteres")
    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @NotBlank(message = "La descripcion no puede estar vacío")
    @Size(max = 100, message = "La descripcion no puede tener más de 100 caracteres")
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @NotBlank(message = "La ubicacion no puede estar vacío")
    @Size(max = 70, message = "La ubicacion no puede tener más de 70 caracteres")
    @Column(name = "ubicacion", nullable = false, length = 70)
    private String ubicacion;

    @Size(max = 9, message = "El telefono no puede tener más de 9 numeros")
    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;

    @NotBlank(message = "El correoelectronico no puede estar vacío")
    @Size(max = 100, message = "El correo no puede tener más de 100 caracteres")
    @Column(name = "correoelectronico", nullable = false, length = 100)
    private String correoelectronico;

    @NotNull(message = "La latitud es obligatoria")
    @Column(name = "latitud", nullable = false)
    private Double latitud;

    @NotNull(message = "La longitud es obligatoria")
    @Column(name = "longitud", nullable = false)
    private Double longitud;

    public Tienda() {
    }

    public Tienda(int idTienda, String nombre, String descripcion, String ubicacion, String telefono, String correoelectronico, Double latitud, Double longitud) {
        this.idTienda = idTienda;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.correoelectronico = correoelectronico;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}

