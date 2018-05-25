package ethazi.aplicacion;

import java.util.ArrayList;

import ethazi.intefaz.Elemento_Listable;

public class Utilidades {
	
	public static ArrayList<Elemento_Listable> cambiarOfertaAElemento(ArrayList<Oferta> p_ofertas) {
		ArrayList<Elemento_Listable> _elementos = new ArrayList<>();
		
		for (Oferta oferta : p_ofertas) {
			_elementos.add(oferta);
		}
		
		return _elementos;
	}

}
