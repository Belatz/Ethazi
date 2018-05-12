package ethazi.intefaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import sun.security.util.Password;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class VentanaIdentificarse extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwd_contrasena;
	private JTextField txLabel_nombre;
	private JTextField txtNombregmailcom;
	private JTextField txtIntroduceElCodigo;
	public static VentanaIdentificarse frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaIdentificarse();
					frame.setVisible(true);
					frame.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							frame.txLabel_nombre.setText("Introduce el nombre de usuario");
							frame.pwd_contrasena.setText("Contrasena");
						}
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame Identificarse.
	 */
	public VentanaIdentificarse() {
		setTitle("Identificarse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_ususario = new JLabel("Usuario:");
		lbl_ususario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_ususario.setBounds(84, 49, 189, 14);
		contentPane.add(lbl_ususario);

		JLabel lbl_contrasena = new JLabel("Contrase\u00F1a:");
		lbl_contrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_contrasena.setBounds(84, 105, 189, 14);
		contentPane.add(lbl_contrasena);

		JButton btn_registrarse = new JButton("Registrarse");
		btn_registrarse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_registrarse.setBounds(85, 204, 126, 23);
		contentPane.add(btn_registrarse);

		JButton btn_entrar = new JButton("Entrar");
		btn_entrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ha hecho click en Entrar");
			}
		});
		btn_entrar.setBounds(84, 170, 126, 23);
		contentPane.add(btn_entrar);

		pwd_contrasena = new JPasswordField();
		pwd_contrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		pwd_contrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pwd_contrasena.setText("");
			}
		});
		pwd_contrasena.setBackground(new Color(255, 239, 213));
		pwd_contrasena.setText("contrase\u00F1a");
		pwd_contrasena.setBounds(84, 125, 126, 20);
		contentPane.add(pwd_contrasena);

		txLabel_nombre = new JTextField();
		txLabel_nombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		txLabel_nombre.setText("Introduce el nombre de usuario");
		txLabel_nombre.setBackground(new Color(255, 239, 213));
		txLabel_nombre.setBounds(84, 74, 189, 20);
		contentPane.add(txLabel_nombre);
		txLabel_nombre.setColumns(10);

		txLabel_nombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txLabel_nombre.setText("");
			}
		});

		JLabel lbl_recuperarContrasena = new JLabel("Recuperar contrase\u00F1a");
		lbl_recuperarContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//RecuperarContrasena.setVisible(true);
			}
		});
		lbl_recuperarContrasena.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_recuperarContrasena.setForeground(Color.BLUE);
		lbl_recuperarContrasena.setBounds(84, 145, 189, 14);
		contentPane.add(lbl_recuperarContrasena);

		JLabel lbl_contrasenaErronea = new JLabel("(Contrase\u00F1a incorrecta)");
		lbl_contrasenaErronea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_contrasenaErronea.setForeground(new Color(128, 0, 0));
		lbl_contrasenaErronea.setBounds(220, 130, 141, 14);
		contentPane.add(lbl_contrasenaErronea);

		JLabel lbl_usuarioErroneo = new JLabel("(Usuario incorrecto)");
		lbl_usuarioErroneo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_usuarioErroneo.setForeground(new Color(128, 0, 0));
		lbl_usuarioErroneo.setBounds(283, 78, 141, 14);
		contentPane.add(lbl_usuarioErroneo);
	}
	/**
	 * Create the frame Recuperar Contrasena.
	 */
	public void RecuperarContrasena() {
		setTitle("Recuperar contrase\u00F1a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoIncorrecto = new JLabel("(Correo incorrecto)");
		lblCdigoIncorrecto.setForeground(new Color(139, 0, 0));
		lblCdigoIncorrecto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdigoIncorrecto.setBounds(242, 72, 133, 14);
		contentPane.add(lblCdigoIncorrecto);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(57, 72, 46, 14);
		contentPane.add(lblEmail);
		
		txtNombregmailcom = new JTextField();
		txtNombregmailcom.setBackground(new Color(255, 239, 213));
		txtNombregmailcom.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNombregmailcom.setText("nombre@gmail.com");
		txtNombregmailcom.setBounds(98, 69, 133, 20);
		contentPane.add(txtNombregmailcom);
		txtNombregmailcom.setColumns(10);
		
		JButton btnEnivar = new JButton("Enviar");
		btnEnivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEnivar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnivar.setBounds(120, 112, 74, 23);
		contentPane.add(btnEnivar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(218, 173, 74, 23);
		contentPane.add(btnVolver);
	}
	/**
	 * Create the frame Validar Codigo.
	 */
	public void ValidarCodigo() {
		setTitle("Validar c\u00F3digo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(75, 103, 46, 14);
		contentPane.add(lblNewLabel);

		txtIntroduceElCodigo = new JTextField();
		txtIntroduceElCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtIntroduceElCodigo.setText("Introduce el c\u00F3digo");
		txtIntroduceElCodigo.setBackground(new Color(255, 239, 213));
		txtIntroduceElCodigo.setBounds(131, 100, 142, 20);
		contentPane.add(txtIntroduceElCodigo);
		txtIntroduceElCodigo.setColumns(10);

		txtIntroduceElCodigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtIntroduceElCodigo.setText("");
			}
		});

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(112, 146, 89, 23);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Cerramos la ventana Validar Codigo
				setVisible(false);
				//Abrimos la ventana identificarse
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(211, 146, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblcdigoIncorrecto = new JLabel("(C\u00F3digo incorrecto)");
		lblcdigoIncorrecto.setForeground(new Color(139, 0, 0));
		lblcdigoIncorrecto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblcdigoIncorrecto.setBounds(291, 103, 133, 14);
		contentPane.add(lblcdigoIncorrecto);
	}
}
