package ethazi.intefaz.paneles;

import java.awt.Dimension;
import java.util.ArrayList;

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
	
	private static final long serialVersionUID = 1L;

	public GenericoDePanelesConLista() {
		
	}
	public GenericoDePanelesConLista(ArrayList<Elemento_Listable> listaDeElementosListables, byte tipo) {
		Elementos_Listados panel_QueTieneLaLista = null;
		JPanel _panelBotonAtrasYAlante = null;
		JScrollPane pa_listado;
		pa_listado = new JScrollPane();
		setLayout(null);
		pa_listado.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pa_listado.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pa_listado.getVerticalScrollBar().setUnitIncrement(16);

		switch (tipo) {
		case Elemento_A_Listar.C_CONSULTAR_SUS_SOLICITUDES:
			panel_QueTieneLaLista = new Elementos_Listados(listaDeElementosListables,
					Elemento_A_Listar.C_CONSULTAR_SUS_SOLICITUDES);
			panel_QueTieneLaLista.setPreferredSize(new Dimension(762, 1050));
			setPreferredSize(new Dimension(762, 488));
			pa_listado.setBounds(10, 0, 500, 443);
			_panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista);
			_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);

			break;

		case Elemento_A_Listar.C_CONSULTAR_OFERTAS:
			panel_QueTieneLaLista = new Elementos_Listados(listaDeElementosListables,
					Elemento_A_Listar.C_CONSULTAR_OFERTAS);

			setPreferredSize(new Dimension(762, 488));

			pa_listado.setBounds(10, 0, 500, 443);

			_panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista);
			_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);

			JScrollPane pa_filtrosOferta = new PanelFiltrosOferta();
			pa_filtrosOferta.setBounds(512, 0, 247, 482);
			add(pa_filtrosOferta);
			break;

		case Elemento_A_Listar.C_VER_OFERTAS_CON_SOLICITUD:
			panel_QueTieneLaLista = new Elementos_Listados(listaDeElementosListables,
					Elemento_A_Listar.C_VER_OFERTAS_CON_SOLICITUD);
			panel_QueTieneLaLista.setPreferredSize(new Dimension(762, 1050));

			setPreferredSize(new Dimension(762, 488));

			pa_listado.setBounds(10, 0, 762, 443);

			_panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista);
			_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);

			break;

		case Elemento_A_Listar.C_CONSULTAR_SUS_OFERTAS:
			panel_QueTieneLaLista = new Elementos_Listados(listaDeElementosListables,
					Elemento_A_Listar.C_CONSULTAR_SUS_OFERTAS);

			setPreferredSize(new Dimension(762, 488));

			pa_listado.setBounds(10, 0, 500, 443);

			_panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista);
			_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);

			break;

		case Elemento_A_Listar.C_ANALIZAR_SOLICITUDES:
			panel_QueTieneLaLista = new Elementos_Listados(listaDeElementosListables,
					Elemento_A_Listar.C_ANALIZAR_SOLICITUDES);

			setPreferredSize(new Dimension(762, 488));

			pa_listado.setBounds(10, 0, 500, 443);

			_panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista);
			_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);

			break;

		case Elemento_A_Listar.C_BUSCAR_CANDIDATOS:
			panel_QueTieneLaLista = new Elementos_Listados(listaDeElementosListables,
					Elemento_A_Listar.C_BUSCAR_CANDIDATOS);
			setPreferredSize(new Dimension(762, 488));

			pa_listado.setBounds(10, 0, 500, 443);

			_panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista);
			_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);
			add(_panelBotonAtrasYAlante);

			JScrollPane pa_filtrosCandidato = new PanelFiltrosCandidato();
			pa_filtrosCandidato.setBounds(512, 0, 247, 482);
			add(pa_filtrosCandidato);
			break;

		}
		pa_listado.setViewportView(panel_QueTieneLaLista);
		add(pa_listado);
		add(_panelBotonAtrasYAlante);

	}
	
}
