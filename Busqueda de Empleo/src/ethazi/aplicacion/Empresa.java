package ethazi.aplicacion;

public class Empresa extends Usuario {

	private String miContacto;
	private String miDescripcion;

	public Empresa(String miNick, String miPassword, String miNombre, String miNumID, String miDireccion,
			String miEmail, String miTelefono, String miContacto, String miDescripcion) {
		super(miNick, miPassword, miNombre, miNumID, miDireccion, miEmail, miTelefono);
		this.miContacto = miContacto;
		this.miDescripcion = miDescripcion;
	}

	public String getContacto() {
		return miContacto;
	}

	public void setContacto(String miContacto) {
		this.miContacto = miContacto;
	}

	public String getDescripcion() {
		return miDescripcion;
	}

	public void setDescripcion(String p_descripcion) {
		this.miDescripcion = p_descripcion;
	}

}
