package ethazi.intefaz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PaneldePOfertas extends JPanel  {

	/*
	 * JOn: este objeto debera recibir los datos que volcara dinamicamente en subpaneles
	 * la dimension es asta donde se podra hacer scroll
	 * lostPofer es un array de subpaneles que los generara dinamicamente en  
	 * funcion de los parametros
	 * la cordenada es en que punto vertical aparece el siguiente subpanel*/

	ArrayList<PanelOferta> listPOfer;
	private PanelOferta pofer;

	public PaneldePOfertas() {
		int cont = 0;

		setLayout(null);
		setPreferredSize(new Dimension(400, 1200));
		listPOfer = new ArrayList<PanelOferta>();
		while (cont < 10) {

			pofer = new PanelOferta();
			listPOfer.add(pofer);
			cont++;
		}
		iniciarComponentes();

	}

	private void iniciarComponentes() {
		int cordenada = 60;
		int cont = 0;
		while (cont < 10) {
			add(listPOfer.get(cont));
			listPOfer.get(cont).setBounds(10, cordenada, 450, 91);
			cordenada = cordenada + 100;
			cont++;
		}

	}


}
