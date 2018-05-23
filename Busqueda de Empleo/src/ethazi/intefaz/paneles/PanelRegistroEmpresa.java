package ethazi.intefaz.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The panel RegistroEmpresa will show the data that the user will have to
 * fill, so he can register as a Empresa.
 * @author Xabi
 *
 */

public class PanelRegistroEmpresa extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	public PanelRegistroEmpresa() {
		setLayout(null);

		JLabel lblNombreDeUsuario = new JLabel("Nick:");
		lblNombreDeUsuario.setBounds(10, 70, 111, 14);
		add(lblNombreDeUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(210, 70, 74, 14);
		add(lblContrasea);

		JLabel lblCorreoElectronico = new JLabel("Correo electr\u00F3nico:");
		lblCorreoElectronico.setBounds(10, 145, 111, 14);
		add(lblCorreoElectronico);

		JLabel lblNewLabel = new JLabel("Registrar una empresa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(133, 11, 278, 24);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre completo de la empresa:");
		lblNewLabel_1.setBounds(10, 95, 165, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CIF:");
		lblNewLabel_2.setBounds(378, 95, 46, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_3.setBounds(10, 120, 58, 14);
		add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(35, 68, 165, 17);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(275, 68, 265, 17);
		add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(169, 95, 199, 17);
		add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(404, 93, 136, 17);
		add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(60, 120, 480, 17);
		add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(108, 143, 230, 17);
		add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(404, 143, 136, 17);
		add(textField_6);

		JLabel lblNewLabel_6 = new JLabel("Persona contacto:");
		lblNewLabel_6.setBounds(10, 170, 94, 14);
		add(lblNewLabel_6);

		textField_7 = new JTextField();
		textField_7.setBounds(98, 170, 191, 20);
		add(textField_7);
		textField_7.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion de la empresa:");
		lblDescripcion.setBounds(10, 193, 148, 14);
		add(lblDescripcion);

		textField_8 = new JTextField();
		textField_8.setBounds(10, 218, 530, 121);
		add(textField_8);
		textField_8.setColumns(10);

		JButton btnRegistarEmpresa = new JButton("Registrar empresa");
		btnRegistarEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistarEmpresa.setBounds(386, 350, 154, 23);
		add(btnRegistarEmpresa);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(348, 145, 46, 14);
		add(lblTelefono);

	}
}