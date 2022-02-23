package inventarioapp.vista;

import javax.swing.JPanel;

import inventarioapp.controlador.ControladorProveedores;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import inventarioapp.modelo.Proveedor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaAgregarProveedor extends JPanel {
	private ControladorProveedores controlador;
	private JTextField txtfNombre;
	private JComboBox cmbxPais;
	private JComboBox cmbxTipo;
	
	/**
	 * Create the panel.
	 */
	public VistaAgregarProveedor(ControladorProveedores controlador) {
		this.controlador = controlador;
		
		JLabel lblAgregarUnNuevo = new JLabel("Agregar un nuevo proveedor");
		lblAgregarUnNuevo.setFont(lblAgregarUnNuevo.getFont().deriveFont(lblAgregarUnNuevo.getFont().getStyle() | Font.BOLD, lblAgregarUnNuevo.getFont().getSize() + 5f));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		
		txtfNombre = new JTextField();
		txtfNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pais:");
		
		cmbxPais = new JComboBox();
		cmbxPais.setModel(new DefaultComboBoxModel(new String[] {"Afganist\u00E1n", "Akrotiri", "Albania", "Alemania", "Andorra", "Angola", "Anguila", "Ant\u00E1rtida", "Antigua y Barbuda", "Arabia Saud\u00ED", "Arctic Ocean", "Argelia", "Argentina", "Armenia", "Aruba", "Ashmore and Cartier Islands", "Atlantic Ocean", "Australia", "Austria", "Azerbaiy\u00E1n", "Bahamas", "Bahr\u00E1in", "Bangladesh", "Barbados", "B\u00E9lgica", "Belice", "Ben\u00EDn", "Bermudas", "Bielorrusia", "Birmania; Myanmar", "Bolivia", "Bosnia y Hercegovina", "Botsuana", "Brasil", "Brun\u00E9i", "Bulgaria", "Burkina Faso", "Burundi", "But\u00E1n", "Cabo Verde", "Camboya", "Camer\u00FAn", "Canad\u00E1", "Chad", "Chile", "China", "Chipre", "Clipperton Island", "Colombia", "Comoras", "Congo", "Coral Sea Islands", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Curacao", "Dhekelia", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador", "El Vaticano", "Emiratos \u00C1rabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "Espa\u00F1a", "Estados Unidos", "Estonia", "Etiop\u00EDa", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gab\u00F3n", "Gambia", "Gaza Strip", "Georgia", "Ghana", "Gibraltar", "Granada", "Grecia", "Groenlandia", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea Ecuatorial", "Guinea-Bissau", "Guyana", "Hait\u00ED", "Honduras", "Hong Kong", "Hungr\u00EDa", "India", "Indian Ocean", "Indonesia", "Ir\u00E1n", "Iraq", "Irlanda", "Isla Bouvet", "Isla Christmas", "Isla Norfolk", "Islandia", "Islas Caim\u00E1n", "Islas Cocos", "Islas Cook", "Islas Feroe", "Islas Georgia del Sur y Sandwich del Sur", "Islas Heard y McDonald", "Islas Malvinas", "Islas Marianas del Norte", "Islas Marshall", "Islas Pitcairn", "Islas Salom\u00F3n", "Islas Turcas y Caicos", "Islas V\u00EDrgenes Americanas", "Islas V\u00EDrgenes Brit\u00E1nicas", "Israel", "Italia", "Jamaica", "Jan Mayen", "Jap\u00F3n", "Jersey", "Jordania", "Kazajist\u00E1n", "Kenia", "Kirguizist\u00E1n", "Kiribati", "Kosovo", "Kuwait", "Laos", "Lesoto", "Letonia", "L\u00EDbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Macao", "Macedonia", "Madagascar", "Malasia", "Malaui", "Maldivas", "Mal\u00ED", "Malta", "Man, Isle of", "Marruecos", "Mauricio", "Mauritania", "M\u00E9xico", "Micronesia", "Moldavia", "M\u00F3naco", "Mongolia", "Montenegro", "Montserrat", "Mozambique", "Mundo", "Namibia", "Nauru", "Navassa Island", "Nepal", "Nicaragua", "N\u00EDger", "Nigeria", "Niue", "Noruega", "Nueva Caledonia", "Nueva Zelanda", "Om\u00E1n", "Pacific Ocean", "Pa\u00EDses Bajos", "Pakist\u00E1n", "Palaos", "Panam\u00E1", "Pap\u00FAa-Nueva Guinea", "Paracel Islands", "Paraguay", "Per\u00FA", "Polinesia Francesa", "Polonia", "Portugal", "Puerto Rico", "Qatar", "Reino Unido", "Rep\u00FAblica Centroafricana", "Rep\u00FAblica Democr\u00E1tica del Congo", "Rep\u00FAblica Dominicana", "Ruanda", "Rumania", "Rusia", "S\u00E1hara Occidental", "Samoa", "Samoa Americana", "San Bartolom\u00E9", "San Crist\u00F3bal y Nieves", "San Marino", "San Mart\u00EDn", "San Pedro y Miquel\u00F3n", "San Vicente y las Granadinas", "Santa Helena", "Santa Luc\u00EDa", "Santo Tom\u00E9 y Pr\u00EDncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur", "Sint Maarten", "Siria", "Somalia", "Southern Ocean", "Spratly Islands", "Sri Lanka", "Suazilandia", "Sud\u00E1frica", "Sud\u00E1n", "Sud\u00E1n del Sur", "Suecia", "Suiza", "Surinam", "Svalbard y Jan Mayen", "Tailandia", "Taiw\u00E1n", "Tanzania", "Tayikist\u00E1n", "Territorio Brit\u00E1nico del Oc\u00E9ano Indico", "Territorios Australes Franceses", "Timor Oriental", "Togo", "Tokelau", "Tonga", "Trinidad y Tobago", "T\u00FAnez", "Turkmenist\u00E1n", "Turqu\u00EDa", "Tuvalu", "Ucrania", "Uganda", "Uni\u00F3n Europea", "Uruguay", "Uzbekist\u00E1n", "Vanuatu", "Venezuela", "Vietnam", "Wake Island", "Wallis y Futuna", "West Bank", "Yemen", "Yibuti", "Zambia", "Zimbabue"}));
		
		JLabel lblNewLabel_3 = new JLabel("Tipo:");
		
		cmbxTipo = new JComboBox();
		cmbxTipo.setModel(new DefaultComboBoxModel(Proveedor.Tipo.values()));
		
		JButton btnNewButton = new JButton("Agregar proveedor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarProveedor();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cmbxTipo, 0, 430, Short.MAX_VALUE)
						.addComponent(cmbxPais, 0, 430, Short.MAX_VALUE)
						.addComponent(txtfNombre, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblAgregarUnNuevo, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(btnNewButton, Alignment.TRAILING))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAgregarUnNuevo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtfNombre, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cmbxPais, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cmbxTipo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	public void agregarProveedor() {
		String nombre = txtfNombre.getText();
		String pais = cmbxPais.getSelectedItem().toString();
		Proveedor.Tipo tipo = (Proveedor.Tipo) cmbxTipo.getSelectedItem();
		
		Proveedor proveedor = new Proveedor(nombre, pais, tipo);
		controlador.getProveedoresDao().agregarProveedor(proveedor);
		JOptionPane.showMessageDialog(null, "proveedor agregado");
		
		txtfNombre.setText("");
		cmbxPais.setSelectedIndex(0);
		cmbxTipo.setSelectedIndex(0);
	}
}
