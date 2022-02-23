package inventarioapp.modelo;

import org.bson.types.ObjectId;

public class Proveedor {
	public static enum Tipo {
		Mayorista,
		Minorista
	}

	private ObjectId objectId;
	private String nombre;
	private String pais;
	private Tipo tipo;
	
	public Proveedor(String nombre, String pais, Tipo tipo) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}
}
