package ethazi.intefaz.paneles;

import javax.swing.JPanel;

import ethazi.aplicacion.excepciones.PanelNoDisponible;
import ethazi.intefaz.frame.VentanaPrincipal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMenu() {
		setLayout(null);

		JButton btn1 = new JButton("B1");
		btn1.setBounds(10, 46, 229, 31);
		add(btn1);

		JButton btn2 = new JButton("b2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("intento invi");
				try {
					VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_BUSCAR_OFERTA);
					VentanaPrincipal.visMenu2();
					PanelBarraHerramientas.botonMenuInv();
				} catch (PanelNoDisponible e) {
					e.printStackTrace();
				}
			}
		});
		btn2.setBounds(10, 15, 229, 31);
		add(btn2);

		JButton btn3 = new JButton("b3");
		btn3.setBounds(10, 77, 229, 31);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("intento invi");
				try {
					VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_BUSCAR_OFERTA);
					VentanaPrincipal.visMenu2();
					PanelBarraHerramientas.botonMenuInv();
				} catch (PanelNoDisponible e) {
					e.printStackTrace();
				}
			}
		});
		add(btn3);
		
	}
	


}
