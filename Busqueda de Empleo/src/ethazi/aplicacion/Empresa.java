package ethazi.aplicacion;

/**
 * @author Nestor, Belatz
 */

public class Empresa extends Usuario {
	/**
	 * When you register as company in the program empresa inherit methods and
	 * options from user
	 */

	private String miContacto;
	private String miDescripcion;

	/**
	 * 
	 * @param miNick
	 * @param miPassword
	 * @param miNombre
	 * @param miNumID
	 * @param miDireccion
	 * @param miEmail
	 * @param miTelefono
	 * @param miContacto
	 * @param miDescripcion
	 */
	
	public Empresa(String miNick, String miPassword, String miNombre, String miNumID, String miDireccion,
			String miEmail, String miTelefono, String miContacto, String miDescripcion) {
		super(miNumID, miNick, miPassword, miNombre, miDireccion, miEmail, miTelefono);
		this.miContacto = miContacto;
		this.miDescripcion = miDescripcion;
	}

	/**
	 * 
	 * @return
	 */
	public String getContacto() {
		return miContacto;
	}

	/**
	 * 
	 * @param miContacto
	 */
	public void setContacto(String miContacto) {
		this.miContacto = miContacto;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescripcion() {
		return miDescripcion;
	}

	/**
	 * 
	 * @param p_descripcion
	 */
	public void setDescripcion(String p_descripcion) {
		this.miDescripcion = p_descripcion;
	}

}
