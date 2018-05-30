package ethazi.aplicacion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ethazi.datos.UtilidadesBD;

import ethazi.intefaz.Elemento_Listable;

import ethazi.intefaz.paneles.GenericoDePanelesConLista;


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
	public static boolean dniCorrecto(String dNI)
	{
		boolean correcto=true;
		if(dNI.length()!=9)
			correcto=false;
		else
			if(dNI.toLowerCase().charAt(dNI.length()-1)<'a' || dNI.toLowerCase().charAt(dNI.length()-1)>'z' )
				correcto=false;
			else
			{
				int i=0;
				while(i<dNI.length()-1 && (dNI.charAt(i)>='0' || dNI.charAt(i)<='9'))
					i++;
				if(i==dNI.length()-1 && "TRWAGMYFPDXBNJZSQVHLCKE".charAt(Integer.valueOf(dNI.substring(0, 8))%23)!=dNI.charAt(dNI.toUpperCase().length()-1))
					correcto=false;
			}
		return correcto;
	}
	public static boolean cifCorrecto(String cIF)
	{
		boolean correcto=true;
		if(cIF.length()!=9)
			correcto=false;
		else
			if(cIF.toLowerCase().charAt(0)<'a' || cIF.toLowerCase().charAt(0)>'z')
				correcto=false;
			else
			{
				int i=1;
				while(i<cIF.length()-1 && (cIF.charAt(i)>='0' && cIF.charAt(i)<='9'))
					i++;
				if(i<cIF.length()-1)
					correcto=false;
				else
				{
					int comp=0;
					for(int j=1;j<cIF.length()-1;j++)
					{
						if(j%2==0)
							comp+=Integer.valueOf(cIF.charAt(j)-'0');
						else
							comp+=sumaCifras(Integer.valueOf(cIF.charAt(j)-'0')*2);
					}
					comp=10-comp%10;
					switch(cIF.toLowerCase().charAt(0))
					{
					case 'k':case 'p': case'q': case 's':
					{
						if(cIF.charAt(cIF.length()-1)!=64+comp)
							correcto=false;
					}break;
					case 'x':
					{
						if("TRWAGMYFPDXBNJZSQVHLCKE".charAt(Integer.valueOf(cIF.substring(1, 8))%23)!=cIF.charAt(cIF.toUpperCase().length()-1))
							correcto=false;
					}break;
					default:
						if(Integer.valueOf(cIF.charAt(cIF.length()-1)-'0')!=comp)
							correcto=false;
						break;
					}
				}
			}
		return correcto;
	}
	private static int sumaCifras(int num)
	{
		int suma=0;
		int i=0, aux=num;
		while(num>=10)
		{
			num/=10;
			i++;
		}
		for(;i>0;i--)
			suma+=aux/Math.pow(10, i);
		suma+=aux%10;
		return suma;
	}
	public static boolean correoValido(String email)
	{
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher match=pattern.matcher(email);
		return match.find();
	}
	public static boolean telefonoValido(String tel)
	{
		boolean correcto=false;
		if(tel.length()==9 && (tel.charAt(0)=='6' || tel.charAt(0)=='7' || tel.charAt(0)=='8' || tel.charAt(0)=='9'))
		{
			int i=1;
			while(i<tel.length() && (tel.charAt(i)>='0' && tel.charAt(i)<='9'))
				i++;
			if(i==tel.length())
				correcto=true;
		}
		return correcto;
	}
	public static boolean esUsuario(String nick)
	{
		boolean existe=false;
		try {
			if(UtilidadesBD.toUsuario(nick, true)!=null)
				existe=true;
			else
				if(UtilidadesBD.toUsuario(nick, false)!=null)
					existe=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existe;
	}
	 
	public static void filtrarOfertas(ArrayList<Elemento_Listable> listaDeElementos,
			GenericoDePanelesConLista panelListadoGenerico,	String titulo, String lugar,
			String salarioMax, String salarioMin, String experiencia, int contrato,
			String empresa, ArrayList<String> conocimientos) {

			try {
				listaDeElementos = Utilidades.cambiarOfertaAElemento(UtilidadesBD.filtrarOfertas(titulo,
						lugar, salarioMax, salarioMin, experiencia, contrato, empresa, conocimientos));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}	
	//TODO arreglar
	public static boolean empresaExiste(String nombre)
	{
		boolean existe=true;
		try {
			if(UtilidadesBD.toEmpresa(nombre)==null)
				existe=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existe;
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

    public static boolean candidatoExisteDNI(String dNI)
	{
		boolean existe=true;
		try {
			if(UtilidadesBD.toCandidatoDNI(dNI)==null)
				existe=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existe;
	}
	public static boolean empresaExisteCif(String cIF)
	{
		boolean existe=true;
		try {
			if(UtilidadesBD.toEmpresaCif(cIF)==null)
				existe=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existe;
	}
	public static boolean existeCorreo(String email)
	{
		boolean existe=true;
		try {
			if(UtilidadesBD.toUsuario(email)==null)
				existe=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existe;
	}
}
