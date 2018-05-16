package ethazi.intefaz.paneles;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ethazi.aplicacion.Oferta;
import ethazi.intefaz.Elemento_A_Listar;
import ethazi.intefaz.Elementos_Listados;


public class PanelConsultarOfertas extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelConsultarOfertas(ArrayList<Oferta> ofertas) {
		setPreferredSize(new Dimension(762,488));
		setLayout(null);
		int cont=0;
		ArrayList<Elemento_A_Listar> pOfertas = new ArrayList();
		Elemento_A_Listar aux;
		while(cont < ofertas.size()) {
			aux = new Elemento_A_Listar(ofertas.get(cont), (byte) 1);
			pOfertas.add(aux);
			cont++;
		}
		/* Lanzar panel de listado */
		JScrollPane pa_listado = new JScrollPane();
		Elementos_Listados panel_QueTieneLaLista = new Elementos_Listados(pOfertas);

		pa_listado.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pa_listado.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pa_listado.setBounds(10, 0, 500, 443);
		pa_listado.getVerticalScrollBar().setUnitIncrement(16);
		pa_listado.setViewportView(panel_QueTieneLaLista);
		// getContentPane().add(scroll);
		add(pa_listado);
		
		/* Lanzar panel de filtros */
		JScrollPane pa_filtros = new PanelFiltrosOferta();
		pa_filtros.setBounds(512, 0, 247, 482);
		add(pa_filtros);
		
		/* Lanzar panel de atras y alante */
		JPanel _panelBotonAtrasYAlante = new PanelAtrasAlante(PanelAtrasAlante.C_CENTRAL);
		_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);
		// _panelBotonAtrasYAlante.setBackground(Color.RED);
		add(_panelBotonAtrasYAlante);
	}

}
