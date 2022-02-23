package inventarioapp.vista;

import javax.swing.JPanel;

import inventarioapp.controlador.ControladorProveedores;
import inventarioapp.modelo.Proveedor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class VistaListaProveedores extends JPanel {
	private ControladorProveedores controlador;
	private JTable tblProveedores;
	
	/**
	 * Create the panel.
	 */
	public VistaListaProveedores(ControladorProveedores controlador) {
		this.controlador = controlador;
		
		JLabel lblNewLabel = new JLabel("Lista de proveedores");
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize() + 5f));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblProveedores = new JTable();
		tblProveedores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Pais", "Tipo"
			}
		));
		scrollPane.setViewportView(tblProveedores);
		setLayout(groupLayout);
		
		cargarProveedores();
	}
	
	private void cargarProveedores() {
		DefaultTableModel modelo = (DefaultTableModel) tblProveedores.getModel();
		List<Proveedor> proveedores = controlador.getProveedoresDao().getProveedores();
		
		modelo.setRowCount(0);
		
		for (Proveedor proveedor : proveedores) {
			modelo.addRow(new Object[] {
				proveedor.getNombre(),
				proveedor.getPais(),
				proveedor.getTipo().toString()
			});
		}
	}
}
