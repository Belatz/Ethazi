package ethazi.intefaz.paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import ethazi.aplicacion.Oferta;
import ethazi.intefaz.Elemento_Listable;
import ethazi.intefaz.Elementos_Listados;
import ethazi.intefaz.frame.VentanaPrincipal;

/**
 * 
 * @author JonOr
 *
 */

public class PanelAtrasAlante extends JPanel {

	public PanelAtrasAlante(Elementos_Listados panel_QueTieneLaLista) {
		setLayout(null);
		JButton btn_siguiente = new JButton("Siguiente");
		JButton btn_anterior = new JButton("Anterior");
		setPreferredSize(new Dimension(500, 37));
		btn_siguiente.setBounds(295, 0, 105, 34);
		add(btn_siguiente);
		btn_anterior.setBounds(110, 0, 105, 34);
		add(btn_anterior);
		btn_anterior.setVisible(false);
		if (panel_QueTieneLaLista.getnPagina() == panel_QueTieneLaLista.getMaxPags()) {
			btn_siguiente.setVisible(false);
		}

		btn_siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (panel_QueTieneLaLista.getnPagina() == 1) {
					btn_anterior.setVisible(true);
				}
				if (panel_QueTieneLaLista.getnPagina() == panel_QueTieneLaLista.getMaxPags() - 1) {
					btn_siguiente.setVisible(false);
				}
				panel_QueTieneLaLista.sumarPagina();
				panel_QueTieneLaLista.mostrarOtras10();

			}
		});

		btn_anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// VentanaPrincipal.remcont();
				if (panel_QueTieneLaLista.getnPagina() == panel_QueTieneLaLista.getMaxPags()) {
					btn_siguiente.setVisible(true);
				}
				if (panel_QueTieneLaLista.getnPagina() == 2) {
					btn_anterior.setVisible(false);
				}

				panel_QueTieneLaLista.restarPagina();
				panel_QueTieneLaLista.mostrarOtras10();

				// VentanaPrincipal.addcont();
			}
		});

	}

}
