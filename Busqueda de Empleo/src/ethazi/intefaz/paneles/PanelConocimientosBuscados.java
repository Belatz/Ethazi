package ethazi.intefaz.paneles;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ethazi.aplicacion.Usuario;

import javax.swing.JScrollPane;
import javax.print.attribute.Size2DSyntax;
import javax.swing.JLabel;
import java.awt.Color;

public class PanelConocimientosBuscados extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JLabel lblqueEsLo;

	/**
	 * Create the panel.
	 */
	public PanelConocimientosBuscados() {
		// Tamaño del JPanel
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
		model.addColumn("", conocimientosMasBuscados(100));
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

	public static Vector conocimientosMasBuscados(int cantidad) {
		// TODO consulta a la base de datos con un arrayBidi de conocimientos y el
		// número
		ArrayList<String> conocimientosMasBuscados = new ArrayList<String>();
		// Ejemplo
		ArrayList<ArrayList<String>> bidi = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < 10; i++) {
			ArrayList<String> aux = new ArrayList<String>();
			for (int j = 0; j < 10; j++)
				aux.add(String.valueOf(j));
			bidi.add(aux);
		}
		if (cantidad < Usuario.getConocimientosTotales().size()) {
			ArrayList<Integer> contadores = new ArrayList<Integer>(Usuario.misConocimientosTotales.size());
			for (int i = 0; i < bidi.size(); i++) {
				for (int j = 0; j < bidi.get(i).size(); j++) {
					int pos = posString(Usuario.getConocimientosTotales(), bidi.get(i).get(j));
					if (pos != -1)
						contadores.set(pos, contadores.get(pos) + 1);
				}
			}
			ArrayList<String> conocimientosTotales = new ArrayList<String>();
			conocimientosTotales.addAll(Usuario.getConocimientosTotales());

			int i = 0, mayor;
			while (i < cantidad) {
				mayor = buscarMayr(contadores);
				int pos = posInt(contadores, mayor);
				conocimientosMasBuscados.add(conocimientosTotales.get(pos));
				conocimientosTotales.remove(pos);
				contadores.remove(pos);
			}
		}
		else
			conocimientosMasBuscados.addAll(Usuario.getConocimientosTotales());
		Vector<String> aux=new Vector<String>();
		aux.addAll(conocimientosMasBuscados);
		return aux;
	}

	// TODO pasar a la clase de utilidades
	public static int posString(ArrayList<String> array, String texto) {
		int i = 0;
		while (i < array.size() && array.get(i).toLowerCase().compareTo(texto.toLowerCase()) != 0)
			i++;
		if (i >= array.size())
			i = -1;
		return i;
	}

	public static int posInt(ArrayList<Integer> array, int num) {
		int i = 0;
		while (i < array.size() && array.get(i) != num)
			i++;
		if (i >= array.size())
			i = -1;
		return i;
	}

	public static int buscarMayr(ArrayList<Integer> array) {
		int mayor = 0;
		for (int i = 0; i < array.size(); i++) {
			int j = 0;
			while (j < array.size() && mayor > array.get(j))
				j++;
			if (j < array.size())
				mayor = array.get(j);
		}
		return mayor;
	}
}