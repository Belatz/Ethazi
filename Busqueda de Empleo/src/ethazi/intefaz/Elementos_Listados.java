package ethazi.intefaz;

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
		setPreferredSize(new Dimension(400, 1200));
		for(int i=0;i<C_PANELESTOTALES;i++)
		{
			arrayElementosListables.get(i);
		}
		for(int i=0, coordenada=60;i< C_PANELESTOTALES;i++,coordenada+=100)
			add(arrayElementosListables.get(i)).setBounds(10,coordenada,450,91);
	}

}
