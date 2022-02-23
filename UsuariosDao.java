package inventarioapp.dao;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import inventarioapp.core.Dao;
import inventarioapp.modelo.Usuario;

public class UsuariosDao extends Dao {
	private MongoCollection<Document> coleccion = getDatabase().getCollection("usuarios");
	
	public UsuariosDao() {
		crearAdmin();
	}
	
	public boolean login(String nombre, String password) {
		Document doc = coleccion.find(new Document("nombre", nombre)).first();
		
		if (doc == null) {
			return false;
		}
		
		return doc.getString("password").equals(password);
	}
	
	public void registrarUsuario(Usuario usuario) {
		coleccion.insertOne(new Document("nombre", usuario.getNombre()).append("password", usuario.getPassword()));
	}
	
	private void crearAdmin() {
		Document doc = coleccion.find(new Document("nombre", "admin")).first();
		
		if (doc == null) {
			coleccion.insertOne(new Document("nombre", "admin").append("password", "admin"));
		}
	}
}
