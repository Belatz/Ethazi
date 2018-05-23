package ethazi.intefaz.paneles;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * Generates a panel with a list of attributes to filter the searches
 * 
 * @author belatz
 *
 */
public class PanelFiltrosOferta extends JScrollPane {

	private JTextField txField_sueldoMin;
	private JTextField txField_sueldoMax;
	private JTextField txFiedl_experiencia;
	private JTextField txField_empresa;

	/**
	 * Create the panel.
	 */
	public PanelFiltrosOferta() {
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel pa_filtros = crearPanelFiltros();
		setBounds(10, 60, 247, 441);
		getVerticalScrollBar().setUnitIncrement(16);
		setViewportView(pa_filtros);

	}

	/**
	 * Generates a filter panel.
	 * @return
	 */
	public JPanel crearPanelFiltros() {
		JPanel pa_filtros = new JPanel();

		pa_filtros.setPreferredSize(new Dimension(228, 550));
		pa_filtros.setLayout(null);

		JButton btn_aplicar = new JButton("Aplicar");
		btn_aplicar.setBounds(66, 11, 89, 23);
		pa_filtros.add(btn_aplicar);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 45, 226, 10);
		pa_filtros.add(separator);

		JLabel lbl_conocimientos = new JLabel("Conocimientos:");
		lbl_conocimientos.setBounds(10, 50, 211, 14);
		pa_filtros.add(lbl_conocimientos);

		// Ejemplo
		ArrayList<String> conocimientos = new ArrayList<String>();
		for (int i = 0; i < 10; i++)
			conocimientos.add("Ejemplo " + i);
		// JPanel pa_conocimientos = new PanelListaDoble();
		JPanel pa_conocimientos = new PanelListaDoble(conocimientos, null);
		pa_conocimientos.setLocation(7, 66);
		pa_filtros.add(pa_conocimientos);

		JLabel lbl_lugar = new JLabel("Lugar de trabajo:");
		lbl_lugar.setBounds(7, 250, 118, 14);
		pa_filtros.add(lbl_lugar);

		JComboBox combo_lugar = new JComboBox();
		combo_lugar.setBounds(7, 264, 118, 23);
		pa_filtros.add(combo_lugar);

		JLabel lbl_contrato = new JLabel("Tipo de contrato:");
		lbl_contrato.setBounds(7, 295, 118, 14);
		pa_filtros.add(lbl_contrato);

		JComboBox combo_contrato = new JComboBox();
		combo_contrato.setBounds(7, 309, 118, 23);
		pa_filtros.add(combo_contrato);

		JLabel lbl_sueldoMin = new JLabel("Sueldo minimo:");
		lbl_sueldoMin.setBounds(10, 343, 115, 14);
		pa_filtros.add(lbl_sueldoMin);

		txField_sueldoMin = new JTextField();
		txField_sueldoMin.setBounds(10, 356, 115, 20);
		pa_filtros.add(txField_sueldoMin);
		txField_sueldoMin.setColumns(10);

		JLabel lbl_sueldoMax = new JLabel("Sueldo maximo:");
		lbl_sueldoMax.setBounds(10, 384, 115, 14);
		pa_filtros.add(lbl_sueldoMax);

		txField_sueldoMax = new JTextField();
		txField_sueldoMax.setColumns(10);
		txField_sueldoMax.setBounds(10, 397, 115, 20);
		pa_filtros.add(txField_sueldoMax);

		JLabel lbl_experiencia = new JLabel("A\u00F1os de experiencia minimos:");
		lbl_experiencia.setBounds(10, 428, 211, 14);
		pa_filtros.add(lbl_experiencia);

		txFiedl_experiencia = new JTextField();
		txFiedl_experiencia.setColumns(10);
		txFiedl_experiencia.setBounds(10, 441, 115, 20);
		pa_filtros.add(txFiedl_experiencia);

		JLabel lbl_empresa = new JLabel("Nombre de empresa:");
		lbl_empresa.setBounds(10, 472, 145, 14);
		pa_filtros.add(lbl_empresa);

		txField_empresa = new JTextField();
		txField_empresa.setColumns(10);
		txField_empresa.setBounds(10, 485, 162, 20);
		pa_filtros.add(txField_empresa);

		return pa_filtros;
	}
}
