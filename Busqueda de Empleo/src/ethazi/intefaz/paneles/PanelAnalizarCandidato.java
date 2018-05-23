package ethazi.intefaz.paneles;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

public class PanelAnalizarCandidato extends JPanel {
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

	public PanelAnalizarCandidato() {
		setLayout(null);

		JLabel lblCandidatoSeleccionado = new JLabel("Candidato seleccionado:");
		lblCandidatoSeleccionado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandidatoSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblCandidatoSeleccionado.setBounds(212, 11, 397, 55);
		add(lblCandidatoSeleccionado);

		JSeparator separator = new JSeparator();
		separator.setBounds(21, 60, 731, 2);
		add(separator);

		JButton button = new JButton("<---");
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(23, 454, 67, 23);
		add(button);

		JButton btnNewButton = new JButton("Guardar CV");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(587, 442, 150, 23);
		add(btnNewButton);

		JLabel lblNick = new JLabel("Nick:");
		lblNick.setBounds(31, 82, 37, 14);
		add(lblNick);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(57, 79, 185, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(31, 125, 46, 14);
		add(lblNombre);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(78, 122, 237, 20);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblDireccionPostal = new JLabel("Direccion postal:");
		lblDireccionPostal.setBounds(31, 162, 93, 14);
		add(lblDireccionPostal);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(117, 159, 598, 20);
		add(textField_2);
		textField_2.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(31, 197, 46, 14);
		add(lblEmail);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(67, 194, 445, 20);
		add(textField_3);
		textField_3.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(537, 197, 46, 14);
		add(lblTelefono);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(587, 194, 128, 20);
		add(textField_4);
		textField_4.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(325, 125, 46, 14);
		add(lblApellidos);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(371, 122, 344, 20);
		add(textField_5);
		textField_5.setColumns(10);

		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(262, 82, 93, 14);
		add(lblFechaNacimiento);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(352, 79, 111, 20);
		add(textField_6);
		textField_6.setColumns(10);

		JLabel lblEstudios = new JLabel("Estudios:");
		lblEstudios.setBounds(31, 238, 46, 14);
		add(lblEstudios);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(78, 235, 460, 20);
		add(textField_7);
		textField_7.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(565, 254, 150, 2);
		add(separator_1);

		JLabel lblOtrosDatosDe = new JLabel("Otros datos de interes:");
		lblOtrosDatosDe.setBounds(587, 238, 140, 14);
		add(lblOtrosDatosDe);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Carne de conducir");
		chckbxNewCheckBox.setEnabled(false);
		chckbxNewCheckBox.setBounds(587, 263, 128, 23);
		add(chckbxNewCheckBox);

		JCheckBox chckbxCochePropio = new JCheckBox("Coche propio");
		chckbxCochePropio.setEnabled(false);
		chckbxCochePropio.setBounds(587, 289, 97, 23);
		add(chckbxCochePropio);

		JCheckBox chckbxDisponibilidadGeografica = new JCheckBox("Disponibilidad geografica");
		chckbxDisponibilidadGeografica.setEnabled(false);
		chckbxDisponibilidadGeografica.setBounds(587, 315, 150, 23);
		add(chckbxDisponibilidadGeografica);

		JLabel lblVidaLaboral = new JLabel("Vida laboral:");
		lblVidaLaboral.setBounds(31, 324, 59, 14);
		add(lblVidaLaboral);

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(99, 266, 216, 134);
		add(textField_8);
		textField_8.setColumns(10);

		JLabel lblOtrosConocimientos = new JLabel("Otros conocimientos:");
		lblOtrosConocimientos.setBounds(31, 429, 111, 14);
		add(lblOtrosConocimientos);

		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBounds(136, 411, 445, 66);
		add(textField_9);
		textField_9.setColumns(10);

		JLabel lblConocimientos = new JLabel("Conocimientos:");
		lblConocimientos.setBounds(325, 319, 79, 14);
		add(lblConocimientos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(402, 369, 140, -101);
		add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(402, 266, 166, 134);
		add(scrollPane_1);

		JLabel label = new JLabel("Experiencia profesional:");
		label.setBounds(497, 82, 128, 14);
		add(label);

		JTextField textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setToolTipText("Volver");
		textField_10.setColumns(10);
		textField_10.setBounds(614, 79, 37, 20);
		add(textField_10);

		JLabel lblAos = new JLabel("a\u00F1os");
		lblAos.setBounds(653, 82, 46, 14);
		add(lblAos);
	}
}
