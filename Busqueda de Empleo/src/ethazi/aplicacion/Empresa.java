package ethazi.aplicacion;

import java.util.ArrayList;

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
	
	@Override
	public void editarPerfil() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void verPerfil() {
		// TODO Auto-generated method stub
		
	}
	
	
}


