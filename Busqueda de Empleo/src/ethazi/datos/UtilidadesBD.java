package ethazi.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.Empresa;
import ethazi.aplicacion.Oferta;
import ethazi.aplicacion.Solicitud;
import ethazi.aplicacion.Usuario;
import ethazi.intefaz.Elemento_Listable;

/**
 * 
 * A collection of methods to deal with various database related activities.
 * 
 * @category Utilities, DataBase
 * @author belatz
 */
public abstract class UtilidadesBD {

	/**
	 * Returns and object Usuario through a ResultSet by parameter
	 * 
	 * @param p_rs
	 *            ResultSet with user's information
	 * @return Returns a Usuario with ResultSet's data
	 * @throws SQLException
	 */
	public static Usuario toUsuario(ResultSet p_rs) throws SQLException {
		if (!p_rs.next()) {
			throw new SQLException("ResultSet vacio");
		}
		Usuario _usr = null;
		String _nick = p_rs.getString(Tablas.C_USUARIO_NICK);

		if (Usuario.esCandidato(_nick)) {
			_usr = new Candidato(_nick, p_rs.getString(Tablas.C_USUARIO_PASSWORD),
					p_rs.getString(Tablas.C_USUARIO_NOMBRE), p_rs.getString(Tablas.C_USUARIO_NUMID),
					p_rs.getString(Tablas.C_USUARIO_DIRECCION), p_rs.getString(Tablas.C_USUARIO_EMAIL),
					p_rs.getString(Tablas.C_USUARIO_TELEFONO), p_rs.getString(Tablas.C_CANDIDATO_APELLIDOS),
					p_rs.getDate(Tablas.C_CANDIDATO_FECHA_NAC).toString(), p_rs.getBoolean(Tablas.C_CANDIDATO_CARNET),
					p_rs.getBoolean(Tablas.C_CANDIDATO_COCHE), p_rs.getBoolean(Tablas.C_CANDIDATO_VIAJES),
					p_rs.getString(Tablas.C_CANDIDATO_ESTUDIOS), descargarConocimientos(_nick),
					p_rs.getString(Tablas.C_CANDIDATO_OTROS_CONOCIMIENTOS),
					p_rs.getString(Tablas.C_CANDIDATO_VIDA_LABORAL),
					p_rs.getInt(Tablas.C_CANDIDATO_EXPERIENCIA_LABORAL));
		} else {
			_usr = new Empresa(_nick, p_rs.getString(Tablas.C_USUARIO_PASSWORD),
					p_rs.getString(Tablas.C_USUARIO_NOMBRE), p_rs.getString(Tablas.C_USUARIO_NUMID),
					p_rs.getString(Tablas.C_USUARIO_DIRECCION), p_rs.getString(Tablas.C_USUARIO_EMAIL),
					p_rs.getString(Tablas.C_USUARIO_TELEFONO), p_rs.getString(Tablas.C_EMPRESA_CONTACTO),
					p_rs.getString(Tablas.C_EMPRESA_DESCRIPCION));
		}
		
		return _usr;
	}

