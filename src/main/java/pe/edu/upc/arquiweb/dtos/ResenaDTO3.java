package pe.edu.upc.arquiweb.dtos;



import java.time.LocalDate;

public class ResenaDTO3 {

    private double calificacion;
    private String comentario;
    private LocalDate fecha;


    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


}
