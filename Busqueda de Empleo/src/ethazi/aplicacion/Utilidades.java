package ethazi.aplicacion;

import java.util.ArrayList;

import ethazi.intefaz.Elemento_Listable;

/**
 * 
 * @author Jonor
 *
 */
public class Utilidades {
	/**
	 * The utility class has different static methods accessible from any part of
	 * the program that performs various functions
	 * 
	 * @param p_ofertas
	 * @return
	 */
	public static ArrayList<Elemento_Listable> cambiarOfertaAElemento(ArrayList<Oferta> p_ofertas) {
		ArrayList<Elemento_Listable> _elementos = new ArrayList<>();

		for (Oferta oferta : p_ofertas) {
			_elementos.add(oferta);
		}

		return _elementos;
	}

}
