package ethazi.aplicacion;

import java.util.ArrayList;

import ethazi.intefaz.Elemento_Listable;

public class Candidato extends Usuario implements Elemento_Listable {

	private String apellidos;
	private String fechaNac;
	private boolean carnet;
	private boolean cochePropio;
	private boolean disViajar;
	private String estudios;
	private ArrayList<String> conocimientos;
	private String otrosConocimientos;
	private String vidaLaboral;
	private float experienciaProfesional;

	public Candidato(String miNick, String miPassword, String miNombre, String miNumID, String miDireccion,
			String miEmail, String miTelefono, String apellidos, String fechaNac, boolean carnet, boolean cochePropio,
			boolean disViajar, String estudios, ArrayList<String> conocimientos, String otrosConocimientos,
			String vidaLaboral, float experienciaProfesional) {
		super(miNumID, miNick, miPassword, miNombre, miDireccion, miEmail, miTelefono);
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.carnet = carnet;
		this.cochePropio = cochePropio;
		this.disViajar = disViajar;
		this.estudios = estudios;
		this.conocimientos = conocimientos;
		this.otrosConocimientos = otrosConocimientos;
		this.vidaLaboral = vidaLaboral;
		this.experienciaProfesional = experienciaProfesional;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public boolean hasCarnet() {
		return carnet;
	}

	public void setCarnet(boolean carnet) {
		this.carnet = carnet;
	}

	public boolean hasCochePropio() {
		return cochePropio;
	}

	public void setCochePropio(boolean cochePropio) {
		this.cochePropio = cochePropio;
	}

	public boolean hasDisViajar() {
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

	public float getExperienciaProfesional() {
		return experienciaProfesional;
	}

	public void setExperienciaProfesional(float experienciaProfesional) {
		this.experienciaProfesional = experienciaProfesional;
	}

	@Override
	public String getInfo() {
		return getNombre() + " " + apellidos;
	}
}
