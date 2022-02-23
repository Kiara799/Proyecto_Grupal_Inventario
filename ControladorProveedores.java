package inventarioapp.controlador;

import inventarioapp.Aplicacion;
import inventarioapp.dao.ProveedoresDao;
import inventarioapp.vista.VentanaPrincipal;
import inventarioapp.vista.VistaAgregarProveedor;
import inventarioapp.vista.VistaListaProveedores;

public class ControladorProveedores extends ControladorBase {
	private VentanaPrincipal ventana = getApp().getVentana();
	private ProveedoresDao proveedoresDao = new ProveedoresDao();

	public ControladorProveedores(Aplicacion app) {
		super(app);
	}

	@Override
	public void inicializar() {
		ventana.agregarElementoMenu(
			"Agregar proveedor", 
			"user-plus.png",
			this::verVistaAgregarProveedor
		);
		
		ventana.agregarElementoMenu(
			"Ver proveedores", 
			"users.png",
			this::verVistaListProveedores
		);
	}

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void verVistaAgregarProveedor() {
		ventana.mostrarVista(new VistaAgregarProveedor(this));
	}
	
	public void verVistaListProveedores() {
		ventana.mostrarVista(new VistaListaProveedores(this));
	}
	
	public ProveedoresDao getProveedoresDao() {
		return proveedoresDao;
	}
}
