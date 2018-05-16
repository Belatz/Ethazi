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
		this.miDireccion = miDireccion;
		this.miEmail = miEmail;
		this.miTelefono = miTelefono;
		this.miAniosExp = miAniosExp;
	}

	protected String getNick() {
		return miNick;
	}

	protected void setNick(String p_nick) {
		this.miNick = p_nick;
	}

	protected String getPassword() {
		return miPassword;
	}

	protected void setPassword(String p_password) {
		this.miPassword = p_password;
	}

	protected String getNombre() {
		return miNombre;
	}

	protected void setNombre(String p_nombre) {
		this.miNombre = p_nombre;
	}

	protected String getNumID() {
		return miNumID;
	}

	protected void setNumID(String p_numID) {
		this.miNumID = p_numID;
	}

	protected String getEmail() {
		return miEmail;
	}

	protected void setEmail(String p_email) {
		this.miEmail = p_email;
	}

	protected String getTelefono() {
		return miTelefono;
	}

	protected void setTelefono(String p_telefono) {
		this.miTelefono = p_telefono;
	}

	protected byte getAniosExp() {
		return miAniosExp;
	}

	protected void setAniosExp(byte p_aniosExp) {
		this.miAniosExp = p_aniosExp;
	}
	public String getDireccion() {
		return miDireccion;
	}

	public void setDireccion(String p_direccion) {
		this.miDireccion = p_direccion;
	}
	
}
