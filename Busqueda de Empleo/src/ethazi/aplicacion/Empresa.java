package ethazi.aplicacion;

import java.util.ArrayList;
import java.util.Calendar;

public class Empresa extends Usuario {

	private String miContacto;
	private String miDescripcion;
	private ArrayList<Oferta> miOfertas;

	public Empresa(String miNick, String miPassword, String miNombre, String miNumID, String miDireccion,
			String miEmail, String miTelefono, byte miAniosExp, String miContacto, String miDescripcion,
			ArrayList<Oferta> miOfertas) throws NullPointerException {
		super(miNick, miPassword, miNombre, miNumID, miDireccion, miEmail, miTelefono, miAniosExp);
		this.miContacto = miContacto;
		this.miDescripcion = miDescripcion;
		this.miOfertas = miOfertas;
	}
	
	public void aniadirOferta(Oferta oferta) {
		miOfertas.add(oferta);
	}
	public void borrarOferta(Oferta oferta) {

	}

	public String getMiContacto() {
		return miContacto;
	}



	public void setMiContacto(String miContacto) {
		this.miContacto = miContacto;
	}



	public String getMiDescripcion() {
		return miDescripcion;
	}



	public void setMiDescripcion(String miDescripcion) {
		this.miDescripcion = miDescripcion;
	}



	public void publicarOferta(Oferta p_Oferta) {

	}

	public void crearConocimiento(String p_Conocimiento) {

	}

	public ArrayList<Oferta> consultarMisOfertas() {
		ArrayList<Oferta> _ofertas = null;
		return _ofertas;
	}

	public ArrayList<Candidato> buscarCandidatos(Calendar _FechaDeNacimiento, boolean _Coche, boolean _CarnetConducir,
			boolean _DisponibilidadParaViajar, ArrayList<String> _Conocimientos, String _OtrosConocimientos, byte _ExperienciaLaboral, String _VidaLaboral) {
		ArrayList<Candidato> _candidatos = null;
		return _candidatos;
	}
	
	public ArrayList<Oferta> verOfertasConSolicitud(){
		ArrayList<Oferta> _ofertas = null;
		return _ofertas;
		
	}
	
	public void guardarCurriculum(Candidato _perfil) {
		
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
