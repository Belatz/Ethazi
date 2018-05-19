package ethazi.aplicacion;

import java.util.ArrayList;

public class Empresa extends Usuario {

	private String miContacto;
	private String miDescripcion;
	private ArrayList<Oferta> miOfertas;

	public Empresa(String miNick, String miPassword, String miNombre, String miNumID, String miDireccion,
			String miEmail, String miTelefono, byte miAniosExp, String miContacto, String miDescripcion,
			ArrayList<Oferta> miOfertas) throws NullPointerException {
		super(miNick, miPassword, miNombre, miNumID, miDireccion, miEmail, miTelefono);
		this.miContacto = miContacto;
		this.miDescripcion = miDescripcion;
		this.miOfertas = miOfertas;
	}

	public void aniadirOferta(Oferta oferta) {
		miOfertas.add(oferta);
	}

	public void borrarOferta(Oferta oferta) {

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
