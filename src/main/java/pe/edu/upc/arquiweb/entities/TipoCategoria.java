package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoCategoria")
public class TipoCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoCategoria;

    @Column(name ="descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name ="nombre_categoria", nullable = false, length = 50)
    private String nombre_categoria;

    //FK
    @ManyToOne
    @JoinColumn(name = "idTienda")
    private Tienda tienda;

    public TipoCategoria() {
    }

    public TipoCategoria(int idTipoCategoria, String descripcion, String nombre_categoria, Tienda tienda) {
        this.idTipoCategoria = idTipoCategoria;
        this.descripcion = descripcion;
        this.nombre_categoria = nombre_categoria;
        this.tienda = tienda;
    }

    public int getIdTipoCategoria() {
        return idTipoCategoria;
    }

    public void setIdTipoCategoria(int idTipoCategoria) {
        this.idTipoCategoria = idTipoCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

}
