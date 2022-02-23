package inventarioapp.vista;

import javax.swing.JPanel;

import inventarioapp.controlador.ControladorFacturas;
import inventarioapp.modelo.Factura;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaListaFacturas extends JPanel {
	private ControladorFacturas controlador;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public VistaListaFacturas(ControladorFacturas controlador) {
		this.controlador = controlador;
		
		JLabel lblListaDeFacturas = new JLabel("Lista de facturas");
		lblListaDeFacturas.setFont(lblListaDeFacturas.getFont().deriveFont(lblListaDeFacturas.getFont().getStyle() | Font.BOLD, lblListaDeFacturas.getFont().getSize() + 5f));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblListaDeFacturas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblListaDeFacturas, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Numero", "Cliente", "Productos", "Subtotal", "Valor total"
			}
		));
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		
		cargarFacturas();
	}
	
	private void cargarFacturas() {
		List<Factura> facturas = controlador.getFacturasDao().getFacturas();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		modelo.setRowCount(0);
		
		for (Factura factura : facturas) {
			modelo.addRow(new Object[] {
				String.format("%08d", factura.getNumero()),
				factura.getCliente().getNombre(),
				factura.getElementos().size(),
				String.format("$%.2f", factura.getSubtotal()),
				String.format("$%.2f", factura.getTotal())
			});
		}
	}

}
