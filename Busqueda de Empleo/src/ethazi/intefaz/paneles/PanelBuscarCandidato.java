package ethazi.intefaz.paneles;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ethazi.intefaz.PaneldePOfertas;

public class PanelBuscarCandidato extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelBuscarCandidato() {
		setPreferredSize(new Dimension(762,488));
		setLayout(null);
		
		/* Lanzar panel de listado */
		JScrollPane pa_listado = new JScrollPane();
		PaneldePOfertas pOfertas_1 = new PaneldePOfertas();

		pa_listado.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pa_listado.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pa_listado.setBounds(10, 0, 500, 443);
		pa_listado.getVerticalScrollBar().setUnitIncrement(16);
		pa_listado.setViewportView(pOfertas_1);
		// getContentPane().add(scroll);
		add(pa_listado);
		
		/* Lanzar panel de filtros */
		JScrollPane pa_filtros = new PanelFiltrosCandidato();
		pa_filtros.setBounds(512, 0, 247, 482);
		add(pa_filtros);
		
		/* Lanzar panel de atras y alante */
		JPanel _panelBotonAtrasYAlante = new PanelAtrasAlante(PanelAtrasAlante.C_CENTRAL);
		_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);
		// _panelBotonAtrasYAlante.setBackground(Color.RED);
		add(_panelBotonAtrasYAlante);
	}

}
