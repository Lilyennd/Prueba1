package cl.QuickOrder.v1.exception;

public class ResourseNotFoundException extends RuntimeException {
    public ResourseNotFoundException(String mensaje){
        super(mensaje);
    }

    public ResourseNotFoundException(String mensaje, Throwable causa){
        super(mensaje, causa);
    }


}