	/**
	 * Returns and object Usuario through a nick by parameter
	 * 
	 * @param p_nick
	 *            String with user's nick
	 * @return Returns a Usuario with last nick's data
	 * @throws SQLException
	 */
	public static Usuario toUsuario(String p_nick) throws SQLException {
		ResultSet _rs;

		if (Usuario.esCandidato(p_nick)) {
			_rs = Aplicacion.getConexion()
					.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_CANDIDATO_TABLA + " WHERE "
							+ Tablas.C_USUARIO_NUMID + "=" + Tablas.C_CANDIDATO_NUMID + " AND " + Tablas.C_USUARIO_NICK
							+ "='" + p_nick + "';");
		} else {
			_rs = Aplicacion.getConexion()
					.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_EMPRESA_TABLA + " WHERE "
							+ Tablas.C_USUARIO_NUMID + "=" + Tablas.C_EMPRESA_NUMID + " AND " + Tablas.C_USUARIO_NICK
							+ "='" + p_nick + "';");
		}

		return toUsuario(_rs);
	}

	/**
	 * Returns and object Solicitud through a ResultSet by parameter
	 * 
	 * @param p_rs
	 *            ResultSet with request's information
	 * @return Returns a Solicitud with ResultSet's data
	 * @throws SQLException
	 */
	public static Solicitud toSolicitud(ResultSet p_rs) throws SQLException {
		Solicitud _soli;

		_soli = new Solicitud(buscarOferta(p_rs.getString(Tablas.C_SOLICITUD_OFERTA)),
				buscarCandidato(p_rs.getString(Tablas.C_SOLICITUD_CANDIDATO)),
				p_rs.getString(Tablas.C_SOLICITUD_PRESENTACION));

		return _soli;
	}

	/**
	 * Searches a Candidato in the data base by his id number
	 * 
	 * @param p_numid
	 *            Num id necessary for the search
	 * @return Returns the Candidato with the received id number
	 * @throws SQLException
	 */
	public static Candidato buscarCandidato(String p_numid) throws SQLException {
		ResultSet _rs = Aplicacion.getConexion()
				.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_CANDIDATO_TABLA + " WHERE "
						+ Tablas.C_USUARIO_NUMID + "=" + Tablas.C_CANDIDATO_NUMID + " AND " + Tablas.C_USUARIO_NUMID
						+ "='" + p_numid + "';");

		return (Candidato) toUsuario(_rs);
	}

	/**
	 * Searches an offer in the data base through its code
	 *  
	 * @param p_cod
	 *            Offer's code necessary for the search
	 * @return Returns the Offer with the received code
	 * @throws SQLException
	 */
	public static Oferta buscarOferta(String p_cod) throws SQLException {
		Oferta _oferta;
		ResultSet _rsOferta = Aplicacion.getConexion().consultar(
				"SELECT * FROM " + Tablas.C_OFERTA_TABLA + " WHERE " + Tablas.C_OFERTA_CODIGO + "='" + p_cod + "';");
		ResultSet _rsEmpresa = Aplicacion.getConexion()
				.consultar("SELECT * FROM " + Tablas.C_EMPRESA_TABLA + ", " + Tablas.C_EMPRESA_TABLA + " WHERE "
						+ Tablas.C_USUARIO_NUMID + " = " + Tablas.C_EMPRESA_NUMID + " AND " + Tablas.C_EMPRESA_NUMID
						+ "='" + _rsOferta.getString(Tablas.C_OFERTA_EMPRESA) + "';");

		_oferta = new Oferta(_rsOferta.getInt(Tablas.C_OFERTA_CODIGO), _rsOferta.getString(Tablas.C_OFERTA_TITULO),
				_rsOferta.getString(Tablas.C_OFERTA_DESCRIPCION), _rsOferta.getString(Tablas.C_OFERTA_LUGAR),
				_rsOferta.getInt(Tablas.C_OFERTA_SUELDO_MAX), _rsOferta.getInt(Tablas.C_OFERTA_SUELDO_MIN),
				_rsOferta.getInt(Tablas.C_OFERTA_EXPERIENCIA), _rsOferta.getString(Tablas.C_OFERTA_ASPECTOS_VALORAR),
				_rsOferta.getString(Tablas.C_OFERTA_ASPECTOS_IMPRESCINDIBLES),
				_rsOferta.getBoolean(Tablas.C_OFERTA_VISIBLE), _rsOferta.getByte(Tablas.C_OFERTA_TIPO_CONTRATO),
				(Empresa) toUsuario(_rsEmpresa));
		return _oferta;
	}

	public static ArrayList<Elemento_Listable> buscarOfertas(String titulo) throws SQLException {
		ArrayList<Elemento_Listable> ofertas = new ArrayList<Elemento_Listable>();

		Oferta oferta;
		Aplicacion.getConexion();
		ResultSet _rsOferta = Conexion.consultar("SELECT * FROM oferta WHERE titulo like '%" + titulo + "%';");
		ResultSet _rsEmpresa = Conexion
				.consultar("SELECT * FROM empresa e, usuario u WHERE u.numid = e.numid AND numid='"
						+ _rsOferta.getString("numid") + "';");
		while (_rsOferta.next()) {
			oferta = new Oferta(_rsOferta.getInt("cod_oferta"), _rsOferta.getString("titulo"),
					_rsOferta.getString("descripcion"), _rsOferta.getString("lugar"), _rsOferta.getInt("sueldo_max"),
					_rsOferta.getInt("sueldo_min"), _rsOferta.getInt("experiencia"),
					_rsOferta.getString("aspectos_valorar"), _rsOferta.getString("aspectos_impres"),
					_rsOferta.getBoolean("visible"), _rsOferta.getByte("tipo_contrato"),
					(Empresa) toUsuario(_rsEmpresa));
			ofertas.add(oferta);
		}
		return ofertas;
	}

	/**
	 * This method downloads in an ArrayList the list of available conocimientos
	 * 
	 * @return Returns an ArrayList of String with the names of the conocimientos stored in the data base
	 * @throws SQLException
	 */
	public static ArrayList<String> descargarConocimientos() throws SQLException {
		ArrayList<String> _conocimientos = new ArrayList<>();

		ResultSet _rs = Aplicacion.getConexion().consultar("SELECT * FROM " + Tablas.C_CONOCIMIENTOS_TABLA + ";");
		while (_rs.next()) {
			_conocimientos.add(_rs.getString(Tablas.C_CONOCIMIENTOS_NOMBRE));
		}

		return _conocimientos;
	}

	/**
	 * This method downloads in an ArrayList the list of a Candidato's conocimientos
	 * 
	 * @param p_numid
	 *            A Candidato's num id
	 * @return Returns an ArrayList of String with the names of the conocimientos of the Candidato
	 * @throws SQLException
	 */
	public static ArrayList<String> descargarConocimientos(String p_numid) throws SQLException {
		ArrayList<String> _conocimientos = new ArrayList<>();

		ResultSet _rs = Aplicacion.getConexion().consultar("SELECT * FROM " + Tablas.C_CANDI_CONO_TABLA + " WHERE "
				+ Tablas.C_CANDI_CONO_CANDIDATO + "='" + p_numid + "';");
		while (_rs.next()) {
			_conocimientos.add(_rs.getString(Tablas.C_CANDI_CONO_CONOCIMIENTO));
		}

		return _conocimientos;
	}

	public static ArrayList<Oferta> filtrarOfertas(String p_titulo, String p_lugar, String p_salarioMax,
			String p_salarioMin, String p_experiencia, String p_contrato, String p_empresa,
			ArrayList<String> p_conocimientos) throws SQLException {

		ArrayList<Oferta> _ofertas = new ArrayList<>();
		boolean _primeraCondicion = true;
		String _sentencia = "SELECT " + Tablas.C_OFERTA_CODIGO + " FROM " + Tablas.C_OFERTA_TABLA;

		if (p_titulo != null || !p_titulo.equals("")) {
			if (_primeraCondicion) {
				_primeraCondicion = false;
				_sentencia += " WHERE ";
			} else {
				_sentencia += " AND ";
			}
			_sentencia += Tablas.C_OFERTA_TITULO + " LIKE '%" + p_titulo + "%'";
		}
		if (p_lugar != null || !p_lugar.equals("")) {
			if (_primeraCondicion) {
				_primeraCondicion = false;
				_sentencia += " WHERE ";
			} else {
				_sentencia += " AND ";
			}
			_sentencia += Tablas.C_OFERTA_LUGAR + " LIKE '%" + p_lugar + "%'";
		}
		if (p_salarioMax != null || !p_salarioMax.equals("")) {
			if (_primeraCondicion) {
				_primeraCondicion = false;
				_sentencia += " WHERE ";
			} else {
				_sentencia += " AND ";
			}
			_sentencia += Tablas.C_OFERTA_SUELDO_MAX + " >= " + p_salarioMax;
		}
		if (p_salarioMin != null || !p_salarioMin.equals("")) {
			if (_primeraCondicion) {
				_primeraCondicion = false;
				_sentencia += " WHERE ";
			} else {
				_sentencia += " AND ";
			}
			_sentencia += Tablas.C_OFERTA_SUELDO_MIN + " >= " + p_salarioMin;
		}
		if (p_experiencia != null || !p_experiencia.equals("")) {
			if (_primeraCondicion) {
				_primeraCondicion = false;
				_sentencia += " WHERE ";
			} else {
				_sentencia += " AND ";
			}
			_sentencia += Tablas.C_OFERTA_EXPERIENCIA + " >= " + p_experiencia;
		}
		if (p_contrato != null || !p_contrato.equals("")) {
			if (_primeraCondicion) {
				_primeraCondicion = false;
				_sentencia += " WHERE ";
			} else {
				_sentencia += " AND ";
			}
			_sentencia += Tablas.C_OFERTA_TIPO_CONTRATO + " = " + p_contrato; // TODO Controlarlo con la enumeracion
		}
		if (p_empresa != null || !p_empresa.equals("")) {
			if (_primeraCondicion) {
				_primeraCondicion = false;
				_sentencia += " WHERE ";
			} else {
				_sentencia += " AND ";
			}
			_sentencia += Tablas.C_OFERTA_EMPRESA + " LIKE '%" + p_empresa + "%'"; // TODO Pasar de Nombre de empresa a
																					// numid con subselect
		}
		if (p_conocimientos != null || p_conocimientos.size() > 0) {
			if (_primeraCondicion) {
				_primeraCondicion = false;
				_sentencia += " WHERE ";
			} else {
				_sentencia += " AND ";
			}
			_sentencia += Tablas.C_OFER_CONO_CONOCIMIENTO + " IN '%" + p_conocimientos + "%'"; // TODO Controlar todos
																								// los conocimientos
																								// posibles
		}
		_sentencia += ";";

		// Busca todas las ofertas que concuerden con los filtros, las combierte en
		// Objetos y las mete en el array
		ResultSet _rs = Aplicacion.getConexion().consultar(_sentencia);
		while (_rs.next()) {
			_ofertas.add(toOferta(_rs.getString(Tablas.C_OFERTA_CODIGO))); // TODO metodo toOferta(String)
		}

		return _ofertas;
	}
	// TODO crear filtrarCandidatos(String,String,String, String, boolean, boolean,
	// boolean, ArrayList<String>)
}
