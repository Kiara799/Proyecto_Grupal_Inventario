package inventarioapp.controlador;

import inventarioapp.Aplicacion;
import inventarioapp.dao.ProductosDao;
import inventarioapp.dao.ProveedoresDao;
import inventarioapp.vista.VentanaPrincipal;
import inventarioapp.vista.VistaInicio;
import inventarioapp.vista.VistaListaProductos;
import inventarioapp.vista.VentanaPrincipal.ElementoMenu;
import inventarioapp.vista.VistaAgregarProducto;

public class ControladorProductos extends ControladorBase {
	private VentanaPrincipal ventana = getApp().getVentana();
	private ProductosDao productosDao = new ProductosDao();
	private ProveedoresDao proveedoresDao = new ProveedoresDao();
	
	
	public ControladorProductos(Aplicacion app) {
		super(app);
	}

	@Override
	public void inicializar() {
		ElementoMenu elementoMenu = ventana.agregarElementoMenu(
            "Agregar producto", 
            "bag-shopping.png", 
            this::verVistaAgregarProducto
        );
		
		ventana.agregarElementoMenu(
            "Ver productos", 
            "list-ol.png", 
            this::verVistaListaProductos
        );
		
		elementoMenu.seleccionar();
	}

	@Override
	public final String id() {
		return "productos";
	}

    private void verVistaAgregarProducto() {
        ventana.mostrarVista(new VistaAgregarProducto(this));
    }
    
    private void verVistaListaProductos() {
    	ventana.mostrarVista(new VistaListaProductos(this));
    }
    
    public ProductosDao getProductosDao() {
    	return productosDao;
    }
    
    public ProveedoresDao getProveedoresDao() {
    	return proveedoresDao;
    }
}
