package ethazi.aplicacion;

import java.util.ArrayList;

public abstract class Usuario {
	private String miNick;
	private String miPassword;
	private String miNombre;
	private String miNumID;
	private String miDireccion;
	private String miEmail;
	private String miTelefono;
	private byte miAniosExp;
	public static ArrayList<String> miConocimientosTotales;

	public Usuario(String miNick, String miPassword, String miNombre, String miNumID, String miDireccion,
			String miEmail, String miTelefono, byte miAniosExp) throws NullPointerException {
		super();
		this.miNick = miNick;
		this.miPassword = miPassword;
		this.miNombre = miNombre;
		this.miNumID = miNumID;
		this.setMiDireccion(miDireccion);
		this.miEmail = miEmail;
		this.miTelefono = miTelefono;
		this.miAniosExp = miAniosExp;
	}
	
	public String getMiNick() {
		return miNick;
	}

	public void setMiNick(String miNick) {
		this.miNick = miNick;
	}

	public String getMiPassword() {
		return miPassword;
	}

	public void setMiPassword(String miPassword) {
		this.miPassword = miPassword;
	}

	public String getMiNombre() {
		return miNombre;
	}

	public void setMiNombre(String miNombre) {
		this.miNombre = miNombre;
	}

	public String getMiNumID() {
		return miNumID;
	}

	public void setMiNumID(String miNumID) {
		this.miNumID = miNumID;
	}

	public String getMiDireccion() {
		return miDireccion;
	}

	public void setMiDireccion(String miDireccion) {
		this.miDireccion = miDireccion;
	}

	public String getMiEmail() {
		return miEmail;
	}

	public void setMiEmail(String miEmail) {
		this.miEmail = miEmail;
	}

	public String getMiTelefono() {
		return miTelefono;
	}

	public void setMiTelefono(String miTelefono) {
		this.miTelefono = miTelefono;
	}

	public byte getMiAniosExp() {
		return miAniosExp;
	}

	public void setMiAniosExp(byte miAniosExp) {
		this.miAniosExp = miAniosExp;
	}

	public static ArrayList<String> getMiConocimientosTotales() {
		return miConocimientosTotales;
	}

	public static void setMiConocimientosTotales(ArrayList<String> miConocimientosTotales) {
		Usuario.miConocimientosTotales = miConocimientosTotales;
	}

	//Titulo puede ser solo una parte de el titulo y que el sistema busque titulos que lo contengan
	public static void consultarOfertas( String _titulo, String _Lugar, Contrato _Tipo,
		Empresa _Empresa, int _SueldoMax,int _SueldoMin, byte _AniosExp,
		ArrayList<Conocimiento> _Conocimientos) {
		
	}

	public void analizarEmpresa(Empresa _empresa) {
		
	}
	
	public void abrirOferta() {
		
	}

	public abstract void editarPerfil ();
	public abstract void verPerfil();
}
