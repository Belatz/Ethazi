package ethazi.intefaz.paneles;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class PanelPublicarOferta extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public PanelPublicarOferta() {
		setPreferredSize(new Dimension(762,488));
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 52, 46, 14);
		add(lblTitulo);
		
		textField = new JTextField();
		textField.setBounds(51, 49, 322, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPublicarOferta = new JLabel("Nueva Oferta");
		lblPublicarOferta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPublicarOferta.setBounds(309, 11, 172, 20);
		add(lblPublicarOferta);
		
		JLabel lblSueldoMinimo = new JLabel("Sueldo Minimo:");
		lblSueldoMinimo.setBounds(10, 83, 85, 14);
		add(lblSueldoMinimo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(93, 80, 93, 20);
		add(textField_1);
		
		JLabel lblSueldoMaximo = new JLabel("Sueldo Maximo:");
		lblSueldoMaximo.setBounds(10, 115, 85, 14);
		add(lblSueldoMaximo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(93, 112, 93, 20);
		add(textField_2);
		
		JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de experiencia minimos:");
		lblAosDeExperiencia.setBounds(10, 143, 152, 14);
		add(lblAosDeExperiencia);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(162, 140, 93, 20);
		add(textField_3);
		
		JLabel lblAspectosAValorar = new JLabel("Aspectos a valorar:");
		lblAspectosAValorar.setBounds(10, 178, 107, 14);
		add(lblAspectosAValorar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(UIManager.getBorder("TextField.border"));
		textArea.setBounds(137, 173, 253, 41);
		add(textArea);
		
		JLabel lblAspectosImprescindles = new JLabel("Aspectos imprescindibles:");
		lblAspectosImprescindles.setBounds(10, 238, 133, 14);
		add(lblAspectosImprescindles);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBorder(UIManager.getBorder("TextField.border"));
		textArea_1.setBounds(137, 233, 253, 41);
		add(textArea_1);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 302, 107, 14);
		add(lblDescripcion);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBorder(UIManager.getBorder("TextField.border"));
		textArea_2.setBounds(10, 328, 465, 149);
		add(textArea_2);
		
		JLabel lblConocimientos = new JLabel("Conocimientos requeridos:");
		lblConocimientos.setBounds(537, 125, 169, 14);
		add(lblConocimientos);
		
		JPanel panel = new PanelListaDoble();
		panel.setBounds(537, 174, 215, 180);
		add(panel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(537, 140, 135, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("");
		button.setBounds(682, 138, 24, 23);
		add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(716, 138, 24, 23);
		add(button_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(506, 49, 234, 20);
		add(textField_5);
		
		JLabel lblLugarDeTrabajo = new JLabel("Lugar de trabajo:");
		lblLugarDeTrabajo.setBounds(411, 52, 93, 14);
		add(lblLugarDeTrabajo);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de contrato:");
		lblTipoDeContrato.setBounds(411, 86, 93, 14);
		add(lblTipoDeContrato);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(506, 83, 159, 20);
		add(comboBox);
	}
}
