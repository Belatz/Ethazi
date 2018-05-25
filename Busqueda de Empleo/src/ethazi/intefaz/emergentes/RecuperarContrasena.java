package ethazi.intefaz.emergentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ethazi.intefaz.frame.VentanaPrincipal;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class RecuperarContrasena extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txField_correo;
	private static RecuperarContrasena dialog;

	/**
	 * Launch the application.
	 */
	public static void crearVentana(Container p_padre) {
		try {
			VentanaPrincipal.desHabVentana(false, p_padre);
			dialog = new RecuperarContrasena(p_padre);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RecuperarContrasena(Container p_padre) {
		setTitle("Introduzca su correo");
		setBounds(100, 100, 432, 186);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lbl_correoErroneo = new JLabel("Correo incorrecto");
			lbl_correoErroneo.setVisible(false);
			lbl_correoErroneo.setBounds(290, 60, 109, 14);
			contentPanel.add(lbl_correoErroneo);
			lbl_correoErroneo.setForeground(new Color(139, 0, 0));
			lbl_correoErroneo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
			JLabel lbl_email = new JLabel("Email:");
			lbl_email.setBounds(46, 60, 33, 14);
			contentPanel.add(lbl_email);
			lbl_email.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
			txField_correo = new JTextField();
			txField_correo.setBounds(89, 56, 195, 22);
			contentPanel.add(txField_correo);
			txField_correo.setText("");
			txField_correo.setFont(new Font("Tahoma", Font.BOLD, 11));
			txField_correo.setColumns(10);
			txField_correo.setBackground(new Color(255, 239, 213));
		
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_enviar = new JButton("Enviar");
				btn_enviar.setActionCommand("OK");
				buttonPane.add(btn_enviar);
				getRootPane().setDefaultButton(btn_enviar);
				btn_enviar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//TODO comprobar q el email sea válido y si lo es....
					VentanaPrincipal.desHabVentana(true, p_padre);
					dialog.removeAll();
					dialog.setVisible(false);
					//TODO si el email no es válido....
					lbl_correoErroneo.setVisible(true);
					}
				});
			}
			
				JButton btn_cancelar = new JButton("Cancelar");
				btn_cancelar.setActionCommand("Cancel");
				buttonPane.add(btn_cancelar);
				btn_cancelar.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						VentanaPrincipal.desHabVentana(true, p_padre);
						dialog.removeAll();
						dialog.setVisible(false);
					}
				});
					addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						VentanaPrincipal.desHabVentana(true, p_padre);
					}
				});
			
		}

}
