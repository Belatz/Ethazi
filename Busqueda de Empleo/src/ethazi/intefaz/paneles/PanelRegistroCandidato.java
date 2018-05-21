package ethazi.intefaz.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Urtzi
 *
 */

public class PanelRegistroCandidato extends JPanel {
	private JTextField txFieldNombreUsuario;
	private JTextField txFieldContrasena;
	private JTextField txFieldNombre;
	private JTextField txFieldDNI;
	private JTextField txFieldDireccion;
	private JTextField txFieldEmail;
	private JTextField txFieldTelefono;
	private JTextField txFieldApellidos;
	private JTextField txFieldFechaNacimiento;
	private JTextField txFieldVidaLaboral;
	private JTextField txFieldEstudios;
	String mensaje = "¿Estas seguro?";

	/**
	 * The panel RegistroCandidato will show the facts that the user will have to
	 * fill, so he can register as a Candidato.
	 * 
	 */
	
	public PanelRegistroCandidato() {
		setLayout(null);

		JLabel lbl_NombreDeUsuario = new JLabel("Nombre de Usuario:");
		lbl_NombreDeUsuario.setBounds(10, 70, 111, 14);
		add(lbl_NombreDeUsuario);

		JLabel lbl_Contrasea = new JLabel("Contrasena:");
		lbl_Contrasea.setBounds(320, 70, 74, 14);
		add(lbl_Contrasea);

		JLabel lbl_CorreoElectronico = new JLabel("Correo electronico:");
		lbl_CorreoElectronico.setBounds(10, 193, 111, 14);
		add(lbl_CorreoElectronico);

		JLabel lbl_titulo = new JLabel("Registro del Candidato");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_titulo.setBounds(188, 11, 278, 24);
		add(lbl_titulo);

		JLabel lbl_Nombre = new JLabel("Nombre:");
		lbl_Nombre.setBounds(10, 111, 94, 14);
		add(lbl_Nombre);

		JLabel lbl_DNI = new JLabel("DNI:");
		lbl_DNI.setBounds(320, 111, 46, 14);
		add(lbl_DNI);

		JLabel lbl_Direccion = new JLabel("Direccion:");
		lbl_Direccion.setBounds(10, 149, 58, 14);
		add(lbl_Direccion);

		JLabel lbl_Telefono = new JLabel("Telefono:");
		lbl_Telefono.setBounds(320, 193, 46, 14);
		add(lbl_Telefono);

		txFieldNombreUsuario = new JTextField();
		txFieldNombreUsuario.setEditable(false);
		txFieldNombreUsuario.setBounds(116, 68, 136, 17);
		add(txFieldNombreUsuario);
		txFieldNombreUsuario.setColumns(10);

		txFieldContrasena = new JTextField();
		txFieldContrasena.setEditable(false);
		txFieldContrasena.setColumns(10);
		txFieldContrasena.setBounds(404, 68, 136, 17);
		add(txFieldContrasena);

		txFieldNombre = new JTextField();
		txFieldNombre.setEditable(false);
		txFieldNombre.setColumns(10);
		txFieldNombre.setBounds(116, 108, 136, 17);
		add(txFieldNombre);

		txFieldDNI = new JTextField();
		txFieldDNI.setEditable(false);
		txFieldDNI.setColumns(10);
		txFieldDNI.setBounds(404, 108, 136, 17);
		add(txFieldDNI);

		txFieldDireccion = new JTextField();
		txFieldDireccion.setEditable(false);
		txFieldDireccion.setColumns(10);
		txFieldDireccion.setBounds(116, 147, 424, 17);
		add(txFieldDireccion);

		txFieldEmail = new JTextField();
		txFieldEmail.setEditable(false);
		txFieldEmail.setColumns(10);
		txFieldEmail.setBounds(116, 191, 181, 17);
		add(txFieldEmail);

		txFieldTelefono = new JTextField();
		txFieldTelefono.setEditable(false);
		txFieldTelefono.setColumns(10);
		txFieldTelefono.setBounds(404, 190, 136, 17);
		add(txFieldTelefono);

		JLabel lbl_ConocimientosTotales = new JLabel("Conocimientos:");
		lbl_ConocimientosTotales.setBounds(10, 242, 124, 14);
		add(lbl_ConocimientosTotales);

		String[] conocimientos = { "", "Java", "C", "C#", "C++", "Javascript", "CSS", "XML", "HTML", "XQuery" };

		JComboBox<Object> comboBox = new JComboBox<Object>(conocimientos);
		comboBox.setEditable(true);
		comboBox.setToolTipText("");
		comboBox.setBounds(126, 237, 119, 24);
		add(comboBox);

		JLabel lbl_Conocimientos = new JLabel("Lista de conocimientos:");
		lbl_Conocimientos.setBounds(293, 242, 173, 14);
		add(lbl_Conocimientos);

		JLabel lbl_Apellidos = new JLabel("Apellidos:");
		lbl_Apellidos.setBounds(10, 516, 46, 14);
		add(lbl_Apellidos);

		txFieldApellidos = new JTextField();
		txFieldApellidos.setEditable(false);
		txFieldApellidos.setBounds(116, 513, 136, 20);
		add(txFieldApellidos);
		txFieldApellidos.setColumns(10);

		JLabel lbl_FechaNacimiento = new JLabel("Fecha de nacimiento:");
		lbl_FechaNacimiento.setBounds(10, 560, 102, 14);
		add(lbl_FechaNacimiento);

		txFieldFechaNacimiento = new JTextField();
		txFieldFechaNacimiento.setEditable(false);
		txFieldFechaNacimiento.setBounds(116, 557, 136, 20);
		add(txFieldFechaNacimiento);
		txFieldFechaNacimiento.setColumns(10);

		JLabel lbl_Estudios = new JLabel("Vida laboral:");
		lbl_Estudios.setBounds(10, 601, 74, 14);
		add(lbl_Estudios);

		txFieldVidaLaboral = new JTextField();
		txFieldVidaLaboral.setEditable(false);
		txFieldVidaLaboral.setBounds(116, 598, 424, 20);
		add(txFieldVidaLaboral);
		txFieldVidaLaboral.setColumns(10);

		JLabel lbl_OtrosConocimientos = new JLabel("Otros conocimientos:");
		lbl_OtrosConocimientos.setBounds(293, 438, 136, 14);
		add(lbl_OtrosConocimientos);

		JLabel lbl_VidaLaboral = new JLabel("Estudios:");
		lbl_VidaLaboral.setBounds(10, 643, 74, 14);
		add(lbl_VidaLaboral);

		txFieldEstudios = new JTextField();
		txFieldEstudios.setEditable(false);
		txFieldEstudios.setColumns(10);
		txFieldEstudios.setBounds(116, 640, 424, 20);
		add(txFieldEstudios);

		JButton button = new JButton("+");
		button.setBounds(243, 237, 46, 24);
		add(button);

		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(160, 391, 38, 23);
		add(rdbtnSi);

		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(220, 391, 46, 23);
		add(rdbtnNo);

		JRadioButton radioButton = new JRadioButton("Si");
		radioButton.setBounds(160, 429, 38, 23);
		add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("Si");
		radioButton_1.setBounds(160, 464, 38, 23);
		add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("No");
		radioButton_2.setBounds(220, 429, 46, 23);
		add(radioButton_2);

		JRadioButton radioButton_3 = new JRadioButton("No");
		radioButton_3.setBounds(220, 464, 46, 23);
		add(radioButton_3);

		JLabel lbl_CarnetDeConducir = new JLabel("Carnet de conducir");
		lbl_CarnetDeConducir.setBounds(10, 394, 102, 14);
		add(lbl_CarnetDeConducir);

		JLabel lbl_CochePropio = new JLabel("Coche propio");
		lbl_CochePropio.setBounds(10, 433, 74, 14);
		add(lbl_CochePropio);

		JLabel lbl_DisponibilidadParaViajar = new JLabel("Disponibilidad para viajar");
		lbl_DisponibilidadParaViajar.setBounds(10, 468, 136, 14);
		add(lbl_DisponibilidadParaViajar);

		JButton btn_Registrarse = new JButton("Registrarse");
		btn_Registrarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Registrarse.setBounds(416, 710, 124, 29);
		add(btn_Registrarse);
		btn_Registrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane aux = new JOptionPane();
				JDialog d = aux.createDialog(null, mensaje);
				d.setVisible(true);
			}
		});

		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane aux = new JOptionPane();
				JDialog d = aux.createDialog(null, mensaje);
				d.setVisible(true);
			}
		});
		btn_Cancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_Cancelar.setBounds(29, 710, 124, 29);
		add(btn_Cancelar);
	}
}
