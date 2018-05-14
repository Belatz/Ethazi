package ethazi.intefaz;

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

public class RegistroCandidato extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	String mensaje = "¿Estas seguro?";

	/**
	 * Create the panel.
	 */
	public RegistroCandidato() {
		setLayout(null);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setBounds(10, 70, 111, 14);
		add(lblNombreDeUsuario);

		JLabel lblContrasea = new JLabel("Contrasena:");
		lblContrasea.setBounds(320, 70, 74, 14);
		add(lblContrasea);

		JLabel lblCorreoElectronico = new JLabel("Correo electronico:");
		lblCorreoElectronico.setBounds(10, 193, 111, 14);
		add(lblCorreoElectronico);

		JLabel lblNewLabel = new JLabel("Registro del Candidato");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(188, 11, 278, 24);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 111, 94, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setBounds(320, 111, 46, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Direccion:");
		lblNewLabel_3.setBounds(10, 149, 58, 14);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Telefono:");
		lblNewLabel_4.setBounds(320, 193, 46, 14);
		add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(116, 68, 136, 17);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(404, 68, 136, 17);
		add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 108, 136, 17);
		add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(404, 108, 136, 17);
		add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(116, 147, 424, 17);
		add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(116, 191, 181, 17);
		add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(404, 190, 136, 17);
		add(textField_6);

		JLabel lblConocimientosTotales = new JLabel("Conocimientos totales:");
		lblConocimientosTotales.setBounds(10, 242, 124, 14);
		add(lblConocimientosTotales);

		String[] conocimientos = { "", "Java", "C", "C#", "C++", "Javascript", "CSS", "XML", "HTML", "XQuery" };

		JComboBox<Object> comboBox = new JComboBox<Object>(conocimientos);
		comboBox.setEditable(true);
		comboBox.setToolTipText("");
		comboBox.setBounds(126, 237, 119, 24);
		add(comboBox);

		JTextArea txtrConocimientos = new JTextArea();
		txtrConocimientos.setBounds(293, 262, 247, 146);
		add(txtrConocimientos);

		JLabel lblConocimientos = new JLabel("Lista de conocimientos:");
		lblConocimientos.setBounds(293, 242, 173, 14);
		add(lblConocimientos);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 229, 530, 2);
		add(separator);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 516, 46, 14);
		add(lblApellidos);

		textField_7 = new JTextField();
		textField_7.setBounds(116, 513, 136, 20);
		add(textField_7);
		textField_7.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_5.setBounds(10, 560, 102, 14);
		add(lblNewLabel_5);

		textField_8 = new JTextField();
		textField_8.setBounds(116, 557, 136, 20);
		add(textField_8);
		textField_8.setColumns(10);

		JLabel lblEstudios = new JLabel("Vida laboral:");
		lblEstudios.setBounds(10, 601, 74, 14);
		add(lblEstudios);

		textField_9 = new JTextField();
		textField_9.setBounds(116, 598, 136, 20);
		add(textField_9);
		textField_9.setColumns(10);

		JLabel lblOtrosConocimientos = new JLabel("Otros conocimientos:");
		lblOtrosConocimientos.setBounds(293, 438, 136, 14);
		add(lblOtrosConocimientos);

		JLabel lblVidaLaboral = new JLabel("Estudios:");
		lblVidaLaboral.setBounds(10, 643, 74, 14);
		add(lblVidaLaboral);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(116, 640, 424, 20);
		add(textField_11);

		JButton button = new JButton("+");
		button.setBounds(243, 237, 46, 24);
		add(button);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(293, 463, 247, 146);
		add(textArea);

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

		JLabel lblCarnetDeConducir = new JLabel("Carnet de conducir");
		lblCarnetDeConducir.setBounds(10, 394, 102, 14);
		add(lblCarnetDeConducir);

		JLabel lblCochePropio = new JLabel("Coche propio");
		lblCochePropio.setBounds(10, 433, 74, 14);
		add(lblCochePropio);

		JLabel lblDisponibilidadParaViajar = new JLabel("Disponibilidad para viajar");
		lblDisponibilidadParaViajar.setBounds(10, 468, 136, 14);
		add(lblDisponibilidadParaViajar);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarse.setBounds(416, 710, 124, 29);
		add(btnRegistrarse);
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane aux = new JOptionPane();
				JDialog d = aux.createDialog(null, mensaje);
				d.setVisible(true);
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane aux = new JOptionPane();
				JDialog d = aux.createDialog(null, mensaje);
				d.setVisible(true);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(29, 710, 124, 29);
		add(btnCancelar);
	}
}
