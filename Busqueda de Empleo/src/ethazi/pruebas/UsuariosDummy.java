package ethazi.pruebas;

import java.sql.ResultSet;
import java.sql.SQLException;

import ethazi.aplicacion.Aplicacion;

public class UsuariosDummy {

	public static void crear() {
		try {
			ResultSet rs = Aplicacion.getConexion().consultar(
					"SELECT * FROM " + Tablas.C_USUARIO_TABLA + " WHERE " + Tablas.C_USUARIO_NICK + " LIKE '%Dummy%';");
			if (!rs.next()) {
				Aplicacion.getConexion().actualizar("INSERT INTO " + Tablas.C_USUARIO_TABLA
						+ " VALUES ('00000000A','Dummy1','dummy', 'Dummy', 'aaa', 'aaa', '600000000');");
				Aplicacion.getConexion().actualizar("INSERT INTO " + Tablas.C_USUARIO_TABLA
						+ " VALUES ('00000000B','Dummy2','dummy', 'Dummy', 'aaa', 'bbb', '600000000');");
				Aplicacion.getConexion().actualizar("INSERT INTO " + Tablas.C_CANDIDATO_TABLA
						+ " VALUES ('Dummy Dummy', '1998/08/19', 0, 0, 0, 'aaa', 'aaa', 'aaa', 0, '00000000A');");
				Aplicacion.getConexion()
						.actualizar("INSERT INTO " + Tablas.C_EMPRESA_TABLA + " VALUES ('aaa', 'aaa', '00000000B');");
			}
			System.out.println("Dummy1 y Dummy2 creados..");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
