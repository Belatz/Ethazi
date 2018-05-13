package ethazi.intefaz.paneles;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class PanelListaDoble extends JPanel {
	
	private JButton btn_anadir = new JButton();
	private JButton btn_eliminar = new JButton();
	private DefaultListModel modelo_anadidos = new DefaultListModel();
	private DefaultListModel modelo_totales = new DefaultListModel();
	private JList li_eleAnadidos = new JList(modelo_anadidos);
	private JList li_eleTotales = new JList(modelo_totales);
	private JScrollPane pa_anadidos = new JScrollPane();
	private JScrollPane pa_totales = new JScrollPane();

	public PanelListaDoble() {
		// EJEMPLOS
		for (int i = 0; i < 10; i++) {
			modelo_totales.addElement("Ejemplo"+i);
		}
		// ----------------
		setLayout(null);
		setBounds(0, 0, 214, 177);
		// Boton anadir
		btn_anadir.setText("A\u00F1adir >>");
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
	
	public void anadirElemento(Object obj) {
		modelo_totales.addElement(obj);
	}
}
