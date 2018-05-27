package ethazi.aplicacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ethazi.datos.Conexion;

/**
 * 
 * @author Jonor
 *
 */

import ethazi.datos.Tablas;


public abstract class Usuario {
	/**
	 * Class gets and set user personal data 
	 */
	public static ArrayList<String> misConocimientosTotales;

	private String miNumID;
	private String miNick;
	private String miPassword;
	private String miNombre;
	private String miDireccion;
	private String miEmail;
	private String miTelefono;

	/**
	 * 
	 * @param miNumID
	 * @param miNick
	 * @param miPassword
	 * @param miNombre
	 * @param miDireccion
	 * @param miEmail
	 * @param miTelefono
	 * @throws NullPointerException
	 */
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

	/**
	 * 
	 * @return
	 */
	public String getNick() {
		return miNick;
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return miPassword;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return miNombre;
	}

	/**
	 * 
	 * @param p_nombre
	 */
	public void setNombre(String p_nombre) {
		this.miNombre = p_nombre;
	}

	/**
	 * 
	 * @return
	 */
	public String getNumID() {
		return miNumID;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return miEmail;
	}

	/**
	 * 
	 * @param p_email
	 */
	public void setEmail(String p_email) {
		this.miEmail = p_email;
	}

	/**
	 * 
	 * @return
	 */
	public String getTelefono() {
		return miTelefono;
	}

	/**
	 * 
	 * @param p_telefono
	 */
	public void setTelefono(String p_telefono) {
		this.miTelefono = p_telefono;
	}

	/**
	 * 
	 * @return
	 */
	public String getDireccion() {
		return miDireccion;
	}

	/**
	 * 
	 * @param p_direccion
	 */
	public void setDireccion(String p_direccion) {
		this.miDireccion = p_direccion;
	}

	/**
	 * 
	 * @return
	 */
	public static ArrayList<String> getConocimientosTotales() {
		return misConocimientosTotales;
	}

	/**
	 * 
	 * @param miConocimientosTotales
	 */
	public static void setConocimientosTotales(ArrayList<String> miConocimientosTotales) {
		Usuario.misConocimientosTotales = miConocimientosTotales;
	}

	/**
	 * Checks if the Usuario is Candidato or Empresa
	 * 
	 * @param p_nick
	 *            The nick of the Usuario
	 * @return True if it's Candidato, False if it's Empresa
	 * @throws SQLException
	 * @author belatz
	 */
	public static boolean esCandidato(String p_nick) throws SQLException {
		ResultSet _rs;
		_rs = Conexion.consultar("SELECT * FROM "+Tablas.C_CANDIDATO_TABLA+", "+Tablas.C_USUARIO_TABLA+" WHERE "+Tablas.C_USUARIO_NUMID+"="+Tablas.C_CANDIDATO_NUMID+" AND "+Tablas.C_USUARIO_NICK+"='" + p_nick + "';");
		return _rs.next();
	}

}
