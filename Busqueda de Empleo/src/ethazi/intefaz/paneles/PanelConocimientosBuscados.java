package ethazi.intefaz.paneles;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ethazi.aplicacion.Usuario;
import ethazi.datos.UtilidadesBD;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;

public class PanelConocimientosBuscados extends JPanel {
	/**
	 * Shows the most wanted knowledge of the platform
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JLabel lblqueEsLo;

	/**
	 * Create the panel.
	 */
	public PanelConocimientosBuscados() {
		// Tamaño del JPanel
		setName("Conocimientos mas buscados");
		setLayout(null);
		setPreferredSize(new Dimension(762, 488));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setBounds(10, 53, 742, 424);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBackground(new Color(255, 239, 213));
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("", conocimientosMasBuscados(10));
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setBounds(10, 88, 762, 488);
		add(scrollPane);

		lblqueEsLo = new JLabel("\u00BFQue es lo que quieren las empresas de ti?");
		lblqueEsLo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblqueEsLo.setBounds(158, 28, 352, 14);
		add(lblqueEsLo);
	}

	/**
	 * @author Belatz
	 * 
	 * @param cantidad
	 * @return _resultado
	 */
	public static Vector<String> conocimientosMasBuscados(int p_cantidad) {
		Vector<String> _resultado = new Vector<>();
		try {
			ArrayList<String> _conocimientosBuscados = UtilidadesBD.buscarConocimientosRequeridos();
			if (_conocimientosBuscados.size() < p_cantidad) {
				p_cantidad = _conocimientosBuscados.size();
			}
			_resultado.addAll(_conocimientosBuscados.subList(0, p_cantidad));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return _resultado;
	}
}