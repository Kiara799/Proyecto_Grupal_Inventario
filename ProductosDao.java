package inventarioapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import inventarioapp.core.Dao;
import inventarioapp.modelo.Producto;
import inventarioapp.modelo.Proveedor;

public class ProductosDao extends Dao {
	private final MongoCollection<Document> coleccion = getDatabase().getCollection("productos");
	private ProveedoresDao proveedoresDao;
	
	public ProductosDao() {
		proveedoresDao = new ProveedoresDao();
	}
	
	public List<Producto> getProductos() {
		List<Producto> productos = new ArrayList<>();
		FindIterable<Document> iterable = coleccion.find();
		
		iterable.forEach((Document documento) -> {
			String codigo = documento.getString("codigo");
		    String nombre = documento.getString("nombre");
		    double precio = documento.getDouble("precio");
		    String tipo = documento.getString("tipo");
		    Proveedor proveedor = proveedoresDao.getProveedor(documento.getObjectId("proveedor"));
		    
		    Producto producto = new Producto(codigo, nombre, precio, tipo, proveedor);
		    producto.setObjectId(documento.getObjectId("_id"));
		    productos.add(producto);
		});
		
		return productos;
	}
	
	public void guardarProducto(Producto producto) {
		Document documento = new Document("codigo", producto.getCodigo())
			.append("nombre", producto.getNombre())
			.append("precio", producto.getPrecio())
			.append("tipo", producto.getTipo().toString())
			.append("proveedor", producto.getProveedor().getObjectId());
		
		coleccion.insertOne(documento);
	}
}
