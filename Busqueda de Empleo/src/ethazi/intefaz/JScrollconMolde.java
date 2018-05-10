package ethazi.intefaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class JScrollconMolde extends JScrollPane {


	PaneldePOfertas pOfertas;
	/*
	 * jon:este objeto JScrollconMolde ya viene con un panel que a su vez tiene un
	 * array de paneles dinamicos, solo se necesita declarar, iniciar y añadirlo a algun sitio
	 * se puede hacer que el constructor reciva todos los parametros de configuracion
	 * para mantener las clases ventanas mas limpias, o se puede configurar desde la ventana
	 * como cualquier otro scrollpane
	 * abra que pasarle a este los parametros necesarios de la oferta solicitud etc...
	 * 
	 */
	public JScrollconMolde() {
		pOfertas = new PaneldePOfertas();
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.setBounds(5, 50, 500, 500);
		this.getVerticalScrollBar().setUnitIncrement(16);
		this.setViewportView(pOfertas);
	}


}
