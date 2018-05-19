package ethazi.aplicacion;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utilidades {

	public static Usuario toUsuario(ResultSet p_rs) throws SQLException {
		Usuario _usr = null;
		String _nick = p_rs.getString("nick");

		if (Usuario.esCandidato(_nick)) {
			/*
			 * _usr = new Candidato(_nick, p_rs.getString("password"),
			 * p_rs.getString("nombre"), p_rs.getString("numid"),
			 * p_rs.getString("direccion"), p_rs.getString("email"),
			 * p_rs.getString("telefono"), p_rs.getByte("vida_laboral"),
			 * p_rs.getString("apellidos"), p_rs.getDate("fecha_nac"),
			 * p_rs.getBoolean("carnet_conducir"), p_rs.getBoolean("coche_propio"),
			 * p_rs.getBoolean("disp_viajar"), p_rs.getString("estudios"), "conocimientos",
			 * p_rs.getInt("otros_conocimientos"), p_rs.getString("vida_laboral"),
			 * p_rs.getInt("experiencia"));
			 */

		} else {
			/*
			 * _usr = new Empresa(_nick, p_rs.getString("password"),
			 * p_rs.getString("nombre"), p_rs.getString("numid"),
			 * p_rs.getString("direccion"), p_rs.getString("email"),
			 * p_rs.getString("telefono"), p_rs.getString("contacto"),
			 * p_rs.getString("descripcion"));
			 */
		}
		return _usr;
	}

	public static Solicitud toSolicitud(ResultSet p_rs) throws SQLException {
		Solicitud _soli;

		_soli = new Solicitud(buscarOferta(p_rs.getString("oferta_cod_oferta")),
				buscarCandidato(p_rs.getString("candidato_numid")), p_rs.getString("presentacion"));

		return _soli;
	}

	public static Candidato buscarCandidato(String p_numid) throws SQLException {
		Candidato _candidato;
		ResultSet _rs = Aplicacion.getConexion().consultar("SELECT * FROM candidato c, usuario u WHERE c.numid = u.numid AND c.numid='" + p_numid + "';");

		// _candidato = new Candidato(_rs.getString("nick"), _rs.getString("password"),
		// _rs.getString("nombre"),
		// _rs.getString("numid"), _rs.getString("direccion"), _rs.getString("email"),
		// _rs.getString("telefono"),
		// _rs.getByte("vida_laboral"), _rs.getString("apellidos"),
		// _rs.getDate("fecha_nac"),
		// _rs.getBoolean("carnet_conducir"), _rs.getBoolean("coche_propio"),
		// _rs.getBoolean("disp_viajar"),
		// _rs.getString("estudios"), "conocimientos",
		// _rs.getInt("otros_conocimientos"),
		// _rs.getString("vida_laboral"), _rs.getInt("experiencia"));
		return _candidato;
	}

	public static Oferta buscarOferta(String p_cod) throws SQLException {
		Oferta _oferta;
		ResultSet _rsOferta = Aplicacion.getConexion().consultar("SELECT * FROM oferta WHERE cod_oferta='" + p_cod + "';");
		ResultSet _rsEmpresa = Aplicacion.getConexion().consultar("SELECT * FROM empresa e, usuario u WHERE u.numid = e.numid AND numid='" + _rsOferta.getString("numid") + "';");

//		_oferta = new Oferta(_rsOferta.getString("titulo"), toUsuario(_rsEmpresa), _rsOferta.getString("descripcion"),
//				_rsOferta.getInt("salario_min"));
		return _oferta;
	}
}
