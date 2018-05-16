package ethazi.intefaz;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Elementos_Listados extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1617775952182198487L;
	public final static int C_PANELESTOTALES=10;

	public Elementos_Listados(ArrayList<Elemento_A_Listar> arrayElementosListables) {
		setLayout(null);
		setAlignmentX(0);
		setAlignmentY(0);
		setPreferredSize(new Dimension(600,1050));
		for(int i=0, coordenada=0;i< C_PANELESTOTALES;i++,coordenada+=100)
		{
			arrayElementosListables.get(i).setBounds(10,coordenada,500,91);
			add(arrayElementosListables.get(i));
		}
		
			
		
	}

}
