package ethazi.intefaz.paneles;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.util.Hashtable;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAbrirOfertaEmpresa extends JPanel {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 */
	public PanelAbrirOfertaEmpresa() {
		setLayout(null);

		JLabel lblOferta = new JLabel("Oferta");
		lblOferta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOferta.setBounds(363, 11, 59, 17);
		add(lblOferta);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(46, 39, 438, 36);
		add(textArea);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(46, 86, 73, 14);
		add(lblDescripcion);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(46, 105, 669, 150);
		add(textArea_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(46, 266, 669, 2);
		add(separator);

		JLabel lblConocimientosTotales = new JLabel("Conocimientos:");
		lblConocimientosTotales.setBounds(46, 281, 84, 14);
		add(lblConocimientosTotales);

		String[] conocimientos = { "", "Java", "C", "C#", "C++", "Javascript", "CSS", "XML", "HTML", "XQuery" };

		JComboBox<Object> comboBox = new JComboBox<Object>(conocimientos);
		comboBox.setEditable(true);
		comboBox.setToolTipText("");
		comboBox.setBounds(172, 276, 211, 24);
		add(comboBox);

		JLabel lblCodigoDeOferta = new JLabel("Codigo de oferta:");
		lblCodigoDeOferta.setBounds(409, 281, 91, 14);
		add(lblCodigoDeOferta);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(538, 279, 177, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(409, 446, 38, 14);
		add(lblLugar);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(538, 443, 177, 20);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblTipoDeContrato = new JLabel("Tipo de contrato:");
		lblTipoDeContrato.setBounds(409, 312, 91, 14);
		add(lblTipoDeContrato);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(538, 310, 177, 20);
		add(textField_2);

		JLabel lblSueldoMaximo = new JLabel("Sueldo maximo:");
		lblSueldoMaximo.setBounds(46, 312, 84, 14);
		add(lblSueldoMaximo);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(172, 311, 211, 20);
		add(textField_3);

		JLabel lblSueldoMinimo = new JLabel("Sueldo minimo:");
		lblSueldoMinimo.setBounds(409, 347, 84, 14);
		add(lblSueldoMinimo);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(538, 345, 177, 20);
		add(textField_4);

		JLabel lblExperiencia = new JLabel("Experiencia:");
		lblExperiencia.setBounds(46, 374, 73, 17);
		add(lblExperiencia);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(172, 372, 543, 20);
		add(textField_5);
		textField_5.setColumns(10);

		JLabel lblAspectosAValorar = new JLabel("Aspectos a valorar:");
		lblAspectosAValorar.setBounds(46, 415, 94, 14);
		add(lblAspectosAValorar);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(172, 412, 211, 20);
		add(textField_6);

		JLabel lblAspectosImprescindibles = new JLabel("Aspectos imprescindibles:");
		lblAspectosImprescindibles.setBounds(46, 446, 125, 14);
		add(lblAspectosImprescindibles);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(172, 443, 211, 20);
		add(textField_7);
		textField_7.setColumns(10);

		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(409, 415, 46, 14);
		add(lblEmpresa);

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(538, 412, 177, 20);
		add(textField_8);
		textField_8.setColumns(10);

		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setBounds(483, 40, 78, 35);
		add(btnNewButton);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(559, 40, 78, 35);
		add(btnEliminar);

		// Icono de visible/invisible
		JButton btnuddudc = new JButton("\uD83D\uDC40");
		btnuddudc.setBounds(634, 40, 80, 35);
		add(btnuddudc);
	}

	// Intento de dejar los ojos tachados, pero no funciona
	public void paint(Graphics g) {
		Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
		Font font = new Font(Font.SERIF, Font.PLAIN, 24);
		map.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		font = font.deriveFont(map);
		g.setFont(font);
		g.drawString("btnuddudc", 45, 120);
	}
}
