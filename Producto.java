package inventarioapp.modelo;

import org.bson.types.ObjectId;

/**
 *
 * @author
 */
public class Producto {
	private ObjectId objectId;
	private String codigo;
    private String nombre;
    private double precio;
    private String tipo;
    private Proveedor proveedor;
    
	public Producto(String codigo, String nombre, double precio, String tipo, Proveedor proveedor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
		this.proveedor = proveedor;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}
}
