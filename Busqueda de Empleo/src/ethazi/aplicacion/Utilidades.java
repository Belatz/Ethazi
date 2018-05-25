package ethazi.aplicacion;

import java.util.ArrayList;

import ethazi.intefaz.Elemento_Listable;

public abstract class Utilidades {
	
	/**
	 * @author Belatz
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
	
	/**
	 * @author Belatz
	 * @param p_solicitudes
	 * @return
	 */
	public static ArrayList<Elemento_Listable> cambiarSolicitudAElemento(ArrayList<Solicitud> p_solicitudes) {
		ArrayList<Elemento_Listable> _elementos = new ArrayList<>();
		
		for (Solicitud solitud : p_solicitudes) {
			_elementos.add(solitud);
		}
		
		return _elementos;
	}

}
