package ethazi.intefaz.paneles;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;

public class PanelPerfilCandidato extends JPanel {
	private JTextField txField_nombre;
	private JTextField txField_fechaNac;
	private JTextField txField_dni;
	private JTextField txField_apellidos;
	private JTextField txField_direccion;
	private JTextField txField_email;
	private JTextField txField_telefono;
	private JTextField txField_estudios;
	private JTextField txField_otrosConoc;
	private JTextField txField_experiencia;
	private JTextField txField_vidaLaboral;

	/**
	 * Create the panel.
	 */
	public PanelPerfilCandidato() {
		setPreferredSize(new Dimension(762, 488));
		setLayout(null);

		JLabel lbl_nombre = new JLabel("Nombre:");
		lbl_nombre.setBounds(38, 65, 46, 14);
		add(lbl_nombre);

		txField_nombre = new JTextField();
		txField_nombre.setEditable(false);
		txField_nombre.setBounds(38, 79, 142, 20);
		add(txField_nombre);
		txField_nombre.setColumns(10);

		txField_fechaNac = new JTextField();
		txField_fechaNac.setEditable(false);
		txField_fechaNac.setColumns(10);
		txField_fechaNac.setBounds(38, 124, 108, 20);
		add(txField_fechaNac);

		JLabel lbl_fechaNac = new JLabel("Fecha de nacimiento:");
		lbl_fechaNac.setBounds(38, 110, 114, 14);
		add(lbl_fechaNac);

		txField_dni = new JTextField();
		txField_dni.setEditable(false);
		txField_dni.setColumns(10);
		txField_dni.setBounds(375, 79, 102, 20);
		add(txField_dni);

		JLabel lbl_dni = new JLabel("DNI:");
		lbl_dni.setBounds(375, 65, 46, 14);
		add(lbl_dni);

		txField_apellidos = new JTextField();
		txField_apellidos.setEditable(false);
		txField_apellidos.setColumns(10);
		txField_apellidos.setBounds(190, 79, 175, 20);
		add(txField_apellidos);

		JLabel lbl_apellidos = new JLabel("Apellidos:");
		lbl_apellidos.setBounds(190, 65, 46, 14);
		add(lbl_apellidos);

		txField_direccion = new JTextField();
		txField_direccion.setEditable(false);
		txField_direccion.setColumns(10);
		txField_direccion.setBounds(190, 124, 231, 20);
		add(txField_direccion);

		JLabel lbl_direccion = new JLabel("Direcion:");
		lbl_direccion.setBounds(190, 110, 86, 14);
		add(lbl_direccion);

		JList lista_conocimientos = new JList();
		lista_conocimientos.setBorder(UIManager.getBorder("TextField.border"));
		lista_conocimientos.setBounds(349, 245, 141, 178);
		add(lista_conocimientos);

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

		JLabel lbl_estudios = new JLabel("Estudios:");
		lbl_estudios.setBounds(38, 230, 86, 14);
		add(lbl_estudios);

		txField_estudios = new JTextField();
		txField_estudios.setEditable(false);
		txField_estudios.setColumns(10);
		txField_estudios.setBounds(38, 244, 286, 59);
		add(txField_estudios);

		JLabel lbl_otrosConoc = new JLabel("Otros conocimientos:");
		lbl_otrosConoc.setBounds(38, 314, 114, 14);
		add(lbl_otrosConoc);

		txField_otrosConoc = new JTextField();
		txField_otrosConoc.setEditable(false);
		txField_otrosConoc.setColumns(10);
		txField_otrosConoc.setBounds(38, 328, 286, 59);
		add(txField_otrosConoc);

		JLabel lbl_conocimientos = new JLabel("Conocimientos:");
		lbl_conocimientos.setBounds(349, 230, 114, 14);
		add(lbl_conocimientos);

		txField_experiencia = new JTextField();
		txField_experiencia.setEditable(false);
		txField_experiencia.setColumns(10);
		txField_experiencia.setBounds(658, 230, 52, 20);
		add(txField_experiencia);

		JLabel lbl_experiencia = new JLabel("A\u00F1os de experiencia laboral:");
		lbl_experiencia.setBounds(513, 233, 157, 14);
		add(lbl_experiencia);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 210, 762, 18);
		add(separator);

		JLabel lbl_vidaLaboral = new JLabel("Vida laboral:");
		lbl_vidaLaboral.setBounds(38, 398, 114, 14);
		add(lbl_vidaLaboral);

		txField_vidaLaboral = new JTextField();
		txField_vidaLaboral.setEditable(false);
		txField_vidaLaboral.setColumns(10);
		txField_vidaLaboral.setBounds(38, 412, 286, 59);
		add(txField_vidaLaboral);

		JCheckBox chckbxCarneDeConducir = new JCheckBox("Carne de conducir");
		chckbxCarneDeConducir.setBounds(549, 78, 131, 23);
		add(chckbxCarneDeConducir);

		JCheckBox chckbxCochePropio = new JCheckBox("Coche propio");
		chckbxCochePropio.setBounds(549, 106, 131, 23);
		add(chckbxCochePropio);

		JCheckBox chckbxDisponibleParaViajes = new JCheckBox("Disponible para viajes ");
		chckbxDisponibleParaViajes.setBounds(549, 135, 161, 23);
		add(chckbxDisponibleParaViajes);
	}
}
