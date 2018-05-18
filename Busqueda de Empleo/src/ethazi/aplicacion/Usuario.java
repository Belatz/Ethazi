package ethazi.aplicacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {
	private String miNick;
	private String miPassword;
	private String miNombre;
	private String miNumID;
	private String miDireccion;
	private String miEmail;
	private String miTelefono;
	public static ArrayList<String> miConocimientosTotales;

	public Usuario(String miNick, String miPassword, String miNombre, String miNumID, String miDireccion,
			String miEmail, String miTelefono) throws NullPointerException {
		super();
		this.miNick = miNick;
		this.miPassword = miPassword;
		this.miNombre = miNombre;
		this.miNumID = miNumID;
		this.miDireccion = miDireccion;
		this.miEmail = miEmail;
		this.miTelefono = miTelefono;
	}
	
	public String getNick() {
		return miNick;
	}

	public void setNick(String miNick) {
		this.miNick = miNick;
	}

	public String getPassword() {
		return miPassword;
	}

	public void setPassword(String miPassword) {
		this.miPassword = miPassword;
	}

	public String getNombre() {
		return miNombre;
	}
	public void setNombre(String miNombre) {
		this.miNombre = miNombre;
	}

	public String getNumID() {
		return miNumID;
	}

	public void setNumID(String miNumID) {
		this.miNumID = miNumID;
	}

	public String getDireccion() {
		return miDireccion;
	}

	public void setDireccion(String p_direccion) {
		this.miDireccion = p_direccion;
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

	public static boolean esCandidato(String p_nick) throws SQLException {
		ResultSet _rs;
		_rs = Aplicacion.getConexion().consultar("SELECT COUNT(*) FROM candidato WHERE nick='" + p_nick + "';");
		return _rs.next();
	}
	
}