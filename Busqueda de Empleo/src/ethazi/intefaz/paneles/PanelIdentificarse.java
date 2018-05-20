package ethazi.intefaz.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ethazi.aplicacion.Aplicacion;
import ethazi.intefaz.emergentes.RecuperarContrasena;
import ethazi.intefaz.frame.VentanaIdentificarse;
import ethazi.intefaz.frame.VentanaPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelIdentificarse extends JPanel {
	private JPasswordField pssField_contrasena;
	private JTextField txField_usuario;

	/**
	 * Create the panel.
	 */
	public PanelIdentificarse() {
		this.setLayout(null);

		JLabel lbl_usuario = new JLabel("Usuario:");
		lbl_usuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_usuario.setBounds(84, 48, 189, 14);
		add(lbl_usuario);

		JLabel lbl_contrasena = new JLabel("Contraseña:");
		lbl_contrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_contrasena.setBounds(84, 103, 189, 14);
		this.add(lbl_contrasena);

		JButton btn_registrarse = new JButton("Registrarse");
		btn_registrarse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_registrarse.setBounds(85, 204, 126, 23);
		this.add(btn_registrarse);

		JButton btn_entrar = new JButton("Entrar");
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Buscar usuario
				try {
					ResultSet _consulta = Aplicacion.getConexion().consultar("SELECT password FROM usuario WHERE nick='"+txField_usuario.getText()+"';");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				// Confirmar usuario
				if (true) { // METER CONFIRMACION EN VEZ DE TRUE
				// Aplicacion.setUsuario(usuario);
					VentanaIdentificarse.cerrar();
					VentanaPrincipal.ejecutar(); 
				}
			}
		});
		btn_entrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_entrar.setBounds(84, 170, 126, 23);
		this.add(btn_entrar);

		pssField_contrasena = new JPasswordField();
		pssField_contrasena.setText("contraseña");
		pssField_contrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		pssField_contrasena.setBackground(new Color(255, 239, 213));
		pssField_contrasena.setBounds(84, 125, 126, 20);
		this.add(pssField_contrasena);

		txField_usuario = new JTextField();
		txField_usuario.setText("Introduce el nombre de usuario");
		txField_usuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		txField_usuario.setColumns(10);
		txField_usuario.setBackground(new Color(255, 239, 213));
		txField_usuario.setBounds(85, 74, 189, 20);
		this.add(txField_usuario);

		JLabel lbl_recuperarContrasena = new JLabel("Recuperar contraseña");
		lbl_recuperarContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RecuperarContrasena.crearVentana(this);
			}
		});
		lbl_recuperarContrasena.setForeground(Color.BLUE);
		lbl_recuperarContrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_recuperarContrasena.setBounds(84, 144, 189, 14);
		this.add(lbl_recuperarContrasena);

		JLabel lbl_contrasenaErronea = new JLabel("(Contraseña incorrecta)");
		lbl_contrasenaErronea.setForeground(new Color(128, 0, 0));
		lbl_contrasenaErronea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_contrasenaErronea.setBounds(219, 129, 141, 14);
		this.add(lbl_contrasenaErronea);

		JLabel lbl_usuarioErroneo = new JLabel("(Usuario incorrecto)");
		lbl_usuarioErroneo.setForeground(new Color(128, 0, 0));
		lbl_usuarioErroneo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_usuarioErroneo.setBounds(283, 79, 141, 14);
		this.add(lbl_usuarioErroneo);
	}

}
