package inventarioapp;

/**
 *
 * @author
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // obtenemos la instancia de la clase aplicacion
        Aplicacion app = Aplicacion.getInstancia();
        
        // iniciamos la aplicacion
        app.iniciar();
    }
}
