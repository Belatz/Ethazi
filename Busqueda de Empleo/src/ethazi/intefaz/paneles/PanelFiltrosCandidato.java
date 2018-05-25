package ethazi.intefaz.paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import ethazi.datos.UtilidadesBD;

import javax.swing.JCheckBox;

/**
 * Generates a panel with a list of attributes to filter the searches
 * 
 * @author belatz
 *
 */
public class PanelFiltrosCandidato extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txField_residencia;
	private JTextField txField_experiencia;
	private JTextField txField_nick;
	private JTextField txField_nombreApe;
	
	public PanelFiltrosCandidato() {
		JPanel pa_filtros = crearPanelFiltros();
		setBounds(10, 60, 247, 550);
		getVerticalScrollBar().setUnitIncrement(16);
		setViewportView(pa_filtros);
	}

	/**
	 * Generates a filter panel.
	 * @return pa_filtros
	 */
	public JPanel crearPanelFiltros() {
		JPanel pa_filtros = new JPanel();

		pa_filtros.setPreferredSize(new Dimension(228, 550));
		pa_filtros.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 45, 226, 10);
		pa_filtros.add(separator);

		JLabel lbl_conocimientos = new JLabel("Conocimientos:");
		lbl_conocimientos.setBounds(7, 156, 211, 14);
		pa_filtros.add(lbl_conocimientos);

		ArrayList<String> conocimientos = new ArrayList<>();
		try {
			conocimientos = UtilidadesBD.descargarConocimientos();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		PanelListaDoble pa_conocimientos = new PanelListaDoble(conocimientos, null);
		pa_conocimientos.setLocation(9, 172);
		pa_filtros.add(pa_conocimientos);

		JLabel lbl_residencia = new JLabel("Lugar de residencia:");
		lbl_residencia.setBounds(7, 438, 115, 14);
		pa_filtros.add(lbl_residencia);

		txField_residencia = new JTextField();
		txField_residencia.setBounds(7, 451, 211, 20);
		pa_filtros.add(txField_residencia);
		txField_residencia.setColumns(10);

		JLabel lbl_experiencia = new JLabel("Anos de experiencia minimos:");
		lbl_experiencia.setBounds(7, 476, 211, 14);
		pa_filtros.add(lbl_experiencia);

		txField_experiencia = new JTextField();
		txField_experiencia.setColumns(10);
		txField_experiencia.setBounds(7, 489, 115, 20);
		pa_filtros.add(txField_experiencia);

		JLabel lbl_nick = new JLabel("Nombre de usuario:");
		lbl_nick.setBounds(7, 66, 162, 14);
		pa_filtros.add(lbl_nick);

		txField_nick = new JTextField();
		txField_nick.setColumns(10);
		txField_nick.setBounds(7, 79, 115, 20);
		pa_filtros.add(txField_nick);

		JLabel lbl_nombreApe = new JLabel("Nombre y apellidos:");
		lbl_nombreApe.setBounds(7, 110, 211, 14);
		pa_filtros.add(lbl_nombreApe);

		txField_nombreApe = new JTextField();
		txField_nombreApe.setColumns(10);
		txField_nombreApe.setBounds(7, 123, 211, 20);
		pa_filtros.add(txField_nombreApe);

		JCheckBox chBox_carne = new JCheckBox("Carne de conducir");
		chBox_carne.setBounds(7, 356, 148, 23);
		pa_filtros.add(chBox_carne);

		JCheckBox chBox_coche = new JCheckBox("Coche propio");
		chBox_coche.setBounds(7, 382, 148, 23);
		pa_filtros.add(chBox_coche);

		JCheckBox chBox_viajes = new JCheckBox("Disponible para viajes");
		chBox_viajes.setBounds(7, 408, 148, 23);
		pa_filtros.add(chBox_viajes);

		JButton btn_aplicar = new JButton("Aplicar");
		btn_aplicar.setBounds(66, 11, 89, 23);
		btn_aplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO hacer algo con la lista de candidatos
				UtilidadesBD.filtrarCandidatos(txField_nombreApe.getText(), txField_nick.getText(),
						txField_experiencia.getText(), txField_residencia.getText(), chBox_carne.isSelected(),
						chBox_coche.isSelected(), chBox_viajes.isSelected(), pa_conocimientos.getConocimientos());
			}
		});
		pa_filtros.add(btn_aplicar);

		return pa_filtros;
	}
}
