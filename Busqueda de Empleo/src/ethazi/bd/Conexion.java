package ethazi.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	/*
	 * =====================
	 * 
	 * Drive>Grupo1>Docu General>De interes
	 * 
	 * Para importarlo: Click derecho en el proyecto, buid path, add externar
	 * archives
	 * 
	 * =====================
	 */

	private static Connection miConexion;

	private static final String C_DRIVER = "com.mysql.jdbc.Driver";
	private static final String C_USUARIO = "root";
	private static final String C_CONTRASENA = "";
	private static final String C_URL = "jdbc:mysql://localhost:3306/ethazi";

	public Conexion() {
		miConexion = null;
		try {
			Class.forName(C_DRIVER);
			miConexion = DriverManager.getConnection(C_URL, C_USUARIO, C_CONTRASENA);

			if (miConexion != null) {
				System.out.println("Conexion con la base de datos establecida...");
			}
		} catch (Exception e) {
			System.out.println("Error al conectar a la base de datos: " + e);
		}
	}

	public Connection getConexion() {
		return miConexion;
	}

	public void desconectar() {
		miConexion = null;
		if (miConexion == null) {
			System.out.println("Conexion con la base de datos terminada..");
		}
	}

}
