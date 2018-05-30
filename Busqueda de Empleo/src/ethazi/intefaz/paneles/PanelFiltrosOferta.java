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

import ethazi.aplicacion.Contrato;
import ethazi.aplicacion.Utilidades;
import ethazi.datos.UtilidadesBD;
import ethazi.excepciones.PanelNoDisponible;
import ethazi.intefaz.Elemento_Listable;
import ethazi.intefaz.frame.VentanaPrincipal;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * Generates a panel with a list of attributes to filter the searches
 * 
 * @author belatz
 *
 */
public class PanelFiltrosOferta extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField txField_sueldoMin;
	private static JTextField txField_sueldoMax;
	private static JTextField txFiedl_experiencia;
	private static JTextField txField_empresa;
	private static JTextField txField_titulo;
	private static JTextField txField_lugar;

	public PanelFiltrosOferta() {
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel pa_filtros = crearPanelFiltros();
		setBounds(10, 60, 247, 441);
		getVerticalScrollBar().setUnitIncrement(16);
		setViewportView(pa_filtros);

	}

	/**
	 * Generates a filter panel.
	 * 
	 * @return
	 */
	public JPanel crearPanelFiltros() {
		JPanel pa_filtros = new JPanel();

		pa_filtros.setPreferredSize(new Dimension(228, 580));
		pa_filtros.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 45, 226, 10);
		pa_filtros.add(separator);

		JLabel lbl_conocimientos = new JLabel("Conocimientos:");
		lbl_conocimientos.setBounds(15, 121, 211, 14);
		pa_filtros.add(lbl_conocimientos);

		ArrayList<String> conocimientos = new ArrayList<>();
		try {
			conocimientos = UtilidadesBD.descargarConocimientos();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		PanelListaDoble pa_conocimientos = new PanelListaDoble(conocimientos, null);
		pa_conocimientos.setLocation(9, 140);
		pa_filtros.add(pa_conocimientos);

		JLabel lbl_lugar = new JLabel("Lugar de trabajo:");
		lbl_lugar.setBounds(12, 321, 118, 14);
		pa_filtros.add(lbl_lugar);

		txField_lugar = new JTextField();
		txField_lugar.setBounds(12, 335, 205, 23);
		pa_filtros.add(txField_lugar);

		JLabel lbl_contrato = new JLabel("Tipo de contrato:");
		lbl_contrato.setBounds(12, 366, 118, 14);
		pa_filtros.add(lbl_contrato);

		JComboBox<Contrato> combo_contrato = new JComboBox<>();
		combo_contrato.setBounds(12, 380, 118, 23);
		combo_contrato.addItem(Contrato.INDEFINIDO_TIEMPO_COMPLETO);
		combo_contrato.addItem(Contrato.INDEFINIDO_TIEMPO_PARCIAL);
		combo_contrato.addItem(Contrato.TEMPORAL_TIEMPO_COMPLETO);
		combo_contrato.addItem(Contrato.TEMPORTAL_TIEMPO_PARCIAL);
		pa_filtros.add(combo_contrato);

		JLabel lbl_sueldoMin = new JLabel("Sueldo minimo:");
		lbl_sueldoMin.setBounds(15, 414, 115, 14);
		pa_filtros.add(lbl_sueldoMin);

		txField_sueldoMin = new JTextField();
		txField_sueldoMin.setBounds(15, 427, 115, 20);
		pa_filtros.add(txField_sueldoMin);
		txField_sueldoMin.setColumns(10);

		JLabel lbl_sueldoMax = new JLabel("Sueldo maximo:");
		lbl_sueldoMax.setBounds(15, 455, 115, 14);
		pa_filtros.add(lbl_sueldoMax);

		txField_sueldoMax = new JTextField();
		txField_sueldoMax.setColumns(10);
		txField_sueldoMax.setBounds(15, 468, 115, 20);
		pa_filtros.add(txField_sueldoMax);

		JLabel lbl_experiencia = new JLabel("A\u00F1os de experiencia minimos:");
		lbl_experiencia.setBounds(15, 499, 211, 14);
		pa_filtros.add(lbl_experiencia);

		txFiedl_experiencia = new JTextField();
		txFiedl_experiencia.setColumns(10);
		txFiedl_experiencia.setBounds(15, 512, 115, 20);
		pa_filtros.add(txFiedl_experiencia);

		JLabel lbl_empresa = new JLabel("Nombre de empresa:");
		lbl_empresa.setBounds(15, 543, 202, 14);
		pa_filtros.add(lbl_empresa);

		txField_empresa = new JTextField();
		txField_empresa.setColumns(10);
		txField_empresa.setBounds(15, 556, 202, 20);
		pa_filtros.add(txField_empresa);

		JButton btn_aplicar = new JButton("Aplicar");
		btn_aplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ArrayList<Elemento_Listable> _ofertas = Utilidades.cambiarOfertaAElemento(UtilidadesBD
							.filtrarOfertas(txField_titulo.getText(), txField_lugar.getText(),
									txField_sueldoMax.getText(), txField_sueldoMin.getText(),
									txFiedl_experiencia.getText(), ((Contrato) combo_contrato.getSelectedItem()).getTipo() ,
									txField_empresa.getText(), pa_conocimientos.getConocimientosAnadidos()));
					VentanaPrincipal.getPa_barraHerramientas().cambiarTitulo(txField_titulo.getText());
					VentanaPrincipal.cambiarPanel(VentanaPrincipal.C_BUSCAR_OFERTA, _ofertas);
				} catch (SQLException | PanelNoDisponible e) {
					e.printStackTrace();
				}
			
			}
		});
		btn_aplicar.setBounds(66, 11, 89, 23);
		pa_filtros.add(btn_aplicar);

		JLabel lbl_titulo = new JLabel("Titulo:");
		lbl_titulo.setBounds(12, 55, 70, 15);
		pa_filtros.add(lbl_titulo);

		txField_titulo = new JTextField();
		txField_titulo.setBounds(16, 82, 201, 19);
		pa_filtros.add(txField_titulo);
		txField_titulo.setColumns(10);

		return pa_filtros;
	}

	

	public void setTxField_titulo(String titulo) {
		txField_titulo.setText(titulo);;
	}
}
