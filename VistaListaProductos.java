package inventarioapp.vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import inventarioapp.controlador.ControladorProductos;
import inventarioapp.modelo.Producto;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaListaProductos extends JPanel {
	private ControladorProductos controlador;
	private JTable tblProductos;
	/**
	 * Create the panel.
	 */
	public VistaListaProductos(ControladorProductos controlador) {
		this.controlador = controlador;
		
		JLabel lblListaDeProductos = new JLabel("Lista de productos");
		lblListaDeProductos.setFont(lblListaDeProductos.getFont().deriveFont(lblListaDeProductos.getFont().getStyle() | Font.BOLD, lblListaDeProductos.getFont().getSize() + 5f));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblListaDeProductos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblListaDeProductos, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblProductos = new JTable();
		tblProductos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Nombre", "Precio", "Tipo", "Proveedor"
			}
		));
		scrollPane.setViewportView(tblProductos);
		setLayout(groupLayout);
		
		cargarProductos();
	}
	
	public void cargarProductos() {
		List<Producto> productos = controlador.getProductosDao().getProductos();
		DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
		
		modelo.setRowCount(0);
		
		for (Producto producto : productos) {
			modelo.addRow(new Object[] {
				producto.getCodigo(),
				producto.getNombre(),
				String.format("$%.2f", producto.getPrecio()),
				producto.getTipo().toString(),
				producto.getProveedor().getNombre()
			});
		}
	}
}
