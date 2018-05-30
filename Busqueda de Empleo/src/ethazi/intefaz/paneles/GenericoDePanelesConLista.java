package ethazi.intefaz.paneles;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import ethazi.intefaz.Elemento_A_Listar;
import ethazi.intefaz.Elemento_Listable;
import ethazi.intefaz.Elementos_Listados;

/**
 * 
 * @author JonOr
 *
 */
public class GenericoDePanelesConLista extends JPanel {
	private Elementos_Listados panel_QueTieneLaLista = null;
	private JPanel _panelBotonAtrasYAlante = null;
	private JScrollPane pa_listado;
	private JLabel sinResultados;
	private PanelFiltrosOferta pa_filtrosOferta;
	private JScrollPane pa_filtrosCandidato;
	public static final long serialVersionUID = 1L;

	public GenericoDePanelesConLista() {

	}

	public GenericoDePanelesConLista(ArrayList<Elemento_Listable> listaDeElementosListables, byte tipo) {

		construir(listaDeElementosListables, tipo);
	}

	public JScrollPane getPa_filtrosOferta() {
		return pa_filtrosOferta;
	}

	public void actualizar(ArrayList<Elemento_Listable> listaDeElementosListables, byte tipo) {
		removeAll();
		construir(listaDeElementosListables, tipo);
		updateUI();
	}

	public void construir(ArrayList<Elemento_Listable> listaDeElementosListables, byte tipo) {

		pa_listado = new JScrollPane();
		setLayout(null);
		pa_listado.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pa_listado.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pa_listado.getVerticalScrollBar().setUnitIncrement(16);

		switch (tipo) {
		case Elemento_A_Listar.C_CONSULTAR_SUS_SOLICITUDES:
			if (listaDeElementosListables.size() == 0) {
				sinResultados = new JLabel("No tienes solicitudes");
				sinResultados.setBounds(100, 100, 500, 30);
				add(sinResultados);
			} else {
				panel_QueTieneLaLista = new Elementos_Listados(listaDeElementosListables,
						Elemento_A_Listar.C_CONSULTAR_SUS_SOLICITUDES);
				panel_QueTieneLaLista.setPreferredSize(new Dimension(762, 1050));
				setPreferredSize(new Dimension(762, 488));
				pa_listado.setBounds(10, 0, 500, 443);
				_panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista,
						Elemento_A_Listar.C_CONSULTAR_SUS_SOLICITUDES);
				_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);
				pa_listado.setViewportView(panel_QueTieneLaLista);
				add(pa_listado);
				add(_panelBotonAtrasYAlante);
			}
			System.out.println("LOG: PANEL ACTUAL -- Sus Solicitudes");
			break;

