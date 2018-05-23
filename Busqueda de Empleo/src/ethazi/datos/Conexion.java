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
	private static final String C_USUARIO = "root";
	private static final String C_CONTRASENA = "";
	private static final String C_URL = "jdbc:mysql://localhost:3306/ethazi";

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
	 * Metodo que vale para hacer actualizaciones (Insert, Delete o Update) a la
	 * base de datos
	 * 
	 * @param sql
	 *            Recibe como parametro la instruccion SQL en forma de String
	 * @return Devuelve (1) si la actualizacion ha afectado a alguna fila, o (0) si
	 *         no ha afectado a ninguna fila
	 * @throws SQLException
	 *             Si ha habido algun error en la base de datos o en la consulta
	 */
	public int actualizar(String sql) throws SQLException {
		Statement _comando = miConexion.createStatement();
		return _comando.executeUpdate(sql.toUpperCase());
	}

	/**
	 * Metodo que vale para hacer consultas (Select) a la base de datos
	 * 
	 * @param sql
	 *            Recibe como parametro la instruccion SQL en forma de String
	 * @return Devuelve el resultado de la consulta en forma de ResultSet
	 * @throws SQLException
	 *             Si ha habido algun error en la base de datos o en la consulta
	 */
	public static ResultSet consultar(String sql) throws SQLException {
		Statement _comando = miConexion.createStatement();
		return _comando.executeQuery(sql.toUpperCase());
	}

}
