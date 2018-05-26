package ethazi.aplicacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ethazi.intefaz.Elemento_A_Listar;
import ethazi.intefaz.Elemento_Listable;

/**
 * 
 * A collection of methods to deal with various database related activities.
 * 
 * @category Utilities, DataBase
 * @author belatz
 */
public abstract class UtilidadesBD {
//________________toUsuario necesita ser arreglado (si es candidato)
	/**
	 * Devuelve un objeto Usuario a partir de un ResultSet pasado por parametro
	 * 
	 * @param p_rs
	 *            ResultSet con la informacion del usuario
	 * @return Devuelve un Usuario con los datos sacados del ResultSet
	 * @throws SQLException
	 */
	public static Usuario toUsuario(ResultSet p_rs) throws SQLException {
		Usuario _usr = null;
		Aplicacion.getConexion();
		ResultSet _rsUsuario = Conexion
				.consultar("SELECT * FROM usuario WHERE numid='" +p_rs.getString("numid") + "';");
		_rsUsuario.next();
		String _nick = _rsUsuario.getString("numid");

		if (Usuario.esCandidato(_nick)) {
			_usr = new Candidato(_nick, p_rs.getString("password"), p_rs.getString("nombre"), p_rs.getString("numid"),
					p_rs.getString("direccion"), p_rs.getString("email"), p_rs.getString("telefono"),
					p_rs.getString("apellidos"), p_rs.getDate("fecha_nac").toString(),
					p_rs.getBoolean("carnet_conducir"), p_rs.getBoolean("coche_propio"), p_rs.getBoolean("disp_viajar"),
					p_rs.getString("estudios"), descargarConocimientos(_nick), p_rs.getString("otros_conocimientos"),
					p_rs.getString("vida_laboral"), p_rs.getInt("experiencia_laboral"));
		} else {
			_usr = new Empresa(_nick, _rsUsuario.getString("password"), _rsUsuario.getString("nombre"), p_rs.getString("numid"),
					_rsUsuario.getString("direccion"), _rsUsuario.getString("email"), _rsUsuario.getString("telefono"),
					p_rs.getString("contacto"), p_rs.getString("descripcion"));
		}
		return _usr;
	}

	/**
	 * Devuelve un objeto Usuario a partir de un nick pasado por parametro
	 * 
	 * @param p_nick
	 *            String con el nick del usuario
	 * @return Devuelve un Usuario con los datos sacados del nick pasado
	 * @throws SQLException
	 */
	public static Usuario toUsuario(String p_nick) throws SQLException {
		ResultSet _rs;

		if (Usuario.esCandidato(p_nick)) {
			Aplicacion.getConexion();
			_rs = Conexion.consultar(
					"SELECT * FROM usuario u, candidato c WHERE u.numid=c.numid AND u.nick='" + p_nick + "';");
		} else {
			Aplicacion.getConexion();
			_rs = Conexion
					.consultar("SELECT * FROM usuario u, empresa e WHERE u.numid=e.numid AND u.nick='" + p_nick + "';");
		}

		return toUsuario(_rs);
	}

	/**
	 * Devuelve un objeto Solicitud a partir de un ResultSet
	 * 
	 * @param p_rs
	 *            ResultSet con la informacion de la solicitud
	 * @return Devuelve una Solicitud con los datos almacenados en el ResultSets
	 * @throws SQLException
	 */
	public static Solicitud toSolicitud(ResultSet p_rs) throws SQLException {
		Solicitud _soli;

		_soli = new Solicitud(buscarOferta(p_rs.getString("oferta_cod_oferta")),
				buscarCandidato(p_rs.getString("candidato_numid")), p_rs.getString("presentacion"));

		return _soli;
	}

	/**
	 * Busca un candidato en la base de datos a partir de su numero de
	 * identificacion
	 * 
	 * @param p_numid
	 *            Numero de identificacion necesario para la busqueda
	 * @return Devuelve el Candidato con el numero de id recibido
	 * @throws SQLException
	 */
	public static Candidato buscarCandidato(String p_numid) throws SQLException {
		Candidato _candidato;
		Aplicacion.getConexion();
		ResultSet _rs = Conexion.consultar(
				"SELECT * FROM candidato c, usuario u WHERE c.numid = u.numid AND c.numid='" + p_numid + "';");

		_candidato = new Candidato(_rs.getString("nick"), _rs.getString("password"), _rs.getString("nombre"),
				_rs.getString("numid"), _rs.getString("direccion"), _rs.getString("email"), _rs.getString("telefono"),
				_rs.getString("apellidos"), _rs.getDate("fecha_nac").toString(), _rs.getBoolean("carnet_conducir"),
				_rs.getBoolean("coche_propio"), _rs.getBoolean("disp_viajar"), _rs.getString("estudios"),
				descargarConocimientos(p_numid), _rs.getString("otros_conocimientos"), _rs.getString("vida_laboral"),
				_rs.getInt("experiencia_laboral"));
		return _candidato;
	}

