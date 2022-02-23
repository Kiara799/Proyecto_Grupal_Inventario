package inventarioapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import inventarioapp.core.Dao;
import inventarioapp.modelo.Proveedor;
import inventarioapp.modelo.Proveedor.Tipo;

public class ProveedoresDao extends Dao {
	private MongoCollection<Document> coleccion = getDatabase().getCollection("proveedores");
	
	public List<Proveedor> getProveedores() {
		List<Proveedor> proveedores = new ArrayList<>();
		FindIterable<Document> iterable = coleccion.find();
		
		iterable.forEach((Document documento) -> {
			String nombre = documento.getString("nombre");
			String pais = documento.getString("pais");
			Proveedor.Tipo tipo = Proveedor.Tipo.valueOf(documento.getString("tipo"));
			
			Proveedor proveedor = new Proveedor(nombre, pais, tipo);
			proveedor.setObjectId(documento.getObjectId("_id"));
			proveedores.add(proveedor);
		});
		
		return proveedores;
	}
	
	public void agregarProveedor(Proveedor proveedor) {
		Document documento = new Document("nombre", proveedor.getNombre())
			.append("pais", proveedor.getPais())
			.append("tipo", proveedor.getTipo().toString());
		coleccion.insertOne(documento);
	}
	
	public Proveedor getProveedor(ObjectId id) {
		Document documento = coleccion.find(new Document("_id", id)).first();
		
		if (documento == null) {
			return null;
		}
		
		String nombre = documento.getString("nombre");
		String pais = documento.getString("pais");
		Proveedor.Tipo tipo = Proveedor.Tipo.valueOf(documento.getString("tipo"));
		
		Proveedor proveedor = new Proveedor(nombre, pais, tipo);
		return proveedor;
	}
}
