package inventarioapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import inventarioapp.core.Dao;
import inventarioapp.modelo.Factura;
import inventarioapp.modelo.FacturaElemento;
import inventarioapp.modelo.Persona;
import inventarioapp.modelo.Producto;

public class FacturasDao extends Dao {
	private final MongoCollection<Document> coleccion = getDatabase().getCollection("facturas");
	private ProveedoresDao proveedoresDao = new ProveedoresDao();
	
	public void agregarFactura(Factura factura) {
		Document documento = new Document();
		int numero = getTotalFacturas() + 1;
		
		Document cliente = new Document();
		List<Document> elementos = new ArrayList<>();

		cliente.append("nombre", factura.getCliente().getNombre());
		cliente.append("cedula", factura.getCliente().getCedula());
		cliente.append("direccion", factura.getCliente().getDireccion());
		
		for (FacturaElemento elemento : factura.getElementos()) {
			Document documentoElemento = new Document();
			Document producto = new Document("_id", elemento.getProducto().getObjectId())
				.append("codigo", elemento.getProducto().getCodigo())
				.append("nombre", elemento.getProducto().getNombre())
				.append("precio", elemento.getProducto().getPrecio())
				.append("tipo", elemento.getProducto().getTipo().toString())
				.append("proveedor", elemento.getProducto().getProveedor().getObjectId());
			
			documentoElemento.append("producto", producto);
			documentoElemento.append("cantidad", elemento.getCantidad());
			
			elementos.add(documentoElemento);
		}
		
		documento.append("numero", numero);
		documento.append("cliente", cliente);
		documento.append("iva", factura.getIva());
		documento.append("elementos", elementos);
		
		coleccion.insertOne(documento);
	}
	
	public int getTotalFacturas() {
		return (int) coleccion.countDocuments();
	}
	
	public List<Factura> getFacturas() {
		List<Factura> facturas = new ArrayList<Factura>();
		
		FindIterable<Document> iterable = coleccion.find();
		
		for (Document document : iterable) {
			int numero = document.getInteger("numero");
			double iva = document.getDouble("iva");
			
			Document clienteDoc = document.get("cliente", Document.class);
			
			Persona cliente = new Persona(
				clienteDoc.getString("nombre"), 
				clienteDoc.getString("cedula"), 
				clienteDoc.getString("direccion")
			);
			cliente.setObjectId(clienteDoc.getObjectId("_id"));
			
			Factura factura = new Factura(numero, cliente, (float)iva);
			
			List<Document> elementosDocs = document.getList("elementos", Document.class);
			
			for (Document elementoDoc : elementosDocs) {
				int cantidad = elementoDoc.getInteger("cantidad");
				Document productoDoc = elementoDoc.get("producto", Document.class);
				
				Producto producto = new Producto(
					productoDoc.getString("codigo"),
					productoDoc.getString("nombre"),
					productoDoc.getDouble("precio"),
					productoDoc.getString("tipo"),
					proveedoresDao.getProveedor(productoDoc.getObjectId("proveedor"))
				);
				producto.setObjectId(productoDoc.getObjectId("_id"));
				
				FacturaElemento elemento = new FacturaElemento(producto, cantidad);
				factura.agregarElemento(elemento);
			}
			
			facturas.add(factura);
		}
		
		return facturas;
	}
}
