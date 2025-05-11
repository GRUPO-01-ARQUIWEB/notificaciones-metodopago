package pe.edu.upc.arquiweb.exceptions;

public class BadRequestException  extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}