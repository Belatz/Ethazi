package ethazi.aplicacion;

import java.util.ArrayList;
import java.util.Calendar;

public class Candidato extends Usuario {

	private String apellidos;
	private Calendar fechaNac;
	private boolean carnet;
	private boolean cochePropio;
	private boolean disViajar;
	private String estudios;
	private ArrayList<String> conocimientos;
	private String otrosConocimientos;
	private String vidaLaboral;
	private byte experienciaProfesional;

	public Candidato(String miNick, String miPassword, String miNombre, String miNumID, String miDireccion,
			String miEmail, String miTelefono, byte miAniosExp) throws NullPointerException {
		super(miNick, miPassword, miNombre, miNumID, miDireccion, miEmail, miTelefono, miAniosExp);
		// TODO Auto-generated constructor stub
	}

	public void realizarSolicitud(Oferta oferta) {

	}
	
	public static ArrayList<String> consulConoMasDemand(){
		ArrayList<String> conMasDemand = null;
		return conMasDemand;
		
	}
	
	public ArrayList<Oferta> consulOfertasAdecuadas() {
		ArrayList<Oferta> ofertasAdecuadas = null;
		return ofertasAdecuadas;
	}

	@Override
	public void editarPerfil() {
		// TODO Auto-generated method stub

	}

	@Override
	public void verPerfil() {
		// TODO Auto-generated method stub

	}

}
