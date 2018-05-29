package ethazi.intefaz.paneles;

import javax.swing.JPanel;

import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.Empresa;
import ethazi.aplicacion.Utilidades;
import ethazi.datos.UtilidadesBD;
import ethazi.excepciones.PanelNoDisponible;
import ethazi.intefaz.frame.VentanaPrincipal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PanelMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This panel is used in the BarraHerramientas, which is opened with the mouse,
	 * passing over the menu.
	 * 
	 * @autor JonOr
	 */
	public PanelMenu() {
		setLayout(null);

		JButton aux = new JButton("Menu");
		aux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_SUS_SOLICITUDES);
					VentanaPrincipal.visMenu2();
					PanelBarraHerramientas.botonMenuInv();
				} catch (PanelNoDisponible e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		aux.setBounds(10, 11, 229, 25);
		aux.setBorder(null);
		aux.setContentAreaFilled(false);
		add(aux);
		if (Aplicacion.getUsuario() instanceof Candidato) {
			JButton btn_solicitudes = new JButton("Ver tus solicitudes");
			btn_solicitudes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_SUS_SOLICITUDES);
						VentanaPrincipal.visMenu2();
						PanelBarraHerramientas.botonMenuInv();
					} catch (PanelNoDisponible e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
			btn_solicitudes.setBounds(10, 66, 229, 31);
			add(btn_solicitudes);

			JButton btn_ofertasAdecuadas = new JButton("Buscar ofertas adecuadas");
			btn_ofertasAdecuadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_OFERTAS_ADECUADAS);
						VentanaPrincipal.visMenu2();
						PanelBarraHerramientas.botonMenuInv();
					} catch (PanelNoDisponible e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
			btn_ofertasAdecuadas.setBounds(10, 35, 229, 31);
			add(btn_ofertasAdecuadas);

			JButton btn_conocimientosDeman = new JButton("Ver conocimientos mas demandados");
			btn_conocimientosDeman.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						VentanaPrincipal.cambiarPanel(VentanaPrincipal.C_CONOCIMIENTOS_BUSCADOS);
						VentanaPrincipal.visMenu2();
						PanelBarraHerramientas.botonMenuInv();
					} catch (PanelNoDisponible e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
			btn_conocimientosDeman.setBounds(10, 97, 229, 31);
			add(btn_conocimientosDeman);
		} else {
			JButton btn_solicitudes = new JButton("Ver ofertas con solicitudes");
			btn_solicitudes.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					try {
						VentanaPrincipal.setListaDeElementos(Utilidades.cambiarOfertaAElemento(UtilidadesBD
								.filtrarOfertas("Dum", null, null, null, null, 0, null, null)));
						VentanaPrincipal.cambiarPanel(VentanaPrincipal.C_OFERTAS_CON_SOLICITUDES, VentanaPrincipal.getListaDeElementos());
						VentanaPrincipal.visMenu2();
						PanelBarraHerramientas.botonMenuInv();
					} catch (PanelNoDisponible e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
			btn_solicitudes.setBounds(10, 66, 229, 31);
			add(btn_solicitudes);

			JButton btn_candidatos = new JButton("Buscar candidatos");
			btn_candidatos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {

						VentanaPrincipal.setListaDeElementos(Utilidades.cambiarCandidatoAElemento(UtilidadesBD.buscarCandidatos()));
				VentanaPrincipal.cambiarPanel(VentanaPrincipal.C_CONSULTAR_CANDIDATOS,VentanaPrincipal.getListaDeElementos());
						VentanaPrincipal.visMenu2();
						PanelBarraHerramientas.botonMenuInv();
				

					} catch (PanelNoDisponible e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
			btn_candidatos.setBounds(10, 35, 229, 31);
			add(btn_candidatos);

			JButton btn_susOfertas = new JButton("Ver tus ofertas");
			btn_susOfertas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						VentanaPrincipal.cambiarPanel(VentanaPrincipal.C_SUS_OFERTAS);
						VentanaPrincipal.visMenu2();
						PanelBarraHerramientas.botonMenuInv();
					} catch (PanelNoDisponible e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
			btn_susOfertas.setBounds(10, 97, 229, 31);
			add(btn_susOfertas);

			JButton button = new JButton("Publicar oferta");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						VentanaPrincipal.cambiarPanel(VentanaPrincipal.C_PUBLICAR_OFERTA);
						VentanaPrincipal.visMenu2();
						PanelBarraHerramientas.botonMenuInv();
					} catch (PanelNoDisponible e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			button.setBounds(10, 127, 229, 31);
			add(button);
		}

	}

}
