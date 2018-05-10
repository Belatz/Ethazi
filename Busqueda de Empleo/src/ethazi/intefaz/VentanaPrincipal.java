package ethazi.intefaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdEfeafa;
	private JTextField txtIntroduceElNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("Usuario:");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser.setBounds(159, 50, 135, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(159, 106, 135, 14);
		contentPane.add(lblPassword);
		
		JButton btnRegisttrarse = new JButton("Registrarse");
		btnRegisttrarse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegisttrarse.setBounds(160, 205, 134, 23);
		contentPane.add(btnRegisttrarse);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ha hecho click en Entrar");
			}
		});
		btnEntrar.setBounds(159, 171, 135, 23);
		//btnEntrar.setBorder(new RoundedBorder(40)); 
		contentPane.add(btnEntrar);
		
		pwdEfeafa = new JPasswordField();
		pwdEfeafa.setBackground(new Color(255, 239, 213));
		pwdEfeafa.setText("contrase\u00F1a");
		pwdEfeafa.setBounds(159, 126, 135, 20);
		contentPane.add(pwdEfeafa);
		
		txtIntroduceElNombre = new JTextField();
		txtIntroduceElNombre.setBackground(new Color(255, 239, 213));
		txtIntroduceElNombre.setText("Introduce el nombre de usuario");
		txtIntroduceElNombre.setBounds(159, 75, 177, 20);
		contentPane.add(txtIntroduceElNombre);
		txtIntroduceElNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Recuperar contrase\u00F1a");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//-----------------------------------------------------------------------
			}
		});
		lblNewLabel.setBounds(159, 146, 135, 14);
		contentPane.add(lblNewLabel);
	}
}
