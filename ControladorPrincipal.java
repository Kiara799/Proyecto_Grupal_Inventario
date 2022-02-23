package inventarioapp.controlador;

import inventarioapp.Aplicacion;
import inventarioapp.vista.VentanaPrincipal;
import inventarioapp.vista.VistaInicio;
import inventarioapp.vista.VentanaPrincipal.ElementoMenu;

/**
 * Controlador principal de la aplicacion, este se encarga de manejar la vista
 * "VistaInicio"
 * 
 * @author 
 */
public class ControladorPrincipal extends ControladorBase {
    // ventana principal de la aplicacion
    private VentanaPrincipal ventana = getApp().getVentana();
    
    public ControladorPrincipal(Aplicacion app) {
        super(app);
    }

    @Override
    public void inicializar() {
        /*/ agregamos al menu de la ventana principal una opcion para ver
        // la vista inicio
        ElementoMenu inicio = ventana.agregarElementoMenu(
                "Inicio", 
                "menu-icono-inicio.png", 
                this::menuInicio
        );
        
        // seleccionamos esa opcion para mostrarla apenas se muestre
        // la ventana principal de la aplicacion
        inicio.seleccionar();*/
    }
    
    // identificador del controlador
    @Override
    public String id() {
        return "principal";
    }

    // mostramos la vista inicio
    private void menuInicio() {
        ventana.mostrarVista(new VistaInicio(this));
    }
}
