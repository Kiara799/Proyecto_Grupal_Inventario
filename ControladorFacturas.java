package inventarioapp.controlador;

import inventarioapp.Aplicacion;
import inventarioapp.dao.FacturasDao;
import inventarioapp.dao.ProductosDao;
import inventarioapp.vista.VentanaPrincipal;
import inventarioapp.vista.VistaAgregarFactura;
import inventarioapp.vista.VistaListaFacturas;

public class ControladorFacturas extends ControladorBase {
    private VentanaPrincipal ventana = getApp().getVentana();
    private ProductosDao productosDao = new ProductosDao();
    private FacturasDao facturasDao = new FacturasDao();
    
	public ControladorFacturas(Aplicacion app) {
		super(app);
	}

	@Override
	public void inicializar() {
		ventana.agregarElementoMenu(
            "Agregar factura", 
            "receipt.png", 
            this::verVistaAgregrarFactura
        );
		
		ventana.agregarElementoMenu(
            "Ver facturas", 
            "square-list.png", 
            this::verVistaListaFacturas
        );
	}

	@Override
	public String id() {
		return "facturas";
	}
	
	public void verVistaAgregrarFactura() {
		ventana.mostrarVista(new VistaAgregarFactura(this));
	}
	
	public void verVistaListaFacturas() {
		ventana.mostrarVista(new VistaListaFacturas(this));
	}
	
	public ProductosDao getProductosDao() {
		return productosDao;
	}
	
	public FacturasDao getFacturasDao() {
		return facturasDao;
	}
}
