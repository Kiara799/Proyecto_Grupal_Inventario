package inventarioapp.modelo;

/**
 * Esta clase se usa para comunicarse entre controlador y vista
 * el controlador enviar un mensaje de estado a las vistas, es util cuando hacemos
 * operaciones en el controlador y se le quiere informar a la vista si una operacion
 * es valida o invalida
 * 
 * @author
 */
public class MensajeEstado {
    public enum Estado {
        OK,
        ERROR
    }
    
    private Estado estado;
    private String mensaje;
    private Object[] parametros;
    
    public MensajeEstado(Estado estado, String mensaje, Object[] parametros) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.parametros = parametros;
    }
    
    public MensajeEstado(Estado estado, String mensaje) {
        this(estado, mensaje, new Object[]{});
    }
    
    public static MensajeEstado ok(String mensaje, Object[] parametros) {
        return new MensajeEstado(Estado.OK, mensaje);
    }
    
    public static MensajeEstado ok(String mensaje) {
        return new MensajeEstado(Estado.OK, mensaje);
    }
    
    public static MensajeEstado ok() {
        return new MensajeEstado(Estado.OK, "");
    }
    
    public static MensajeEstado error(String mensaje, Object[] parametros) {
        return new MensajeEstado(Estado.ERROR, mensaje);
    }
    
    public static MensajeEstado error(String mensaje) {
        return new MensajeEstado(Estado.ERROR, mensaje);
    }
    
    public static MensajeEstado error() {
        return new MensajeEstado(Estado.ERROR, "");
    }
    
    public boolean correcto() {
        return estado == Estado.OK;
    }
    
    public boolean incorrecto() {
        return estado == Estado.ERROR;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    public Object[] getParametros() {
        return parametros;
    }
}
