package inventarioapp.vista;

import javax.swing.JPanel;

import inventarioapp.controlador.ControladorFacturas;
import inventarioapp.modelo.Factura;
import inventarioapp.modelo.FacturaElemento;
import inventarioapp.modelo.Persona;
import inventarioapp.modelo.Producto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaAgregarFactura extends JPanel {
	private ControladorFacturas controlador;
	private JTextField txtfNombre;
	private JTextField txtfCedula;
	private JTextField txtfDireccion;
	private JTable tblProductos;
	private JComboBox<ComboBoxProductoItem> cmbxProductos;
	private JSpinner spnCantidad;
	private List<FacturaElemento> elementosFactura = new ArrayList<>();
	
	/**
	 * Create the panel.
	 */
	public VistaAgregarFactura(ControladorFacturas controlador) {
		this.controlador = controlador;
		
		JLabel lblAgregarNuevaFactura = new JLabel("Agregar nueva factura");
		lblAgregarNuevaFactura.setFont(lblAgregarNuevaFactura.getFont().deriveFont(lblAgregarNuevaFactura.getFont().getStyle() | Font.BOLD, lblAgregarNuevaFactura.getFont().getSize() + 5f));
		
		JLabel lblNewLabel = new JLabel("Datos del cliente");
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize() + 1f));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		
		txtfNombre = new JTextField();
		txtfNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cedula:");
		
		txtfCedula = new JTextField();
		txtfCedula.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion");
		
		txtfDireccion = new JTextField();
		txtfDireccion.setColumns(10);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(lblProductos.getFont().deriveFont(lblProductos.getFont().getStyle() | Font.BOLD, lblProductos.getFont().getSize() + 1f));
		
		cmbxProductos = new JComboBox();
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(100, 10));
		panel.setMaximumSize(new Dimension(100, 32767));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAgregarFactura = new JButton("Agregar factura");
		btnAgregarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarFactura();
			}
		});
		
		JButton btnEliminarProductos = new JButton("Eliminar producto(s) seleccionado(s)");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtfNombre, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblAgregarNuevaFactura, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)))
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addContainerGap(575, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtfCedula, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addContainerGap(569, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtfDireccion, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblProductos, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(510, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(cmbxProductos, 0, 411, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(292, Short.MAX_VALUE)
					.addComponent(btnEliminarProductos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAgregarFactura)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblAgregarNuevaFactura)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtfNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtfCedula, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtfDireccion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblProductos, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cmbxProductos, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregarFactura)
						.addComponent(btnEliminarProductos))
					.addContainerGap())
		);
		
		tblProductos = new JTable();
		tblProductos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Cantidad", "Precio unidad", "Precio Total"
			}
		));
		scrollPane.setViewportView(tblProductos);
		
		spnCantidad = new JSpinner();
		spnCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnCantidad.setPreferredSize(new Dimension(60, 20));
		panel.add(spnCantidad);
		
		JButton btnAgregarProducto = new JButton("Agregar");
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarElementoFactura();
			}
		});
		panel.add(btnAgregarProducto);
		setLayout(groupLayout);
		
		cargarProductos();
	}
	
	public void cargarProductos() {
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) cmbxProductos.getModel();
		List<Producto> productos = controlador.getProductosDao().getProductos();
		
		modelo.removeAllElements();
		
		for (Producto producto : productos) {
			modelo.addElement(new ComboBoxProductoItem(producto));
		}
	}
	
	private void agregarElementoFactura() {
		if (cmbxProductos.getSelectedIndex() == -1) {
			return;
		}
		
		Producto producto = ((ComboBoxProductoItem) cmbxProductos.getSelectedItem()).getProducto();
		int cantidad = (int) spnCantidad.getValue();
		
		elementosFactura.add(new FacturaElemento(producto, cantidad));
		actualizarTablaFactura();
	}
	
	private void actualizarTablaFactura() {
		DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
		
		modelo.setRowCount(0);
		
		for (FacturaElemento elemento : elementosFactura) {
			double precioUnitario = elemento.getProducto().getPrecio();
			double precioTotal = precioUnitario * elemento.getCantidad();
			
			modelo.addRow(new Object[] {
				elemento.getProducto().getCodigo(),
				elemento.getProducto().getNombre(),
				elemento.getCantidad(),
				String.format("$%.2f", precioUnitario),
				String.format("$%.2f", precioTotal)
			});
		}
	}
	
	private void agregarFactura() {
		String nombre = txtfNombre.getText();
		String cedula = txtfCedula.getText();
		String direccion = txtfDireccion.getText();
		
		if (nombre.isBlank()) {
			JOptionPane.showInternalMessageDialog(null, "Debes ingresar el nombre");
			return;
		}
		
		if (cedula.isBlank()) {
			JOptionPane.showInternalMessageDialog(null, "Debes ingresar la cedula");
			return;
		}
		
		if (direccion.isBlank()) {
			JOptionPane.showInternalMessageDialog(null, "Debes ingresar la direccion");
			return;
		}
		
		if (elementosFactura.isEmpty()) {
			JOptionPane.showInternalMessageDialog(null, "Debes agregar productos a la factura");
			return;
		}
		
		Persona cliente = new Persona(nombre, cedula, direccion);
		Factura factura = new Factura(0, cliente, 12);
		
		for (FacturaElemento elemento : elementosFactura) {
			factura.agregarElemento(elemento);
		}
		
		controlador.getFacturasDao().agregarFactura(factura);
		JOptionPane.showMessageDialog(null, "Factura agregada");
		
		txtfNombre.setText("");
		txtfCedula.setText("");
		txtfDireccion.setText("");
		elementosFactura.clear();
		actualizarTablaFactura();
	}
	
	private class ComboBoxProductoItem extends DefaultComboBoxModel {
		private Producto producto;
		
		public ComboBoxProductoItem(Producto producto) {
			this.producto = producto;
		}
		
		public Producto getProducto() {
			return producto;
		}
		
		@Override
		public String toString() {
			return producto.getNombre();
		}
	}
}