		case Elemento_A_Listar.C_CONSULTAR_OFERTAS:
			if (listaDeElementosListables.size() == 0) {
				sinResultados = new JLabel("No se encontraron ofertas con esa busqueda");
				sinResultados.setBounds(100, 100, 500, 30);
				add(sinResultados);
			} else {
				panel_QueTieneLaLista = new Elementos_Listados(listaDeElementosListables,
						Elemento_A_Listar.C_CONSULTAR_OFERTAS);

				setPreferredSize(new Dimension(762, 488));

				pa_listado.setBounds(10, 0, 500, 443);

				_panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista,
						Elemento_A_Listar.C_CONSULTAR_OFERTAS);
				_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);
				pa_listado.setViewportView(panel_QueTieneLaLista);

				add(pa_listado);
				add(_panelBotonAtrasYAlante);
			}
			pa_filtrosOferta = new PanelFiltrosOferta();
			pa_filtrosOferta.setBounds(512, 0, 247, 482);
			add(pa_filtrosOferta);
			System.out.println("LOG: PANEL ACTUAL -- Consultar Ofertas");
			break;

		case Elemento_A_Listar.C_VER_OFERTAS_CON_SOLICITUD:
			if (listaDeElementosListables.size() == 0) {
				sinResultados = new JLabel("No se encontraron ofertas con solicitudes");
				sinResultados.setBounds(100, 100, 500, 30);
				add(sinResultados);
			} else {
				panel_QueTieneLaLista = new Elementos_Listados(listaDeElementosListables,
						Elemento_A_Listar.C_VER_OFERTAS_CON_SOLICITUD);
				panel_QueTieneLaLista.setPreferredSize(new Dimension(762, 1050));

				setPreferredSize(new Dimension(762, 488));

				pa_listado.setBounds(10, 0, 762, 443);

				_panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista,
						Elemento_A_Listar.C_VER_OFERTAS_CON_SOLICITUD);
				_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);
				pa_listado.setViewportView(panel_QueTieneLaLista);
				add(pa_listado);
				add(_panelBotonAtrasYAlante);
			}
			System.out.println("LOG: PANEL ACTUAL -- Ofertas con Solicitudes");
			break;

		case Elemento_A_Listar.C_CONSULTAR_SUS_OFERTAS:
			if (listaDeElementosListables.size() == 0) {
				sinResultados = new JLabel("No tienes ofertas publicadas");
				sinResultados.setBounds(100, 100, 500, 30);
				add(sinResultados);
			} else {
				panel_QueTieneLaLista = new Elementos_Listados(listaDeElementosListables,
						Elemento_A_Listar.C_CONSULTAR_SUS_OFERTAS);

				setPreferredSize(new Dimension(762, 488));

				pa_listado.setBounds(10, 0, 500, 443);

				_panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista,
						Elemento_A_Listar.C_CONSULTAR_SUS_OFERTAS);
				_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);
				pa_listado.setViewportView(panel_QueTieneLaLista);
				add(pa_listado);
				add(_panelBotonAtrasYAlante);
			}
			System.out.println("LOG: PANEL ACTUAL -- Sus Ofertas");
			break;

		case Elemento_A_Listar.C_ANALIZAR_SOLICITUDES:
			if (listaDeElementosListables.size() == 0) {
				sinResultados = new JLabel("No se encontraron ofertas con esa busqueda");
				sinResultados.setBounds(100, 100, 500, 30);
				add(sinResultados);
			} else {
				panel_QueTieneLaLista = new Elementos_Listados(listaDeElementosListables,
						Elemento_A_Listar.C_ANALIZAR_SOLICITUDES);

				setPreferredSize(new Dimension(762, 488));

				pa_listado.setBounds(10, 0, 500, 443);

				_panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista,
						Elemento_A_Listar.C_ANALIZAR_SOLICITUDES);
				_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);
				pa_listado.setViewportView(panel_QueTieneLaLista);
				add(pa_listado);
				add(_panelBotonAtrasYAlante);
			}
			System.out.println("LOG: PANEL ACTUAL -- Analizar Solicitudes");
			break;

		case Elemento_A_Listar.C_BUSCAR_CANDIDATOS:
			if (listaDeElementosListables.size() == 0) {
				sinResultados = new JLabel("No se encontraron candidatos con esa busqueda");
				sinResultados.setBounds(100, 100, 500, 30);
				add(sinResultados);
			} else {
				panel_QueTieneLaLista = new Elementos_Listados(listaDeElementosListables,
						Elemento_A_Listar.C_BUSCAR_CANDIDATOS);
				setPreferredSize(new Dimension(762, 488));

				pa_listado.setBounds(10, 0, 500, 443);

				_panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista,
						Elemento_A_Listar.C_BUSCAR_CANDIDATOS);
				_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);

				pa_listado.setViewportView(panel_QueTieneLaLista);
				pa_listado.getVerticalScrollBar().setVisible(false);

				add(pa_listado);
				add(_panelBotonAtrasYAlante);
			}
			pa_filtrosCandidato = new PanelFiltrosCandidato();
			pa_filtrosCandidato.setBounds(512, 0, 247, 482);

			add(pa_filtrosCandidato);
			System.out.println("LOG: PANEL ACTUAL -- Buscar Candidatos");
			break;

		}

	}

	public void cambiarTituloOferta(String titulo) {
		pa_filtrosOferta.setTxField_titulo(titulo);
	}
}
