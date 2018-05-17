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

	/**
	 * Create the panel.
	 */
	static ArrayList<Elemento_A_Listar> pOfertas = new ArrayList();
	static Elementos_Listados panel_QueTieneLaLista;
	public PanelConsultarOfertas(ArrayList<Elemento_Listable> ofertas) {
		setPreferredSize(new Dimension(762,488));
		setLayout(null);
		int cont = 0;
		int elemento = (1 * 10) - 10;
		int maxPags =  ((ofertas.size()/10) + (int)Math.pow(ofertas.size()%10, 0));
		int sobra = ofertas.size()%10;
		int aMostrar = 10;
	
		if (sobra!=0 && maxPags == 1) {
			aMostrar = sobra;
		}
		
		Elemento_A_Listar aux;
		while (cont < aMostrar) {
			aux = new Elemento_A_Listar(ofertas.get(elemento + cont), (byte) 1);
			pOfertas.add(aux);
			cont++;
		}
		panel_QueTieneLaLista = new Elementos_Listados(pOfertas, aMostrar);
		JScrollPane pa_listado = new JScrollPane();
		//Elementos_Listados panel_QueTieneLaLista = new Elementos_Listados(pOfertas);

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
		JPanel _panelBotonAtrasYAlante = new PanelAtrasAlante(ofertas, maxPags);
		_panelBotonAtrasYAlante.setBounds(10, 445, 500, 37);
			add(_panelBotonAtrasYAlante);
	}
	public static void mostrar10(ArrayList<Elemento_Listable> ofertas, int nPagina) {
		int cont = 0;
		pOfertas.clear();
		pOfertas = new ArrayList();
		int elemento = (nPagina * 10) - 10;
		int maxPags =  ((ofertas.size()/10) + (int)Math.pow(ofertas.size()%10, 0));
		int sobra = ofertas.size()%10;
		int aMostrar = 10;
	
		if (sobra!=0 && maxPags == nPagina) {
			aMostrar = sobra;
		}
		Elemento_A_Listar aux;
		while (cont < aMostrar) {
			aux = new Elemento_A_Listar(ofertas.get(elemento + cont), (byte) 1);
			pOfertas.add(aux);
			cont++;
		}
		panel_QueTieneLaLista.actualizar(pOfertas, aMostrar);;
		panel_QueTieneLaLista.updateUI();
	}

}