	/**
	 * Busca una oferta en la base de datos a partir de su codigo
	 * 
	 * @param p_cod
	 *            Codigo de la oferta necesario para la busqueda
	 * @return Devuelve la Oferta con el codigo recibido
	 * @throws SQLException
	 */
	public static Oferta buscarOferta(String p_cod) throws SQLException {
		Oferta _oferta;
		ArrayList<String> conocimientos = new ArrayList<>();
		Aplicacion.getConexion();
		ResultSet _rsOferta = Conexion.consultar("SELECT * FROM oferta WHERE cod_oferta='" + p_cod + "';");
		Aplicacion.getConexion();
		ResultSet _rsEmpresa = Conexion
				.consultar("SELECT * FROM empresa e, usuario u WHERE u.numid = e.numid AND numid='" + _rsOferta.getString("empresa_numid") + "';");
		Aplicacion.getConexion();
		ResultSet _rsConocimientos = Conexion
				.consultar("SELECT conocimientos_nombre FROM oferta WHERE cod_oferta='" + p_cod + "';");
		while (_rsConocimientos.next()) {
			conocimientos.add(_rsConocimientos.getString("conocimientos_nombre"));
		}
		_oferta = new Oferta(_rsOferta.getInt("cod_oferta"), _rsOferta.getString("titulo"),
				_rsOferta.getString("descripcion"), _rsOferta.getString("lugar"), _rsOferta.getInt("sueldo_max"),
				_rsOferta.getInt("sueldo_min"), _rsOferta.getInt("experiencia"),
				_rsOferta.getString("aspectos_valorar"), _rsOferta.getString("aspectos_impres"),
				_rsOferta.getBoolean("visible"), _rsOferta.getByte("tipo_contrato"), (Empresa) toUsuario(_rsEmpresa),
				conocimientos);
		return _oferta;
	}

	public static ArrayList<Elemento_Listable> buscarOfertas(String titulo) throws SQLException {
		ArrayList<Elemento_Listable> ofertas = new ArrayList<Elemento_Listable>();
		ArrayList<String> conocimientos = new ArrayList<>();
		Oferta oferta;
		ResultSet _rsConocimientos;
		System.out.println("consulta");
		Aplicacion.getConexion();
		ResultSet _rsOferta = Conexion.consultar("SELECT * FROM oferta WHERE titulo like '%" + titulo + "%';");
System.out.println("acabaconsulta");
		
System.out.println("array");
		while (_rsOferta.next()) {
		Aplicacion.getConexion();
		_rsConocimientos = Conexion
				.consultar("SELECT conocimientos_nombre FROM oferta_conocimientos WHERE oferta_cod_oferta='" + _rsOferta.getInt("cod_oferta") + "';");
		ResultSet _rsEmpresa = Conexion
				.consultar("SELECT * FROM empresa WHERE numid ='" + _rsOferta.getString("empresa_numid") + "';");

		while (_rsConocimientos.next()) {
				conocimientos.add(_rsConocimientos.getString("conocimientos_nombre"));
			}
			if(_rsEmpresa.next()) {
				
			
			
			oferta = new Oferta(_rsOferta.getInt("cod_oferta"), _rsOferta.getString("titulo"),
					_rsOferta.getString("descripcion"), _rsOferta.getString("lugar"), _rsOferta.getInt("sueldo_max"),
					_rsOferta.getInt("sueldo_min"), _rsOferta.getInt("experiencia"),
					_rsOferta.getString("aspectos_valorar"), _rsOferta.getString("aspectos_impres"),
					_rsOferta.getBoolean("visible"), _rsOferta.getByte("tipo_contrato"),
					(Empresa) toUsuario(_rsEmpresa),conocimientos);
			oferta.toString();
			ofertas.add(oferta);
			}
		}
		System.out.println("acabaarray");
		return ofertas;
	}

	/**
	 * Metodo encargado de descargar en un ArrayList la lista de conocimientos
	 * disponibles
	 * 
	 * @return Devuelve un ArrayList de String con los nombres de los conocimientos
	 *         almacenados en la base de datos
	 * @throws SQLException
	 */
	public static ArrayList<String> descargarConocimientos() throws SQLException {
		ArrayList<String> _conocimientos = new ArrayList<>();

		Aplicacion.getConexion();
		ResultSet _rs = Conexion.consultar("SELECT * FROM conocimientos;");
		while (_rs.next()) {
			_conocimientos.add(_rs.getString("nombre"));
		}

		return _conocimientos;
	}

	/**
	 * Metodo encargado de descargar en un ArrayList la lista de conocimientos de un
	 * Candidato
	 * 
	 * @param p_numid
	 *            Numero de identificacion de un Candidato
	 * @return Devuelve un ArrayList de String con los nombres de los conocimientos
	 *         que posee el Candidato
	 * @throws SQLException
	 */
	public static ArrayList<String> descargarConocimientos(String p_numid) throws SQLException {
		ArrayList<String> _conocimientos = new ArrayList<>();

		Aplicacion.getConexion();
		ResultSet _rs = Conexion
				.consultar("SELECT * FROM candidato_conocimientos WHERE candidato_usuario_numid='" + p_numid + "';");
		while (_rs.next()) {
			_conocimientos.add(_rs.getString("conocimientos_nombre"));
		}

		return _conocimientos;
	}
}
