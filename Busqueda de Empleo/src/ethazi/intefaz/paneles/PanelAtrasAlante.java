package ethazi.intefaz.paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelAtrasAlante extends JPanel {
	
	public static final byte C_PRIMERA = 0, C_CENTRAL = 1, C_ULTIMA = 2;

	/**
	 * Create the panel.
	 */
	public PanelAtrasAlante(byte p_ubicacionPagina) {
		setLayout(null);
		JButton btn_siguiente = new JButton("Siguiente");
		JButton btn_anterior = new JButton("Anterior");
		setPreferredSize(new Dimension(500, 37));

		switch (p_ubicacionPagina) {
		case 0:
			btn_siguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// codigo que ejecutara
				}
			});
			btn_siguiente.setBounds(295, 0, 105, 34);
			add(btn_siguiente);
			break;
		case 1:
			btn_siguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// codigo que ejecutara
				}
			});
			btn_siguiente.setBounds(295, 0, 105, 34);
			add(btn_siguiente);

			btn_anterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// codigo que ejecutara
				}
			});
			btn_anterior.setBounds(110, 0, 105, 34);
			add(btn_anterior);

			break;
		case 2:
			btn_anterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// codigo que ejecutara
				}
			});
			btn_anterior.setBounds(110, 0, 105, 34);
			add(btn_anterior);

			break;
		}
	}

}
