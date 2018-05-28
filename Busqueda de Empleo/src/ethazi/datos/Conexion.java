package ethazi.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Makes the connection between the app and the database
 * 
 * @author belatz
 * @category DataBase
 */
public class Conexion {
	// TODO constantes y toUpper
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
	private static final String C_USUARIO = "kk";
	private static final String C_CONTRASENA = "1234";
	private static final String C_URL = "jdbc:mysql://192.168.14.10:3306/ethazi";

	public Conexion() {
		miConexion = null;
		try {
			Class.forName(C_DRIVER); //No es necesario
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
		miConexion = null; //MAL
		if (miConexion == null) {
			System.out.println("Conexion con la base de datos terminada..");
		}
	}

	/**
	 * This method is used to update (Insert, Delete o Update) to the data base
	 * 
	 * @param sql
	 *            Returns as parameter the instruction SQL as String
	 * @return Returns (1) if the update has affected to any line or (0) if not.
	 * @throws SQLException
	 *             If there has been any error in the data base or in the query
	 */
	public static int actualizar(String sql) throws SQLException {
		Statement _comando = miConexion.createStatement();
		return _comando.executeUpdate(sql);
	}

	/**
	 * This method is used to make queries (Select) to the data base
	 * 
	 * @param sql
	 *            Receives as parameter the SQL instruction as String
	 * @return Returns the query's result as ResultSet
	 * @throws SQLException
	 *             If there has been any error in the data base or in the query
	 */
	public static ResultSet consultar(String sql) throws SQLException {
		Statement _comando = miConexion.createStatement();
		System.out.println("Realiar consulta: "+sql+" ...");
		return _comando.executeQuery(sql);
	}
}
