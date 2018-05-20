package ethazi.intefaz.paneles;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;

public class PanelConocimientosBuscados extends JPanel {
	private JTable table;
	private JLabel lblqueEsLo;

	/**
	 * Create the panel.
	 */
	public PanelConocimientosBuscados() {
		// Tamaño del JPanel
		setMinimumSize(new Dimension(762, 488));
		setMaximumSize(new Dimension(762, 488));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setBounds(10, 53, 430, 236);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBackground(new Color(255, 239, 213));
		table.setModel(new DefaultTableModel(new Object[][] { { 1, "Java" }, { 2, "C++" }, { 3, "Python" },
				{ 4, "Oracle" }, { 5, "SQL Server" }, { 6, "Javascript" }, { 7, "PHP" }, { 8, "Spring" }, { 9, "J2EE" },
				{ 10, "VOIP" }, { 11, "Network Specialist" }, { 12, "ITIL" }, { 13, "Cisco" }, { 14, "Linux" },
				{ 15, "VMware" }, { 16, "CCNA" }, { 17, "Windows" }, { 18, "Unix" }, { 19, "VOIP" }, { 20, "ITIL" }, },
				new String[] { "Nº", "Conocimiento" }));
		scrollPane.setViewportView(table);

		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(420);
		table.setBounds(10, 88, 420, 180);
		add(scrollPane);

		lblqueEsLo = new JLabel("\u00BFQue es lo que quieren las empresas de ti?");
		lblqueEsLo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblqueEsLo.setBounds(62, 28, 352, 14);
		add(lblqueEsLo);
	}
}