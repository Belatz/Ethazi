package ethazi.intefaz.paneles;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JSeparator;

public class PanelPerfilEmpresa extends JPanel {
	private JTextField txField_nombre;
	private JTextField txField_dni;
	private JTextField txField_apellidos;
	private JTextField txField_direccion;
	private JTextField txField_email;
	private JTextField txField_telefono;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelPerfilEmpresa() {
		setPreferredSize(new Dimension(762, 488));
		setLayout(null);
		
		JLabel lbl_nombre = new JLabel("Nombre:");
		lbl_nombre.setBounds(38, 65, 46, 14);
		add(lbl_nombre);
		
		txField_nombre = new JTextField();
		txField_nombre.setEditable(false);
		txField_nombre.setBounds(38, 79, 190, 20);
		add(txField_nombre);
		txField_nombre.setColumns(10);
		
		txField_dni = new JTextField();
		txField_dni.setEditable(false);
		txField_dni.setColumns(10);
		txField_dni.setBounds(423, 79, 102, 20);
		add(txField_dni);
		
		JLabel lbl_dni = new JLabel("CIF:");
		lbl_dni.setBounds(423, 65, 46, 14);
		add(lbl_dni);
		
		txField_apellidos = new JTextField();
		txField_apellidos.setEditable(false);
		txField_apellidos.setColumns(10);
		txField_apellidos.setBounds(238, 79, 175, 20);
		add(txField_apellidos);
		
		JLabel lbl_apellidos = new JLabel("Contacto:");
		lbl_apellidos.setBounds(238, 65, 86, 14);
		add(lbl_apellidos);
		
		txField_direccion = new JTextField();
		txField_direccion.setEditable(false);
		txField_direccion.setColumns(10);
		txField_direccion.setBounds(38, 124, 231, 20);
		add(txField_direccion);
		
		JLabel lbl_direccion = new JLabel("Direcion:");
		lbl_direccion.setBounds(38, 110, 86, 14);
		add(lbl_direccion);
		
		JLabel lbl_nick = new JLabel("Nick del usuario");
		lbl_nick.setFont(new Font("Tahoma", Font.BOLD, 23));
		lbl_nick.setBounds(284, 11, 221, 30);
		add(lbl_nick);
		
		JLabel lbl_email = new JLabel("Correo electronico:");
		lbl_email.setBounds(38, 155, 114, 14);
		add(lbl_email);
		
		txField_email = new JTextField();
		txField_email.setEditable(false);
		txField_email.setColumns(10);
		txField_email.setBounds(38, 169, 142, 20);
		add(txField_email);
		
		JLabel lbl_telefono = new JLabel("Telefono:");
		lbl_telefono.setBounds(190, 155, 86, 14);
		add(lbl_telefono);
		
		txField_telefono = new JTextField();
		txField_telefono.setEditable(false);
		txField_telefono.setColumns(10);
		txField_telefono.setBounds(190, 169, 102, 20);
		add(txField_telefono);
		
		JLabel lbl_conocimientos = new JLabel("Ofertas:");
		lbl_conocimientos.setBounds(38, 227, 114, 14);
		add(lbl_conocimientos);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 210, 762, 18);
		add(separator);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(349, 110, 86, 14);
		add(lblDescripcion);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(349, 124, 231, 65);
		add(textField);
		textField.setColumns(10);
	}
}
