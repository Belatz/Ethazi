package ethazi.aplicacion;

import java.sql.SQLException;

import ethazi.datos.Conexion;
import ethazi.datos.UtilidadesBD;
import ethazi.intefaz.frame.VentanaIdentificarse;
import ethazi.intefaz.frame.VentanaPrincipal;

/**
 * @author Belatz Arce, Xabier Cabezuelo, Nestor Echebarria, Eduardo Garcia,
 *         Urtzi Lamikiz, Jon Ortigueira
 */
public class Aplicacion {
	/**
	 * This is the main class that start all the project
	 */

	private static Usuario miUsuario;
	private static Conexion miConexion;

	public static void main(String[] args) {
		System.out.println("ola");
		try {
			miConexion = new Conexion();
			Usuario.setConocimientosTotales(UtilidadesBD.descargarConocimientos());

			VentanaPrincipal.ejecutar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method return user name
	 * 
	 * @return miUsuario
	 */

	public static Usuario getUsuario() {
		return miUsuario;
	}

	/**
	 * Method save the user name as usr parameter
	 * 
	 * @param usr
	 */
	public static void setUsuario(Usuario usr) {
		miUsuario = usr;
	}

	/**
	 * Method return connection state
	 * 
	 * @return miConexion
	 */
	public static Conexion getConexion() {
		return miConexion;
	}

}
