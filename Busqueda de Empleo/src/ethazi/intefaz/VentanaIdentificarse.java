package ethazi.intefaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;

public class VentanaIdentificarse extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txField_usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIdentificarse frame = new VentanaIdentificarse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaIdentificarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel pa_identificarse = new JPanel();
		contentPane.add(pa_identificarse, "name_101526810166436");
		pa_identificarse.setLayout(null);
		
		JLabel lbl_usuario = new JLabel("Usuario:");
		lbl_usuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_usuario.setBounds(183, 114, 135, 14);
		pa_identificarse.add(lbl_usuario);
		
		JLabel lbl_contrasena = new JLabel("Contrase\u00F1a:");
		lbl_contrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_contrasena.setBounds(176, 157, 135, 14);
		pa_identificarse.add(lbl_contrasena);
		
		JButton btn_registrarse = new JButton("Registrarse");
		btn_registrarse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_registrarse.setBounds(142, 276, 134, 23);
		pa_identificarse.add(btn_registrarse);
		
		JButton btn_entrar = new JButton("Entrar");
		btn_entrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_entrar.setBounds(141, 242, 135, 23);
		pa_identificarse.add(btn_entrar);
		
		passwordField = new JPasswordField();
		passwordField.setText("contrase\u00F1a");
		passwordField.setBackground(new Color(255, 239, 213));
		passwordField.setBounds(143, 175, 135, 20);
		pa_identificarse.add(passwordField);
		
		txField_usuario = new JTextField();
		txField_usuario.setText("Introduce el nombre de usuario");
		txField_usuario.setColumns(10);
		txField_usuario.setBackground(new Color(255, 239, 213));
		txField_usuario.setBounds(126, 131, 177, 20);
		pa_identificarse.add(txField_usuario);
		
		JLabel lbl_recuperarContra = new JLabel("Recuperar contrase\u00F1a");
		lbl_recuperarContra.setForeground(Color.BLUE);
		lbl_recuperarContra.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_recuperarContra.setBounds(145, 196, 135, 14);
		pa_identificarse.add(lbl_recuperarContra);
	}
}
