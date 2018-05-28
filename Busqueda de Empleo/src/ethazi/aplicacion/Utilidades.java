package ethazi.aplicacion;

import java.util.ArrayList;

import ethazi.intefaz.Elemento_Listable;

	/**
	 * The utility class has different static methods accessible from any part of
	 * the program that performs various functions
	 *
   */
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
	
	/**
	 * @author Belatz
	 * @param p_candidatos
	 * @return
	 */
	public static ArrayList<Elemento_Listable> cambiarCandidatoAElemento(ArrayList<Candidato> p_candidatos) {
		ArrayList<Elemento_Listable> _elementos = new ArrayList<>();
		
		for (Candidato candidato : p_candidatos) {
			_elementos.add(candidato);
		}
		
		return _elementos;
	}

}
