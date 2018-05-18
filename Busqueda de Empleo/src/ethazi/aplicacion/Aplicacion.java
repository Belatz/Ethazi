package ethazi.aplicacion;

import java.awt.EventQueue;

import ethazi.intefaz.frame.VentanaIdentificarse;

public class Aplicacion {

	private static Usuario miUsuario;
	private static Conexion miConexion;

	public static void main(String[] args) {
		miConexion = new Conexion();
		VentanaIdentificarse.ejecutar();
	}

	public static Usuario getUsuario() {
		return miUsuario;
	}

	public static void setUsuario(Usuario usr) {
		miUsuario = usr;
	}
	
	public static Conexion getConexion() {
		return miConexion;
	}

}
