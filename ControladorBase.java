package inventarioapp.controlador;

import inventarioapp.Aplicacion;

/**
 * Clase para definir un controlador base, todos los controladores
 * heredan de este controlador base
 * 
 * @author 
 */
public abstract class ControladorBase {
    // instancia de la clase Aplicacion
    private Aplicacion app;
    
    public ControladorBase(Aplicacion app) {
        this.app = app;
    }
    
    // getter para la instancia de Aplicacion
    public Aplicacion getApp() {
        return app;
    }
    
    // obtiene el identificador del controlador
    public String getId() {
        return id();
    }
    
    // metodo para inicializar alguna configuracion de un controlador
    public abstract void inicializar();
    
    // metodo que debe regresar una cadena con el identificador de un controlador
    public abstract String id();
}
