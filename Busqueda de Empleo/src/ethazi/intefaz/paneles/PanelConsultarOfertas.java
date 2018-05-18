package ethazi.intefaz.paneles;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ethazi.aplicacion.Oferta;
import ethazi.intefaz.Elemento_A_Listar;
import ethazi.intefaz.Elemento_Listable;
import ethazi.intefaz.Elementos_Listados;


public class PanelConsultarOfertas extends JPanel {


	private static final long serialVersionUID = 1L;

	public PanelConsultarOfertas(ArrayList<Elemento_Listable> ofertas) {
		ArrayList<Elemento_A_Listar> pOfertas = new ArrayList<Elemento_A_Listar>();
		Elementos_Listados panel_QueTieneLaLista = new Elementos_Listados(ofertas, Elemento_A_Listar.C_CONSULTAR_OFERTAS);

		JScrollPane pa_listado = new JScrollPane();
		setPreferredSize(new Dimension(762,488));
		setLayout(null);

		pa_listado.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pa_listado.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pa_listado.setBounds(10, 0, 500, 443);
		pa_listado.getVerticalScrollBar().setUnitIncrement(16);
		pa_listado.setViewportView(panel_QueTieneLaLista);

		add(pa_listado);
		
		JScrollPane pa_filtros = new PanelFiltrosOferta();
		pa_filtros.setBounds(512, 0, 247, 482);
		add(pa_filtros);

		JPanel _panelBotonAtrasYAlante = new PanelAtrasAlante(panel_QueTieneLaLista);
		_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);
			add(_panelBotonAtrasYAlante);
	}


}
