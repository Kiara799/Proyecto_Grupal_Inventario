package inventarioapp;

import com.formdev.flatlaf.FlatLightLaf;

import inventarioapp.controlador.ControladorBase;
import inventarioapp.controlador.ControladorFacturas;
import inventarioapp.controlador.ControladorPrincipal;
import inventarioapp.controlador.ControladorProductos;
import inventarioapp.controlador.ControladorProveedores;
import inventarioapp.dao.UsuariosDao;
import inventarioapp.vista.VentanaLogin;
import inventarioapp.vista.VentanaPrincipal;

import java.util.List;
import java.util.ArrayList;

public class Aplicacion {
    private static Aplicacion instancia = null;
    private List<ControladorBase> controladores = new ArrayList<>();
    private final VentanaPrincipal ventana = new VentanaPrincipal();
    private final VentanaLogin ventanaLogin = new VentanaLogin(new UsuariosDao());
    
    public static Aplicacion getInstancia() {
        if (instancia == null) {
            instancia = new Aplicacion();
        }
        
        return instancia;
    }
    
    public void iniciar() {
    	ventanaLogin.alIngresar(() -> {
    		// registramos todos los controladores
            controladores.add(new ControladorPrincipal(this));
            controladores.add(new ControladorProductos(this));
            controladores.add(new ControladorFacturas(this));
            controladores.add(new ControladorProveedores(this));
            
            // inicializamos todos los controladores
            for (ControladorBase controlador : controladores) {
                controlador.inicializar();
            }
            
            // centramos la ventana y la mostramos
            ventanaLogin.dispose();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
    	});
    	ventanaLogin.setLocationRelativeTo(null);
    	ventanaLogin.setVisible(true);
    }
    
    // getter para obtener la ventana principal de la aplicacion
    public VentanaPrincipal getVentana() {
        return ventana;
    }
    
    // metodo para obtener un controlador dado su identificador
    // cada controlador tiene un identificador gracias al metodo id()
    public ControladorBase getControlador(String id) {
        for (ControladorBase controlador : controladores) {
            if (controlador.getId().equalsIgnoreCase(id)) {
                return controlador;
            }
        }
        
        return null;
    }
    
    // constructor privado
    private Aplicacion() {
        // definimos el tema de interfaz con la libreria FlatLightLaf, lo que
        // nos proporciona un diseño mas moderno.
        FlatLightLaf.setup();
    }
}
