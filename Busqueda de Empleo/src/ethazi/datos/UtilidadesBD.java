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
import ethazi.excepciones.NoQuedanFilas;
import ethazi.intefaz.Elemento_Listable;

/**
 * 
 * A collection of methods to deal with various database related activities.
 * 
 * @category Utilities, DataBase
 * @author belatz
 */
public abstract class UtilidadesBD {

	public static void insertarUsuario(Usuario user) throws SQLException
	{
		Conexion.actualizar("INSERT INTO "+Tablas.C_USUARIO_TABLA+
				" VALUES ('"+user.getNumID()+"','"
				+user.getNick()+"','"
				+user.getPassword()+"','"
				+user.getNombre()+"','"
				+user.getDireccion()+"','"
				+user.getEmail()+"','"
				+user.getTelefono()+"');");
	}
	public static void insertarEmpresa(Empresa emp) throws SQLException
	{
		insertarUsuario(emp);
		Conexion.actualizar("INSERT INTO "+Tablas.C_EMPRESA_TABLA+
				" VALUES ('"+emp.getContacto()+"','"
				+emp.getDescripcion()+"','"
				+emp.getNumID()+"');");
	}
	/**
	 * Returns and object Usuario through a ResultSet by parameter
	 * 
	 * @param p_rs
	 *            ResultSet with user's information
	 * @return Returns a Usuario with ResultSet's data
	 * @throws SQLException
	 * @throws NoQuedanFilas
	 */
	public static Usuario toUsuario(ResultSet p_rs) throws SQLException, ResultSetVacio, NoQuedanFilas {
		if (!p_rs.next()) {
			if (p_rs.isAfterLast()) {
				throw new NoQuedanFilas();
			} else {
				throw new ResultSetVacio();
			}
		}
		Usuario _usr = null;
		String _nick = p_rs.getString(Tablas.C_USUARIO_NICK);

		if (Usuario.esCandidato(_nick, true)) {
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
	 *            un nick, false si es un numid * @return Returns a Usuario with the data obtained from the identificator
	 * @throws SQLException
	 */
	public static Usuario toUsuario(String p_identificador, boolean p_esNick) throws SQLException {
		Usuario usr = null;
		ResultSet _rs;

		if (p_esNick) {
			if (Usuario.esCandidato(p_identificador, p_esNick)) {
				_rs = Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_CANDIDATO_TABLA
						+ " WHERE " + Tablas.C_USUARIO_NUMID + "=" + Tablas.C_CANDIDATO_NUMID + " AND "
						+ Tablas.C_USUARIO_NICK + "='" + p_identificador + "';");
			} else {
				_rs = Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_EMPRESA_TABLA
						+ " WHERE " + Tablas.C_USUARIO_NUMID + "=" + Tablas.C_EMPRESA_NUMID + " AND "
						+ Tablas.C_USUARIO_NICK + "='" + p_identificador + "';");
			}
		} else {
			if (Usuario.esCandidato(p_identificador, p_esNick)) {
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
			System.out.println("No se han encontrado usuarios con esos datos");
		} catch (NoQuedanFilas e) {
		}

		return usr;
	}
	public static Empresa toEmpresa(String nombre) throws SQLException{
		ResultSet _rs=Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_EMPRESA_TABLA
				+ " WHERE " + Tablas.C_USUARIO_NUMID + "=" + Tablas.C_EMPRESA_NUMID + " AND "
				+ Tablas.C_USUARIO_NICK + "='" + nombre + "';");
		Empresa emp=null;
		try {
		emp=(Empresa)toUsuario(_rs);
		}catch(ResultSetVacio e) {
			emp=null;
		} catch (NoQuedanFilas e) {
			e.printStackTrace();
		}
		return emp;
	}
	public static Empresa toEmpresaCif(String cIF) throws SQLException{
		ResultSet _rs=Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_EMPRESA_TABLA
				+ " WHERE " + Tablas.C_USUARIO_NUMID + "=" + Tablas.C_EMPRESA_NUMID + " AND "
				+ Tablas.C_EMPRESA_NUMID + "='" + cIF + "';");
		Empresa emp=null;
		try {
		emp=(Empresa)toUsuario(_rs);
		}catch(ResultSetVacio e) {
			emp=null;
		} catch (NoQuedanFilas e) {
			e.printStackTrace();
		}
		return emp;
	}
	public static Candidato toCandidatoDNI(String dNI) throws SQLException {
		ResultSet _rs=Conexion.consultar("SELECT * FROM "+Tablas.C_USUARIO_TABLA+", "+Tablas.C_CANDIDATO_TABLA
				+ " WHERE "+Tablas.C_USUARIO_NUMID+"="+Tablas.C_EMPRESA_NUMID+" AND "
				+Tablas.C_EMPRESA_NUMID+"='"+dNI+"';");
		Candidato cand=null;
		try {
			cand=(Candidato)toUsuario(_rs);
		} catch (ResultSetVacio e) {
			e.printStackTrace();
		} catch (NoQuedanFilas e) {
			e.printStackTrace();
		}
		return cand;
	}
	public static Usuario toUsuario(String email) throws SQLException
	{
		ResultSet _rs=Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + " WHERE "
				+ Tablas.C_USUARIO_EMAIL + "='" + email + "';");
		Usuario user=null;
		try {
		user=toUsuario(_rs);
		}catch(ResultSetVacio e) {
			user=null;
		} catch (NoQuedanFilas e) {
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * Returns and object Solicitud through a ResultSet by parameter
	 * 
	 * @param p_rs
	 *            ResultSet with request's information
	 * @return Returns a Solicitud with ResultSet's data
	 * @throws SQLException
	 * @throws NoQuedanFilas
	 */
	public static Solicitud toSolicitud(ResultSet p_rs) throws SQLException, ResultSetVacio, NoQuedanFilas {
		if (!p_rs.next()) {
			if (p_rs.isAfterLast()) {
				throw new NoQuedanFilas();
			} else {
				throw new ResultSetVacio();
			}
		}

		Solicitud _soli;

		_soli = new Solicitud(buscarOferta(p_rs.getString(Tablas.C_SOLICITUD_OFERTA)),
				buscarCandidato(p_rs.getString(Tablas.C_SOLICITUD_CANDIDATO)),
				p_rs.getString(Tablas.C_SOLICITUD_PRESENTACION));

		return _soli;
	}

	public static Oferta toOferta(ResultSet p_rs) throws SQLException, ResultSetVacio, NoQuedanFilas {
		if (!p_rs.next()) {
			if (p_rs.isAfterLast()) {
				throw new NoQuedanFilas();
			} else {
				throw new ResultSetVacio();
			}
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
		} catch (NoQuedanFilas e) {
		}
		return ofer;
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
		Candidato usr = null;
		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", " + Tablas.C_CANDIDATO_TABLA
				+ " WHERE " + Tablas.C_USUARIO_NUMID + "=" + Tablas.C_CANDIDATO_NUMID + " AND " + Tablas.C_USUARIO_NUMID
				+ "='" + p_numid + "';");

		try {
			usr = (Candidato) toUsuario(_rs);
		} catch (ResultSetVacio e) {
			System.out.println("No se han encontrado usuarios con esos datos"); // TODO tratar error
		} catch (NoQuedanFilas e) {
		}

		return usr;
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
		Oferta _oferta = null;
		ArrayList<String> _conocimientos;

		// Descargar oferta
		ResultSet _rsOferta = Conexion.consultar(
				"SELECT * FROM " + Tablas.C_OFERTA_TABLA + " WHERE " + Tablas.C_OFERTA_CODIGO + "='" + p_cod + "';");
		_rsOferta.next();
		// Descargar conocimientos
		_conocimientos = descargarConocimientosOferta(_rsOferta.getString(Tablas.C_OFERTA_CODIGO));
		// Descargar empresa de la oferta
		ResultSet _rsEmpresa = Conexion.consultar("SELECT * FROM " + Tablas.C_USUARIO_TABLA + ", "
				+ Tablas.C_EMPRESA_TABLA + " WHERE " + Tablas.C_USUARIO_NUMID + " = " + Tablas.C_EMPRESA_NUMID + " AND "
				+ Tablas.C_EMPRESA_NUMID + "='" + _rsOferta.getString(Tablas.C_OFERTA_EMPRESA) + "';");

		try {
			_oferta = new Oferta(_rsOferta.getInt(Tablas.C_OFERTA_CODIGO), _rsOferta.getString(Tablas.C_OFERTA_TITULO),
					_rsOferta.getString(Tablas.C_OFERTA_DESCRIPCION), _rsOferta.getString(Tablas.C_OFERTA_LUGAR),
					_rsOferta.getInt(Tablas.C_OFERTA_SUELDO_MAX), _rsOferta.getInt(Tablas.C_OFERTA_SUELDO_MIN),
					_rsOferta.getInt(Tablas.C_OFERTA_EXPERIENCIA),
					_rsOferta.getString(Tablas.C_OFERTA_ASPECTOS_VALORAR),
					_rsOferta.getString(Tablas.C_OFERTA_ASPECTOS_IMPRESCINDIBLES),
					_rsOferta.getBoolean(Tablas.C_OFERTA_VISIBLE), _rsOferta.getByte(Tablas.C_OFERTA_TIPO_CONTRATO),
					(Empresa) toUsuario(_rsEmpresa), _conocimientos);
		} catch (ResultSetVacio e) {
			System.out.println("No se han encontrado usuarios con esos datos");
		} catch (NoQuedanFilas e) {
		}
		return _oferta;
	}

	public static ArrayList<Elemento_Listable> buscarOfertas(String titulo) throws SQLException {
		boolean fin = false;
		ArrayList<Elemento_Listable> ofertas = new ArrayList<Elemento_Listable>();

		// Decargar ofertas
		ResultSet _rsOferta = Conexion.consultar("SELECT * FROM " + Tablas.C_OFERTA_TABLA + " WHERE "
				+ Tablas.C_OFERTA_TITULO + " like '%" + titulo + "%';");

		while (!fin) {
			try {
				ofertas.add(toOferta(_rsOferta));
			} catch (ResultSetVacio e) {
				System.out.println("No se han encontrado ofertas con esos datos");
				fin = true;
			} catch (NoQuedanFilas e) {
				fin = true;
			}
		}
		return ofertas;
	}

	public static ArrayList<Oferta> buscarOfertasEmpresa(String p_empresaNumid) throws SQLException {
		ArrayList<Oferta> _ofertas = new ArrayList<>();

		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_OFERTA_TABLA + " WHERE "
				+ Tablas.C_OFERTA_EMPRESA + "='" + p_empresaNumid + "';");
		while (_rs.next()) {
			_ofertas.add(toOferta(_rs.getString(Tablas.C_OFERTA_CODIGO)));
		}

		return _ofertas;
	}

	public static ArrayList<Oferta> buscarOfertasConSolicitud(String p_empresaNumid) throws SQLException {
		boolean fin = false;
		ArrayList<Oferta> _ofertas = new ArrayList<>();

		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_OFERTA_TABLA + ", " + Tablas.C_SOLICITUD_TABLA
				+ " WHERE " + Tablas.C_OFERTA_CODIGO + "=" + Tablas.C_SOLICITUD_OFERTA + " AND "
				+ Tablas.C_OFERTA_EMPRESA + "='" + p_empresaNumid + "' ;");
		while (!fin) {
			try {
				_ofertas.add(toOferta(_rs));
			} catch (ResultSetVacio e) {
				System.out.println("No se han encontrado ofertas con solicitudes");
				fin = true;
			} catch (NoQuedanFilas e) {
				fin = true;
			}
		}

		return _ofertas;
	}

	public static ArrayList<Empresa> buscarEmpresas(String p_nombre) throws SQLException {
		boolean fin = false;
		ArrayList<Empresa> _empresas = new ArrayList<>();

		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_EMPRESA_TABLA + ", " + Tablas.C_USUARIO_TABLA
				+ " WHERE " + Tablas.C_USUARIO_NUMID + "=" + Tablas.C_EMPRESA_NUMID + " AND " + Tablas.C_USUARIO_NOMBRE
				+ " LIKE '%" + p_nombre + "%';");

		while (!fin) {
			try {
				_empresas.add((Empresa) toUsuario(_rs));
			} catch (ResultSetVacio e) {
				System.out.println("No se ha encontrado ninguna empresa");
				fin = true;
			} catch (NoQuedanFilas e) {
				fin = true;
			}
		}

		return _empresas;
	}

	public static boolean buscarConocimiento(String p_nombre) throws SQLException {
		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_CONOCIMIENTOS_TABLA + " WHERE "
				+ Tablas.C_CONOCIMIENTOS_NOMBRE + "=" + p_nombre + ";");

		return _rs.next();
	}

	/**
	 * This method downloads in an ArrayList the list of available conocimientos
	 * 
	 * @return Returns an ArrayList of String with the names of the conocimientos
	 *         stored in the data base
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
	 * This method downloads in an ArrayList the list of a Candidato's conocimientos
	 * 
	 * @param p_numid
	 *            A Candidato's num id
	 * @return Returns an ArrayList of String with the names of the conocimientos of
	 *         the Candidato
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
			String p_salarioMin, String p_experiencia, int p_contrato, String p_empresa,
			ArrayList<String> p_conocimientos) throws SQLException {

		ArrayList<Oferta> _ofertas = new ArrayList<>();
		String _sentencia = "SELECT DISTINCT " + Tablas.C_OFERTA_CODIGO + " FROM " + Tablas.C_OFERTA_TABLA + ", "
				+ Tablas.C_OFER_CONO_TABLA + " WHERE " + Tablas.C_OFERTA_CODIGO + "=" + Tablas.C_OFER_CONO_OFERTA;

		if (null != p_titulo && !p_titulo.isEmpty()) {
			_sentencia += " AND ";
			_sentencia += Tablas.C_OFERTA_TITULO + " LIKE '%" + p_titulo + "%'";
		}
		if (p_lugar != null && !p_lugar.isEmpty()) {
			_sentencia += " AND ";
			_sentencia += Tablas.C_OFERTA_LUGAR + " LIKE '%" + p_lugar + "%'";
		}
		if (p_salarioMax != null && !p_salarioMax.isEmpty()) {
			_sentencia += " AND ";
			_sentencia += Tablas.C_OFERTA_SUELDO_MAX + " >= " + p_salarioMax;
		}
		if (p_salarioMin != null && !p_salarioMin.isEmpty()) {
			_sentencia += " AND ";
			_sentencia += Tablas.C_OFERTA_SUELDO_MIN + " >= " + p_salarioMin;
		}
		if (p_experiencia != null && !p_experiencia.isEmpty()) {
			_sentencia += " AND ";
			_sentencia += Tablas.C_OFERTA_EXPERIENCIA + " >= " + p_experiencia;
		}
		if (p_contrato >= 0) {
			_sentencia += " AND ";
			_sentencia += Tablas.C_OFERTA_TIPO_CONTRATO + " = " + p_contrato; 
		}
		if (p_empresa != null && !p_empresa.isEmpty()) {
			ArrayList<Empresa> _empresas = buscarEmpresas(p_empresa);
			boolean _primeraEmpresa = true;

			if (!_empresas.isEmpty()) { // Si hay ofertas con ese titulo
				_sentencia += " AND ";
				_sentencia += Tablas.C_OFERTA_EMPRESA + " IN (";
				for (Empresa empresa : _empresas) {
					if (!_primeraEmpresa) { // Si el primer elemento en IN( ) no pongas coma
						_sentencia += ", ";
					} else {
						_primeraEmpresa = false;
					}
					_sentencia += "'" + empresa.getNumID() + "'";
				}
				_sentencia += ")";
			}
		}
		if (p_conocimientos != null && p_conocimientos.size() > 0) {
			boolean _primerConocimiento = true;

			_sentencia += " AND ";
			_sentencia += Tablas.C_OFER_CONO_CONOCIMIENTO + " IN (";
			for (String conocimiento : p_conocimientos) {
				if (!_primerConocimiento) { // Si el primer elemento en IN( ) no pongas coma
					_sentencia += ", ";
				} else {
					_primerConocimiento = false;
				}
				_sentencia += "'" + conocimiento + "'";
			}
			_sentencia += ")";
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

	public static ArrayList<Candidato> filtrarCandidatos(String p_nombreApellidos, String p_nick, String p_experiencia,
			String p_direccion, boolean p_carne, boolean p_coche, boolean p_viajes, ArrayList<String> p_conocimientos)
			throws SQLException {

		ArrayList<Candidato> _candidatos = new ArrayList<>();
		String _sentencia = "SELECT DISTINCT " + Tablas.C_CANDIDATO_NUMID + " FROM " + Tablas.C_USUARIO_TABLA + ", "
				+ Tablas.C_CANDIDATO_TABLA + ", " + Tablas.C_CANDI_CONO_TABLA + " WHERE " + Tablas.C_USUARIO_NUMID + "="
				+ Tablas.C_CANDIDATO_NUMID + " AND " + Tablas.C_CANDIDATO_NUMID + "=" + Tablas.C_CANDI_CONO_CANDIDATO;

		if (null != p_nombreApellidos && !p_nombreApellidos.isEmpty()) {
			String _nombre, _apellidos;
			_nombre = p_nombreApellidos.split(" ")[0];
			_apellidos = p_nombreApellidos.substring(p_nombreApellidos.indexOf(' ') + 1);
			_sentencia += " AND ";
			_sentencia += Tablas.C_USUARIO_NOMBRE + " LIKE '%" + _nombre + "%'";
			if (!_apellidos.isEmpty()) {
				_sentencia += " AND ";
				_sentencia += Tablas.C_CANDIDATO_APELLIDOS + " LIKE '%" + _apellidos + "%'";
			}
		}
		if (p_nick != null && !p_nick.isEmpty()) {
			_sentencia += " AND ";
			_sentencia += Tablas.C_USUARIO_NICK + " LIKE '%" + p_nick + "%'";
		}
		if (p_experiencia != null && !p_experiencia.isEmpty()) {
			_sentencia += " AND ";
			_sentencia += Tablas.C_CANDIDATO_EXPERIENCIA_LABORAL + " >= " + p_experiencia;
		}
		if (p_direccion != null && !p_direccion.isEmpty()) {
			_sentencia += " AND ";
			_sentencia += Tablas.C_USUARIO_DIRECCION + "LIKE '%" + p_direccion + "%'";
		}
		if (p_carne) {
			_sentencia += " AND ";
			_sentencia += Tablas.C_CANDIDATO_CARNET + "=1";
		}
		if (p_coche) {
			_sentencia += " AND ";
			_sentencia += Tablas.C_CANDIDATO_COCHE + "=1";
		}
		if (p_viajes) {
			_sentencia += " AND ";
			_sentencia += Tablas.C_CANDIDATO_VIAJES + "=1";
		}
		if (p_conocimientos != null && p_conocimientos.size() > 0) {
			boolean _primerConocimiento = true;

			_sentencia += " AND ";
			_sentencia += Tablas.C_CANDI_CONO_CONOCIMIENTO + " IN (";
			for (String conocimiento : p_conocimientos) {
				if (!_primerConocimiento) { // Si el primer elemento en IN( ) no pongas coma
					_sentencia += ", ";
				} else {
					_primerConocimiento = false;
				}
				_sentencia += "'" + conocimiento + "'";
			}
			_sentencia += ")";
		}

		_sentencia += ";";
		// Busca todas los candiadtos que concuerden con los filtros, los combierte en
		// Objetos y los mete en el array
		ResultSet _rs = Conexion.consultar(_sentencia);
		while (_rs.next()) {
			_candidatos.add((Candidato) toUsuario((_rs.getString(Tablas.C_CANDIDATO_NUMID)), false));
		}

		return _candidatos;
		// TODO tener en cuenta los nombres compuestos

	}

	public static ArrayList<Solicitud> descargarSolicitudes(Candidato candidato) throws SQLException {
		boolean fin = false;
		ArrayList<Solicitud> _solicitudes = new ArrayList<>();
		ResultSet _rs = Conexion.consultar("SELECT * FROM " + Tablas.C_SOLICITUD_TABLA + " WHERE "
				+ Tablas.C_SOLICITUD_CANDIDATO + "='" + candidato.getNumID() + "';");

		while (!fin) {
			try {
				_solicitudes.add(toSolicitud(_rs));
			} catch (ResultSetVacio e) {
				System.out.println("No se han encontrado solicitudes");
				fin = true;
			} catch (NoQuedanFilas e) {
				fin = true;
			}
		}

		return _solicitudes;
	}

	public static boolean existeEmail(String p_email) throws SQLException {
		ResultSet _rs = Conexion.consultar(
				"SELECT * FROM " + Tablas.C_USUARIO_TABLA + " WHERE " + Tablas.C_USUARIO_EMAIL + "='" + p_email + "';");
		return _rs.next();
	}

	public static void actualizarOferta(Oferta ofer) throws SQLException {
		Conexion.actualizar("UPDATE " + Tablas.C_OFERTA_TABLA + " SET " + Tablas.C_OFERTA_DESCRIPCION + "='" + ofer.getDescripcion() + "', "
				+ Tablas.C_OFERTA_LUGAR + "='" + ofer.getLugar() + "', " + Tablas.C_OFERTA_EXPERIENCIA + "="
				+ ofer.getExperiencia() + ", " + Tablas.C_OFERTA_TIPO_CONTRATO + "=" + ofer.getContrato() + ", "
				+ Tablas.C_OFERTA_SUELDO_MAX + "=" + ofer.getSalarioMax() + ", " + Tablas.C_OFERTA_SUELDO_MIN + "="
				+ ofer.getSalarioMin() + ", " + Tablas.C_OFERTA_ASPECTOS_IMPRESCINDIBLES + "='"
				+ ofer.getAspectosImprescindibles() + "', " + Tablas.C_OFERTA_ASPECTOS_VALORAR + "='"
				+ ofer.getAspectosAValorar() + "' WHERE " + Tablas.C_OFERTA_CODIGO + "=" + ofer.getCodigo() + ";");
		Conexion.actualizar("DELETE " + Tablas.C_OFER_CONO_TABLA + " WHERE " + Tablas.C_OFER_CONO_OFERTA + "="
				+ ofer.getCodigo() + ";");
		for (String conocimiento : ofer.getConocimientos()) {
			Conexion.actualizar("INSERT INTO " + Tablas.C_OFER_CONO_TABLA + " VALUES (" + ofer.getCodigo() + ", '"
					+ conocimiento + "');");
		}
	}

	public static void actualizarUsuario(Usuario usr) throws SQLException {
		Conexion.actualizar("UPDATE " + Tablas.C_USUARIO_TABLA + " SET " + Tablas.C_USUARIO_NOMBRE + "='"
				+ usr.getNombre() + "', " + Tablas.C_USUARIO_DIRECCION + "='" + usr.getDireccion() + "', "
				+ Tablas.C_USUARIO_EMAIL + "='" + usr.getEmail() + "', " + Tablas.C_USUARIO_TELEFONO + "='"
				+ usr.getTelefono() + "'" + " WHERE " + Tablas.C_USUARIO_NUMID + "='" + usr.getNumID() + "';");

		if (usr instanceof Candidato) {
			Candidato can = (Candidato) usr;
			Conexion.actualizar("UPDATE " + Tablas.C_CANDIDATO_TABLA + " SET " + Tablas.C_CANDIDATO_APELLIDOS + "='"
					+ can.getApellidos() + "', " + Tablas.C_CANDIDATO_VIAJES + "=" + (can.hasDisViajar() ? 1 : 0) + ", "
					+ Tablas.C_CANDIDATO_CARNET + "=" + (can.hasCarnet() ? 1 : 0) + ", " + Tablas.C_CANDIDATO_COCHE
					+ "=" + (can.hasCochePropio() ? 1 : 0) + ", " + Tablas.C_CANDIDATO_EXPERIENCIA_LABORAL + "="
					+ can.getExperienciaProfesional() + ", " + Tablas.C_CANDIDATO_OTROS_CONOCIMIENTOS + "='"
					+ can.getOtrosConocimientos() + "', " + Tablas.C_CANDIDATO_VIDA_LABORAL + "='"
					+ can.getVidaLaboral() + "', " + Tablas.C_CANDIDATO_ESTUDIOS + "='" + can.getEstudios() + "', "
					+ Tablas.C_CANDIDATO_FECHA_NAC + "='" + can.getFechaNac() + "' WHERE " + Tablas.C_CANDIDATO_NUMID
					+ "='" + can.getNumID() + "';");
			Conexion.actualizar("DELETE " + Tablas.C_CANDI_CONO_TABLA + " WHERE " + Tablas.C_CANDI_CONO_CANDIDATO + "='"
					+ can.getNumID() + "';");
			for (String conocimiento : can.getConocimientos()) {
				Conexion.actualizar("INSERT INTO " + Tablas.C_CANDI_CONO_TABLA + " VALUES ('" + can.getNumID() + "', '"
						+ conocimiento + "');");
			}
		} else {
			Empresa emp = (Empresa) usr;
			Conexion.actualizar("UPDATE " + Tablas.C_EMPRESA_TABLA + " SET " + Tablas.C_EMPRESA_DESCRIPCION + "='"
					+ emp.getDescripcion() + "', " + Tablas.C_EMPRESA_CONTACTO + "='" + emp.getContacto() + "' WHERE "
					+ Tablas.C_EMPRESA_NUMID + "='" + emp.getNumID() + "';");
		}
	}

	public static void eliminarElemento(Object obj) throws SQLException {
		if (obj instanceof Oferta) {
			Oferta ofer = (Oferta) obj;
			Conexion.actualizar("DELETE " + Tablas.C_OFERTA_TABLA + " WHERE " + Tablas.C_OFERTA_CODIGO + "="
					+ ofer.getCodigo() + ";");

		} else if (obj instanceof Solicitud) {
			Solicitud soli = (Solicitud) obj;
			Conexion.actualizar("DELETE " + Tablas.C_SOLICITUD_TABLA + " WHERE " + Tablas.C_SOLICITUD_CANDIDATO + "='"
					+ soli.getCand().getNumID() + "' AND " + Tablas.C_SOLICITUD_OFERTA + "="
					+ soli.getOfer().getCodigo() + ";");
		}
	}

	public static ArrayList<String> buscarConocimientosRequeridos() throws SQLException {
		ArrayList<String> _conocimientos = new ArrayList<>();
		ResultSet _rs = Conexion.consultar("SELECT " + Tablas.C_OFER_CONO_CONOCIMIENTO + ", COUNT(*) FROM "
				+ Tablas.C_OFER_CONO_TABLA + " GROUP BY " + Tablas.C_OFER_CONO_CONOCIMIENTO + " ORDER BY 2 DESC;");

		while (_rs.next()) {
			_conocimientos.add(_rs.getString(1));
		}

		return _conocimientos;
	}

}
