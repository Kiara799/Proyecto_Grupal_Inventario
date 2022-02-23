package inventarioapp.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.concurrent.Callable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inventarioapp.dao.UsuariosDao;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {
	private JPanel contentPane;
	private UsuariosDao usuariosDao;
	private Runnable retrollamada;
	private JTextField txtfUsuario;
	private JPasswordField txtfPassword;

	/**
	 * Create the frame.
	 */
	public VentanaLogin(UsuariosDao usuariosDao) {
		setResizable(false);
		this.usuariosDao = usuariosDao;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 319);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ESPE");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		
		txtfUsuario = new JTextField();
		txtfUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		
		txtfPassword = new JPasswordField();
		txtfPassword.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBorderPainted(false);
		btnIngresar.setBackground(new Color(0, 191, 255));
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setVisible(false);
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBorderPainted(false);
		btnRegistrarse.setBackground(new Color(0, 128, 128));
		
		JLabel lblLogo = new JLabel("");
		
		try {
			lblLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Logo_ESPE.png")));
		} catch (Exception e) {}
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnIngresar)
							.addGap(18)
							.addComponent(btnRegistrarse))
						.addComponent(txtfUsuario, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(txtfPassword, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtfUsuario, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtfPassword, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnIngresar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRegistrarse, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void alIngresar(Runnable retrollamada) {
		this.retrollamada = retrollamada;
	}
	
	private void ingresar() {
		String usuario = txtfUsuario.getText().trim();
		String password = txtfPassword.getText();
		
		if (usuario.isBlank()) {
			txtfUsuario.grabFocus();
			return;
		}
		
		if (password.isEmpty()) {
			txtfPassword.grabFocus();
			return;
		}
		
		if (usuariosDao.login(usuario, password)) {
			retrollamada.run();
		} else {
			JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
		}
	}
}
