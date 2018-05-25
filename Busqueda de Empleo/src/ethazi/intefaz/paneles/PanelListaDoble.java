package ethazi.intefaz.paneles;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 * Generates a panel with two lists and buttons to add or delete elements from a list to other
 * @author belatz
 *
 */
public class PanelListaDoble extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btn_anadir = new JButton();
	private JButton btn_eliminar = new JButton();
	private DefaultListModel<String> modelo_anadidos = new DefaultListModel<String>();
	private DefaultListModel<String> modelo_totales = new DefaultListModel<String>();
	private JList <String>li_eleAnadidos = new JList<String>(modelo_anadidos);
	private JList <String>li_eleTotales = new JList<String>(modelo_totales);
	private JScrollPane pa_anadidos = new JScrollPane();
	private JScrollPane pa_totales = new JScrollPane();

	public PanelListaDoble(ArrayList<String>listaIzquierda, ArrayList<String>listaDerecha) {
		
		actualizarListas(listaIzquierda, listaDerecha);
		// ----------------
		setLayout(null);
		setBounds(0, 0, 214, 177);
		// Boton anadir
		btn_anadir.setText("Anadir >>");
		btn_anadir.setBounds(new Rectangle(0, 140, 98, 36));
		btn_anadir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo_anadidos.addElement(li_eleTotales.getSelectedValue());
				modelo_totales.removeElement(li_eleTotales.getSelectedValue());
				li_eleTotales.setSelectedIndex(0);
			}
		});
		// Boton decartar
		btn_eliminar.setText("<< Descartar");
		btn_eliminar.setBounds(new Rectangle(115, 140, 98, 36));
		btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo_totales.addElement(li_eleAnadidos.getSelectedValue());
				modelo_anadidos.removeElement(li_eleAnadidos.getSelectedValue());
				li_eleTotales.setSelectedIndex(0);
			}
		});

		pa_anadidos.setBounds(new Rectangle(115, 0, 98, 133));
		pa_totales.setBounds(new Rectangle(0, 0, 98, 136));

		add(pa_totales, null);
		li_eleTotales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pa_totales.setViewportView(li_eleTotales);
		add(pa_anadidos, null);
		add(btn_anadir, null);
		add(btn_eliminar, null);
		li_eleAnadidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pa_anadidos.setViewportView(li_eleAnadidos);
		li_eleTotales.setSelectedIndex(0);
	}

	public void anadirElemento(String obj) {
		modelo_totales.addElement(obj);
	}

	public void filtrarElemento(String p_texto) {
		if ("".equals(p_texto)) {
			// TODO Cargar modelo entero desde lista de conocimientos totales
		}

		for (int i = 0; i < modelo_totales.size(); i++) {
			if (!((String) modelo_totales.get(i)).toLowerCase().contains(p_texto.toLowerCase())) {
				modelo_totales.removeElementAt(i);
			}
		}
	}
	public JButton getBtn_anadir() {
		return btn_anadir;
	}

	public JButton getBtn_eliminar() {
		return btn_eliminar;
	}
	public void actualizarListas(ArrayList<String>listaIzquierda, ArrayList<String>listaDerecha)
	{
		modelo_totales.removeAllElements();
		modelo_anadidos.removeAllElements();
		for (int i = 0; i < listaIzquierda.size(); i++) {
			int j=0;
			while(listaDerecha!=null &&
				j<listaDerecha.size() &&
					listaDerecha.get(j).toLowerCase().compareTo(listaIzquierda.get(i).toLowerCase())==0)
				j++;
			if(listaDerecha==null || j<listaDerecha.size())
				modelo_totales.addElement(listaIzquierda.get(i));
		}
		if(listaDerecha!=null)
			for(int i=0; i<listaDerecha.size();i++)
				modelo_anadidos.addElement(listaDerecha.get(i));
	}
}
