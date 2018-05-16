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
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Calendar getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Calendar fechaNac) {
		this.fechaNac = fechaNac;
	}

	public boolean isCarnet() {
		return carnet;
	}

	public void setCarnet(boolean carnet) {
		this.carnet = carnet;
	}

	public boolean isCochePropio() {
		return cochePropio;
	}

	public void setCochePropio(boolean cochePropio) {
		this.cochePropio = cochePropio;
	}

	public boolean isDisViajar() {
		return disViajar;
	}

	public void setDisViajar(boolean disViajar) {
		this.disViajar = disViajar;
	}

	public String getEstudios() {
		return estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}

	public ArrayList<String> getConocimientos() {
		return conocimientos;
	}

	public void setConocimientos(ArrayList<String> conocimientos) {
		this.conocimientos = conocimientos;
	}

	public String getOtrosConocimientos() {
		return otrosConocimientos;
	}

	public void setOtrosConocimientos(String otrosConocimientos) {
		this.otrosConocimientos = otrosConocimientos;
	}

	public String getVidaLaboral() {
		return vidaLaboral;
	}

	public void setVidaLaboral(String vidaLaboral) {
		this.vidaLaboral = vidaLaboral;
	}

	public byte getExperienciaProfesional() {
		return experienciaProfesional;
	}

	public void setExperienciaProfesional(byte experienciaProfesional) {
		this.experienciaProfesional = experienciaProfesional;
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
