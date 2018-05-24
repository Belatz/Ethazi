package ethazi.intefaz.paneles;

import javax.swing.JPanel;

import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.excepciones.PanelNoDisponible;
import ethazi.intefaz.frame.VentanaPrincipal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMenu() {
		setLayout(null);

		if (Aplicacion.getUsuario() instanceof Candidato) {
			JButton btn_solicitudes = new JButton("Ver tus solicitudes");
			btn_solicitudes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_SUS_SOLICITUDES);
					} catch (PanelNoDisponible e) {
						e.printStackTrace();
					}
				}
			});
			btn_solicitudes.setBounds(10, 46, 229, 31);
			add(btn_solicitudes);

			JButton btn_ofertasAdecuadas = new JButton("Buscar ofertas adecuadas");
			btn_ofertasAdecuadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						VentanaPrincipal.cambiarPanel( (short) VentanaPrincipal.C_OFERTAS_ADECUADAS );
					} catch (PanelNoDisponible e) {
						e.printStackTrace();
					}
				}
			});
			btn_ofertasAdecuadas.setBounds(10, 15, 229, 31);
			add(btn_ofertasAdecuadas);

			JButton btn_conocimientosDeman = new JButton("Ver conocimientos mas demandados");
			btn_conocimientosDeman.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						VentanaPrincipal.cambiarPanel(VentanaPrincipal.C_CONOCIMIENTOS_BUSCADOS);
					} catch (PanelNoDisponible e) {
						e.printStackTrace();
					}
				}
			});
			btn_conocimientosDeman.setBounds(10, 77, 229, 31);
			add(btn_conocimientosDeman);
		} else {
			JButton btn_solicitudes = new JButton("Ver ofertas con solicitudes");
			btn_solicitudes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						VentanaPrincipal.cambiarPanel(VentanaPrincipal.C_OFERTAS_CON_SOLICITUDES);
					} catch (PanelNoDisponible e) {
						e.printStackTrace();
					}
				}
			});
			btn_solicitudes.setBounds(10, 46, 229, 31);
			add(btn_solicitudes);

			JButton btn_candidatos = new JButton("Buscar candidatos");
			btn_candidatos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						VentanaPrincipal.cambiarPanel(VentanaPrincipal.C_CONSULTAR_CANDIDATOS);
					} catch (PanelNoDisponible e) {
						e.printStackTrace();
					}
				}
			});
			btn_candidatos.setBounds(10, 15, 229, 31);
			add(btn_candidatos);

			JButton btn_susOfertas = new JButton("Ver tus ofertas");
			btn_susOfertas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						VentanaPrincipal.cambiarPanel(VentanaPrincipal.C_SUS_OFERTAS);
					} catch (PanelNoDisponible e) {
						e.printStackTrace();
					}
				}
			});
			btn_susOfertas.setBounds(10, 77, 229, 31);
			add(btn_susOfertas);

			JButton button = new JButton("Publicar oferta");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						VentanaPrincipal.cambiarPanel(VentanaPrincipal.C_PUBLICAR_OFERTA);
					} catch (PanelNoDisponible e1) {
						e1.printStackTrace();
					}
				}
			});
			button.setBounds(10, 107, 229, 31);
			add(button);

		}

	}
}
