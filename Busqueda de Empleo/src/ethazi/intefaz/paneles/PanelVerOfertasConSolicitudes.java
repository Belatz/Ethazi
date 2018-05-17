package ethazi.intefaz.paneles;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;

public class PanelVerOfertasConSolicitudes extends JPanel
{
	private JTable table;
	public PanelVerOfertasConSolicitudes() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(261, 454, 41, 23);
		add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(432, 16, 1, 1);
		add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton(">");
		button.setBounds(399, 454, 41, 23);
		add(button);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(715, 11, 17, 437);
		add(scrollBar);
		
		JButton btnAnalizarSolicitud = new JButton("Analizar solicitud");
		btnAnalizarSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAnalizarSolicitud.setBounds(576, 454, 156, 23);
		add(btnAnalizarSolicitud);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(28, 11, 688, 433);
		add(table);
	}
}
