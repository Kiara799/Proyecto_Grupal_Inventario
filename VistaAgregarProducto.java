package inventarioapp.vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import inventarioapp.controlador.ControladorProductos;
import inventarioapp.modelo.Producto;
import inventarioapp.modelo.Proveedor;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VistaAgregarProducto extends JPanel {
	private JTextField txtfCodigo;
	private JTextField txtfNombre;
	private JTextField txtfPrecio;
	private ControladorProductos controlador;
	private JComboBox cmbxTipo;
	private JComboBox<ComboBoxProveedorItem> cmbxProveedor;
	
	/**
	 * Create the panel.
	 */
	public VistaAgregarProducto(ControladorProductos controlador) {
		this.controlador = controlador;
		
		JLabel lblNewLabel = new JLabel("Agregar un nuevo producto");
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize() + 5f));
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		
		txtfCodigo = new JTextField();
		txtfCodigo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		
		txtfNombre = new JTextField();
		txtfNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Precio:");
		
		txtfPrecio = new JTextField();
		txtfPrecio.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo:");
		
		cmbxTipo = new JComboBox();
		cmbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Consumo", "Electrodomesticos", "Deporte"}));
		
		JLabel lblNewLabel_6 = new JLabel("Proveedor:");
		
		cmbxProveedor = new JComboBox();
		
		JButton btnAgregar = new JButton("Agregar producto");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarProducto();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtfCodigo, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(txtfNombre, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtfPrecio, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(btnAgregar, Alignment.TRAILING)
						.addComponent(cmbxProveedor, 0, 430, Short.MAX_VALUE)
						.addComponent(cmbxTipo, 0, 430, Short.MAX_VALUE)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_6))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtfCodigo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtfNombre, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtfPrecio, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cmbxTipo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cmbxProveedor, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
					.addComponent(btnAgregar)
					.addContainerGap())
		);
		setLayout(groupLayout);
		
		cargarProveedores();
	}
	
	private void cargarProveedores() {
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) cmbxProveedor.getModel();
		modelo.removeAllElements();
		
		List<Proveedor> proveedores = controlador.getProveedoresDao().getProveedores();
		
		for(Proveedor proveedor : proveedores) {
			modelo.addElement(new ComboBoxProveedorItem(proveedor));
		}
	}
	
	private void agregarProducto() {
		String codigo = txtfCodigo.getText().trim();
		String nombre = txtfNombre.getText().trim();
		String precioStr = txtfPrecio.getText().trim();
		String tipo = cmbxTipo.getSelectedItem().toString();
		double precio;
		
		if (codigo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El codigo es necesario");
			return;
		}
		
		if (nombre.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El nombre es necesario");
			return;
		}
		
		if (precioStr.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El precio es necesario");
			return;
		}
		
		try {
			precio = Double.parseDouble(precioStr);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "El precio es invalido");
			return;
		}
		
		if (cmbxProveedor.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "El proveedor es necesario");
			return;
		}
		
		Proveedor proveedor = ((ComboBoxProveedorItem)cmbxProveedor.getSelectedItem()).getProveedor();
		Producto producto = new Producto(codigo, nombre, precio, tipo, proveedor);
		controlador.getProductosDao().guardarProducto(producto);
		JOptionPane.showMessageDialog(null, "Producto guardado");
		
		txtfCodigo.setText("");
		txtfNombre.setText("");
		txtfPrecio.setText("");
		cmbxTipo.setSelectedIndex(0);
		cmbxProveedor.setSelectedIndex(0);
	}
	
	private class ComboBoxProveedorItem extends DefaultComboBoxModel {
		private Proveedor proveedor;
		
		public ComboBoxProveedorItem(Proveedor proveedor) {
			this.proveedor = proveedor;
		}
		
		public Proveedor getProveedor() {
			return proveedor;
		}
		
		@Override
		public String toString() {
			return proveedor.getNombre();
		}
	}
}
