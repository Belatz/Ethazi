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
import ethazi.excepciones.ResultSetVacio;
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
	 * Devuelve un objeto Usuario a partir de un ResultSet pasado por parametro
	 * 
	 * @param p_rs
	 *            ResultSet con la informacion del usuario
	 * @return Devuelve un Usuario con los datos sacados del ResultSet
	 * @throws SQLException
	 */
	public static Usuario toUsuario(ResultSet p_rs) throws SQLException, ResultSetVacio {
		if (!p_rs.next()) {
			throw new ResultSetVacio();
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
					p_rs.getString(Tablas.C_CANDIDATO_ESTUDIOS),
					descargarConocimientosCandidato(Tablas.C_CANDIDATO_NUMID),
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
	 * Devuelve un objeto Usuario a partir de un nick o un numid pasado por
	 * parametro
	 * 
	 * @param p_identificador
	 *            String con el nick o el numid del usuario
	 * @param p_esNick
	 *            boolean que determina el tipo de texto que le pasamos, true si es
	 *            un nick, false si es un numid
	 * @return Devuelve un Usuario con los datos sacados del nick pasado
	 * @throws SQLException
	 */
	public static Usuario toUsuario(String p_identificador, boolean p_esNick) throws SQLException {
		Usuario usr = null;
		ResultSet _rs;

		if (p_esNick) {
			if (Usuario.esCandidato(p_identificador)) {
				_rs = Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_CANDIDATO_TABLA
						+ " WHERE " + Tablas.C_USUARIO_NUMID + "=" + Tablas.C_CANDIDATO_NUMID + " AND "
						+ Tablas.C_USUARIO_NICK + "='" + p_identificador + "';");
			} else {
				_rs = Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_EMPRESA_TABLA
						+ " WHERE " + Tablas.C_USUARIO_NUMID + "=" + Tablas.C_EMPRESA_NUMID + " AND "
						+ Tablas.C_USUARIO_NICK + "='" + p_identificador + "';");
			}
		} else {
			if (Usuario.esCandidato(p_identificador)) {
				_rs = Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_CANDIDATO_TABLA
						+ " WHERE " + Tablas.C_USUARIO_NUMID + "=" + Tablas.C_CANDIDATO_NUMID + " AND "
						+ Tablas.C_USUARIO_NUMID + "='" + p_identificador + "';");
			} else {
				_rs = Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_EMPRESA_TABLA
						+ " WHERE " + Tablas.C_USUARIO_NUMID + "=" + Tablas.C_EMPRESA_NUMID + " AND "
						+ Tablas.C_USUARIO_NUMID + "='" + p_identificador + "';");
			}
		}

		try {
			usr = toUsuario(_rs);
		} catch (ResultSetVacio e) {
			System.out.println("No se han encontrado usuarios con esos datos"); // TODO manejar error por interfaz
		}

		return usr;
	}

	/**
	 * Devuelve un objeto Solicitud a partir de un ResultSet
	 * 
	 * @param p_rs
	 *            ResultSet con la informacion de la solicitud
	 * @return Devuelve una Solicitud con los datos almacenados en el ResultSets
	 * @throws SQLException
	 */
	public static Solicitud toSolicitud(ResultSet p_rs) throws SQLException, ResultSetVacio {
		if (!p_rs.next()) {
			throw new ResultSetVacio();
		}

		Solicitud _soli;

		_soli = new Solicitud(buscarOferta(p_rs.getString(Tablas.C_SOLICITUD_OFERTA)),
				buscarCandidato(p_rs.getString(Tablas.C_SOLICITUD_CANDIDATO)),
				p_rs.getString(Tablas.C_SOLICITUD_PRESENTACION));

		return _soli;
	}

	public static Oferta toOferta(ResultSet p_rs) throws SQLException, ResultSetVacio {
		if (!p_rs.next()) {
			throw new ResultSetVacio();
		}

		Oferta _ofer;

		_ofer = new Oferta(p_rs.getInt(Tablas.C_OFERTA_CODIGO), p_rs.getString(Tablas.C_OFERTA_TITULO),
				p_rs.getString(Tablas.C_OFERTA_DESCRIPCION), p_rs.getString(Tablas.C_OFERTA_LUGAR),
				p_rs.getInt(Tablas.C_OFERTA_SUELDO_MAX), p_rs.getInt(Tablas.C_OFERTA_SUELDO_MIN),
				p_rs.getInt(Tablas.C_OFERTA_EXPERIENCIA), p_rs.getString(Tablas.C_OFERTA_ASPECTOS_VALORAR),
				p_rs.getString(Tablas.C_OFERTA_ASPECTOS_IMPRESCINDIBLES), p_rs.getBoolean(Tablas.C_OFERTA_VISIBLE),
				p_rs.getByte(Tablas.C_OFERTA_TIPO_CONTRATO),
				(Empresa) (toUsuario(p_rs.getString(Tablas.C_OFERTA_EMPRESA), false)),
				descargarConocimientosOferta(Tablas.C_OFERTA_CODIGO));

		return _ofer;
	}

	public static Oferta toOferta(String p_codOFerta) throws SQLException {
		Oferta ofer = null;
		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_OFERTA_TABLA + " WHERE " + Tablas.C_OFERTA_CODIGO
				+ "=" + p_codOFerta + ";");
		try {
			ofer = toOferta(_rs);
		} catch (ResultSetVacio e) {
			System.out.println("No se han encontrado ofertas con ese codigo"); // TODO tratar error
		}
		return ofer;
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
		Candidato usr = null;
		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_CANDIDATO_TABLA
				+ " WHERE " + Tablas.C_USUARIO_NUMID + "=" + Tablas.C_CANDIDATO_NUMID + " AND " + Tablas.C_USUARIO_NUMID
				+ "='" + p_numid + "';");

		try {
			usr = (Candidato) toUsuario(_rs);
		} catch (ResultSetVacio e) {
			System.out.println("No se han encontrado usuarios con esos datos"); // TODO tratar error
		}

		return usr;
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
		Oferta _oferta = null;
		ArrayList<String> _conocimientos;

		// Descargar oferta
		ResultSet _rsOferta = Conexion.consultar(
				"SELECT * FROM " + Tablas.C_OFERTA_TABLA + " WHERE " + Tablas.C_OFERTA_CODIGO + "='" + p_cod + "';");
		// Descargar conocimientos
		_conocimientos = descargarConocimientosOferta(_rsOferta.getString(Tablas.C_OFERTA_CODIGO));
		// Descargar empresa de la oferta
		ResultSet _rsEmpresa = Conexion.consultar("SELECT * FROM " + Tablas.C_EMPRESA_TABLA + ", "
				+ Tablas.C_EMPRESA_TABLA + " WHERE " + Tablas.C_USUARIO_NUMID + " = " + Tablas.C_EMPRESA_NUMID + " AND "
				+ Tablas.C_EMPRESA_NUMID + "='" + _rsOferta.getString(Tablas.C_OFERTA_EMPRESA) + "';");

		try {
			_oferta = new Oferta(_rsOferta.getInt(Tablas.C_OFERTA_CODIGO), _rsOferta.getString(Tablas.C_OFERTA_TITULO),
					_rsOferta.getString(Tablas.C_OFERTA_DESCRIPCION), _rsOferta.getString(Tablas.C_OFERTA_LUGAR),
					_rsOferta.getInt(Tablas.C_OFERTA_SUELDO_MAX), _rsOferta.getInt(Tablas.C_OFERTA_SUELDO_MIN),
					_rsOferta.getInt(Tablas.C_OFERTA_EXPERIENCIA), _rsOferta.getString(Tablas.C_OFERTA_ASPECTOS_VALORAR),
					_rsOferta.getString(Tablas.C_OFERTA_ASPECTOS_IMPRESCINDIBLES),
					_rsOferta.getBoolean(Tablas.C_OFERTA_VISIBLE), _rsOferta.getByte(Tablas.C_OFERTA_TIPO_CONTRATO),
					(Empresa) toUsuario(_rsEmpresa), _conocimientos);
		} catch (ResultSetVacio e) {
			System.out.println("No se han encontrado usuarios con esos datos");
		}
		return _oferta;
	}

	public static ArrayList<Elemento_Listable> buscarOfertas(String titulo) throws SQLException {
		ArrayList<Elemento_Listable> ofertas = new ArrayList<Elemento_Listable>();

		// Decargar ofertas
		ResultSet _rsOferta = Conexion.consultar("SELECT * FROM " + Tablas.C_OFERTA_TABLA + " WHERE "
				+ Tablas.C_OFERTA_TITULO + " like '%" + titulo + "%';");

		while (_rsOferta.next()) {
			try {
				ofertas.add(toOferta(_rsOferta));
			} catch (ResultSetVacio e) {
				System.out.println("No se han encontrado ofertas con esos datos");
			}
		}
		return ofertas;
	}

	public static ArrayList<Oferta> buscarOfertasEmpresa(String p_empresaNumid) throws SQLException {
		ArrayList<Oferta> _ofertas = new ArrayList<>();

		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_OFERTA_TABLA + " WHERE "
				+ Tablas.C_OFERTA_EMPRESA + "=" + p_empresaNumid + ";");
		while (_rs.next()) {
			_ofertas.add(toOferta(_rs.getString(Tablas.C_OFERTA_CODIGO)));
		}

		return _ofertas;
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
		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_CONOCIMIENTOS_TABLA + ";");
		while (_rs.next()) {
			_conocimientos.add(_rs.getString(Tablas.C_CONOCIMIENTOS_NOMBRE));
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
	public static ArrayList<String> descargarConocimientosCandidato(String p_numid) throws SQLException {
		ArrayList<String> _conocimientos = new ArrayList<>();

		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_CANDI_CONO_TABLA + " WHERE "
				+ Tablas.C_CANDI_CONO_CANDIDATO + "='" + p_numid + "';");
		while (_rs.next()) {
			_conocimientos.add(_rs.getString(Tablas.C_CANDI_CONO_CONOCIMIENTO));
		}

		return _conocimientos;
	}

	public static ArrayList<String> descargarConocimientosOferta(String p_codOferta) throws SQLException {
		ArrayList<String> _conocimientos = new ArrayList<>();

		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_OFER_CONO_TABLA + " WHERE "
				+ Tablas.C_OFER_CONO_OFERTA + "='" + p_codOferta + "';");
		while (_rs.next()) {
			_conocimientos.add(_rs.getString(Tablas.C_OFER_CONO_CONOCIMIENTO));
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
		ResultSet _rs = Conexion.consultar(_sentencia);
		while (_rs.next()) {
			_ofertas.add(toOferta(_rs.getString(Tablas.C_OFERTA_CODIGO)));
		}

		return _ofertas;
	}

	public static void filtrarCandidatos(String text, String text2, String text3, String text4, boolean selected,
			boolean selected2, boolean selected3, ArrayList<String> conocimientos) {
		// TODO Auto-generated method stub
		
	}

}
