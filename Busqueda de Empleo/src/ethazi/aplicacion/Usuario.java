package ethazi.aplicacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Usuario {
	public static ArrayList<String> misConocimientosTotales;
	//Ejemplo
	{
		misConocimientosTotales=new ArrayList<String>();
		misConocimientosTotales.add("Java");
		misConocimientosTotales.add("C");
		misConocimientosTotales.add("C++");
	}
	private String miNumID;
	private String miNick;
	private String miPassword;
	private String miNombre;
	private String miDireccion;
	private String miEmail;
	private String miTelefono;

	public Usuario(String miNumID, String miNick, String miPassword, String miNombre, String miDireccion,
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

	public void setNombre(String p_nombre) {
		this.miNombre = p_nombre;
	}

	public String getNumID() {
		return miNumID;
	}

	public void setNumID(String p_numID) {
		this.miNumID = p_numID;
	}

	public String getEmail() {
		return miEmail;
	}

	public void setEmail(String p_email) {
		this.miEmail = p_email;
	}

	public String getTelefono() {
		return miTelefono;
	}

	public void setTelefono(String p_telefono) {
		this.miTelefono = p_telefono;
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

	public static ArrayList<String> getConocimientosTotales() {
		return misConocimientosTotales;
	}

	public static void setConocimientosTotales(ArrayList<String> miConocimientosTotales) {
		Usuario.misConocimientosTotales = miConocimientosTotales;
	}

	/**
	 * Checks if the Usuario is Candidato or Empresa
	 * 
	 * @param p_nick The nick of the Usuario
	 * @return True if it's Candidato, False if it's Empresa
	 * @throws SQLException
	 * @author belatz
	 */
	public static boolean esCandidato(String p_nick) throws SQLException {
		ResultSet _rs;
		Aplicacion.getConexion();
		_rs = Conexion.consultar("SELECT * FROM candidato WHERE numid='" + p_nick + "';");
		return _rs.next();
	}

}
