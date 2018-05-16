package ethazi.aplicacion;

import java.awt.EventQueue;

import ethazi.bd.Conexion;
import ethazi.intefaz.frame.VentanaIdentificarse;
import ethazi.intefaz.frame.VentanaPrincipal;

public class Aplicacion {

	private static Usuario miUsuario;

	public static void main(String[] args) {
		// Llamar a ventanaidentificarse, coger el usuario, llamar a ventana principal
		Conexion conn = new Conexion();
		conn.desconectar();

		VentanaIdentificarse.ejecutar();
	}

	public static Usuario getUsuario() {
		return miUsuario;
	}

	public static void setUsuario(Usuario usr) {
		miUsuario = usr;
	}

}
