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
import ethazi.aplicacion.Usuario;
import ethazi.datos.Conexion;
import ethazi.datos.Tablas;
import ethazi.datos.UtilidadesBD;
import ethazi.excepciones.NoQuedanFilas;
import ethazi.excepciones.ResultSetVacio;
import ethazi.intefaz.emergentes.RecuperarContrasena;
import ethazi.intefaz.frame.VentanaIdentificarse;
import ethazi.intefaz.frame.VentanaPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Dimension;

/**
 * 
 * @author Eduardo
 *
 */
public class PanelIdentificarse extends JPanel {
	/**
	 * This panel is used by the user to identify as Candidato or Empresa.
	 */

	private static final long serialVersionUID = 1L;
	private static JPasswordField pssField_contrasena;
	private static JTextField txField_usuario;
	private JLabel lbl_contrasenaErronea;
	JButton btn_entrar;

	public PanelIdentificarse() {
		setName("Identificarse");
		this.setLayout(null);

		lbl_contrasenaErronea = new JLabel("Credenciales Incorrectas");
		lbl_contrasenaErronea.setForeground(new Color(128, 0, 0));
		lbl_contrasenaErronea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_contrasenaErronea.setBounds(84, 23, 141, 14);
		lbl_contrasenaErronea.setVisible(false);
		add(lbl_contrasenaErronea);

		JLabel lbl_usuario = new JLabel("Usuario:");
		lbl_usuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_usuario.setBounds(84, 48, 189, 14);
		add(lbl_usuario);

		JLabel lbl_contrasena = new JLabel("Contraseña:");
		lbl_contrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_contrasena.setBounds(84, 103, 189, 14);
		this.add(lbl_contrasena);

		JButton btn_registrarse = new JButton("Registrarse");
		btn_registrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_contrasenaErronea.setVisible(false);
				limpiarTextos();
				VentanaIdentificarse.getPa_identificarse().setVisible(false);
				VentanaIdentificarse.getSelect().setVisible(true);
				VentanaIdentificarse.cambiarTam(new Dimension(600, 600));
			}
		});
		btn_registrarse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_registrarse.setBounds(85, 204, 126, 23);
		this.add(btn_registrarse);

		btn_entrar = new JButton("Entrar");
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (validarUsuario()) {
						VentanaIdentificarse.cerrar();
						VentanaPrincipal.ejecutar();
					} else {
						lbl_contrasenaErronea.setVisible(true);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					limpiarTextos();
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
		pssField_contrasena.setText("");
		this.add(pssField_contrasena);

		txField_usuario = new JTextField();
		txField_usuario.setText("");
		txField_usuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		txField_usuario.setColumns(10);
		txField_usuario.setBackground(new Color(255, 239, 213));
		txField_usuario.setBounds(85, 74, 126, 20);
		this.add(txField_usuario);

		JLabel lbl_recuperarContrasena = new JLabel("Recuperar contraseña");
		lbl_recuperarContrasena.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_recuperarContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lbl_contrasenaErronea.setVisible(false);
				limpiarTextos();
				RecuperarContrasena.crearVentana(VentanaIdentificarse.getPa_identificarse().getParent());
			}
			//5
		});
		lbl_recuperarContrasena.setForeground(Color.BLUE);
		lbl_recuperarContrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_recuperarContrasena.setBounds(84, 144, 189, 14);
		this.add(lbl_recuperarContrasena);
		pssField_contrasena.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_entrar.doClick();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.out.println("ds");
				}
			}

			public void keyReleased(KeyEvent e) {
			}
 
			public void keyTyped(KeyEvent e) {
			}
		});
		txField_usuario.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_entrar.doClick();
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.out.println("ds");
				}
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyTyped(KeyEvent e) {
			}
		});
	}

	private static boolean validarUsuario() throws SQLException {
		boolean _esValido;
		String _nick = txField_usuario.getText();
		String _pass = String.valueOf(pssField_contrasena.getPassword());
		ResultSet _usuario;
		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + " WHERE " + Tablas.C_USUARIO_NICK
				+ "='" + _nick + "' AND " + Tablas.C_USUARIO_PASSWORD + "='" + _pass + "';");

		if (_rs.next()) {
			if (Usuario.esCandidato(_nick, true)) {
				_usuario = Conexion.consultar("SELECT * FROM " + Tablas.C_CANDIDATO_TABLA + ", "
						+ Tablas.C_USUARIO_TABLA + " WHERE " + Tablas.C_CANDIDATO_NUMID + "=" + Tablas.C_USUARIO_NUMID
						+ " AND " + Tablas.C_USUARIO_NICK + "='" + _nick + "';");
			} else {
				_usuario = Conexion.consultar("SELECT * FROM " + Tablas.C_EMPRESA_TABLA + ", " + Tablas.C_USUARIO_TABLA
						+ " WHERE " + Tablas.C_EMPRESA_NUMID + "=" + Tablas.C_USUARIO_NUMID + " AND "
						+ Tablas.C_USUARIO_NICK + "='" + _nick + "';");
			}
			try {
				Aplicacion.setUsuario(UtilidadesBD.toUsuario(_usuario));
			} catch (ResultSetVacio e) {
				System.out.println("No existe ese usuario");
			} catch (NoQuedanFilas e) {
			}
			_esValido = true;
		} else {
			_esValido = false;
		}
		return _esValido;
	}

	private static void limpiarTextos() {
		txField_usuario.setText("");
		pssField_contrasena.setText("");
	}

}
