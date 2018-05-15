package ethazi.aplicacion;

import ethazi.bd.Conexion;

public class Aplicacion {

	private static Usuario miUsuario;
	
	public static void main(String[] args) {
		// Llamar a ventanaidentificarse, coger el usuario, llamar a ventana principal
		Conexion conn = new Conexion();
		conn.desconectar();
	}
	
	public static Usuario getUsuario() {
		return miUsuario;
	}

}
