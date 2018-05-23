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
