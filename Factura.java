package inventarioapp.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class Factura {
    private int numero;
    private Persona cliente;
    private float iva;
    private List<FacturaElemento> elementos = new ArrayList<>();
    
    public Factura(int numero, Persona cliente, float iva) {
        this.numero = numero;
        this.cliente = cliente;
        this.iva = iva;
    }
    
    public void agregarElemento(FacturaElemento elemento) {
        elementos.add(elemento);
    }
    
    public float getTotal() {
        float subtotal = getSubtotal();
        float impuesto = subtotal * iva / 100;
        float total = subtotal + impuesto;
        
        return total;
    }
    
    public float getSubtotal() {
        float subtotal = 0;
        
        for (FacturaElemento elemento : elementos) {
            subtotal += (elemento.getProducto().getPrecio() * elemento.getCantidad());
        }
        
        return subtotal;
    }
    
    public int getNumero() {
        return numero;
    }

    public Persona getCliente() {
        return cliente;
    }
    
    public float getIva() {
        return iva;
    }
    
    public List<FacturaElemento> getElementos() {
        return elementos;
    }
}
