package ethazi.aplicacion;

import java.sql.SQLException;
import java.util.ArrayList;

import ethazi.datos.UtilidadesBD;
import ethazi.excepciones.PanelNoDisponible;
import ethazi.intefaz.Elemento_Listable;
import ethazi.intefaz.frame.VentanaPrincipal;
import ethazi.intefaz.paneles.GenericoDePanelesConLista;
import ethazi.intefaz.paneles.PanelBarraHerramientas;

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
	 * @author Jon
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
	
	public static void  buscarOfertasAdecuadas(ArrayList<Elemento_Listable> listaDeElementos, GenericoDePanelesConLista panelListadoGenerico) {
		try {
			listaDeElementos = UtilidadesBD.buscarOfertas(PanelBarraHerramientas.getTxField_buscar());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void filtrarOfertas(ArrayList<Elemento_Listable> listaDeElementos,
			GenericoDePanelesConLista panelListadoGenerico,	String titulo, String lugar,
			String salarioMax, String salarioMin, String experiencia, String contrato,
			String empresa, ArrayList<String> conocimientos) {
		try {
			listaDeElementos = Utilidades.cambiarOfertaAElemento(UtilidadesBD.filtrarOfertas(titulo,
					lugar, salarioMax, salarioMin, experiencia, contrato, empresa, conocimientos));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*Esto es para los filtros
	 * try {
		VentanaPrincipal.setListaDeElementos(Utilidades.cambiarOfertaAElemento(UtilidadesBD.filtrarOfertas(null, null, null, null,
				String.valueOf(((Candidato)Aplicacion.getUsuario()).getExperienciaProfesional()), null, null,
				UtilidadesBD.descargarConocimientosCandidato(((Candidato)Aplicacion.getUsuario()).getNumID())))); 
		VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_BUSCAR_OFERTA);
		// TODO en el panel de consultar ofertas coger el texto de la barra((Candidato)Aplicacion.getUsuario()) de busqueda
	} catch (PanelNoDisponible | SQLException e2) {
		e2.printStackTrace();
	}*/
}
