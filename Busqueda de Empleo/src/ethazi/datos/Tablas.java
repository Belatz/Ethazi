package ethazi.datos;

public abstract class Tablas {
 
	// Tabla Usuario
	public static String C_USUARIO_TABLA = "USUARIO";
	public static String C_USUARIO_NUMID = "USUARIO.NUMID";
	public static String C_USUARIO_NICK = "USUARIO.NICK";
	public static String C_USUARIO_PASSWORD = "USUARIO.PASSWORD";
	public static String C_USUARIO_NOMBRE = "USUARIO.NOMBRE";
	public static String C_USUARIO_DIRECCION = "USUARIO.DIRECCION";
	public static String C_USUARIO_EMAIL = "USUARIO.EMAIL";
	public static String C_USUARIO_TELEFONO = "USUARIO.TELEFONO";

	// Tabla Candidato
	public static String C_CANDIDATO_TABLA = "CANDIDATO";
	public static String C_CANDIDATO_APELLIDOS = "CANDIDATO.APELLIDOS";
	public static String C_CANDIDATO_FECHA_NAC = "CANDIDATO.FECHA_NAC";
	public static String C_CANDIDATO_CARNET = "CANDIDATO.CARNET_CONDUCIR";
	public static String C_CANDIDATO_COCHE = "CANDIDATO.COCHE_PROPIO";
	public static String C_CANDIDATO_VIAJES = "CANDIDATO.DISP_VIAJAR";
	public static String C_CANDIDATO_ESTUDIOS = "CANDIDATO.ESTUDIOS";
	public static String C_CANDIDATO_OTROS_CONOCIMIENTOS = "CANDIDATO.OTROS_CONOCIMIENTOS";
	public static String C_CANDIDATO_VIDA_LABORAL = "CANDIDATO.VIDA_LABORAL";
	public static String C_CANDIDATO_EXPERIENCIA_LABORAL = "CANDIDATO.EXPERIENCIA_LABORAL";
	public static String C_CANDIDATO_NUMID = "CANDIDATO.NUMID";

	// Tabla Empresa
	public static String C_EMPRESA_TABLA = "EMPRESA";
	public static String C_EMPRESA_CONTACTO = "EMPRESA.CONTACTO";
	public static String C_EMPRESA_DESCRIPCION = "EMPRESA.DESCRIPCION";
	public static String C_EMPRESA_NUMID = "EMPRESA.NUMID";

	// Tabla Oferta
	public static String C_OFERTA_TABLA = "OFERTA";
	public static String C_OFERTA_CODIGO = "OFERTA.COD_OFERTA";
	public static String C_OFERTA_TITULO = "OFERTA.TITULO";
	public static String C_OFERTA_DESCRIPCION = "OFERTA.DESCRIPCION";
	public static String C_OFERTA_LUGAR = "OFERTA.LUGAR";
	public static String C_OFERTA_SUELDO_MAX = "OFERTA.SUELDO_MAX";
	public static String C_OFERTA_SUELDO_MIN = "OFERTA.SUELDO_MIN";
	public static String C_OFERTA_EXPERIENCIA = "OFERTA.EXPERIENCIA";
	public static String C_OFERTA_ASPECTOS_VALORAR = "OFERTA.ASPECTOS_VALORAR";
	public static String C_OFERTA_ASPECTOS_IMPRESCINDIBLES = "OFERTA.ASPECTOS_IMPRES";
	public static String C_OFERTA_VISIBLE = "OFERTA.VISIBLE";
	public static String C_OFERTA_EMPRESA = "OFERTA.EMPRESA_NUMID";
	public static String C_OFERTA_TIPO_CONTRATO = "OFERTA.TIPO_CONTRATO";

	// Tabla Solicitudes
	public static String C_SOLICITUD_TABLA = "SOLICITUDES";
	public static String C_SOLICITUD_OFERTA = "SOLICITUDES.OFERTA_COD_OFERTA";
	public static String C_SOLICITUD_CANDIDATO = "SOLICITUDES.CANDIDATO_NUMID";
	public static String C_SOLICITUD_PRESENTACION = "SOLICITUDES.PRESENTACION";

	// Tabla Conocimientos
	public static String C_CONOCIMIENTOS_TABLA = "CONOCIMIENTOS";
	public static String C_CONOCIMIENTOS_NOMBRE = "CONOCIMIENTOS.NOMBRE";

	// Tabla Candidato-Conocimientos
	public static String C_CANDI_CONO_TABLA = "CANDIDATO_CONOCIMIENTOS";
	public static String C_CANDI_CONO_CANDIDATO = "CANDIDATO_CONOCIMIENTOS.CANDIDATO_USUARIO_NUMID";
	public static String C_CANDI_CONO_CONOCIMIENTO = "CANDIDATO_CONOCIMIENTOS.CONOCIMIENTOS_NOMBRE";

	// Tabla Oferta-Conocimientos
	public static String C_OFER_CONO_TABLA = "OFERTA_CONOCIMIENTOS";
	public static String C_OFER_CONO_OFERTA = "OFERTA_CONOCIMIENTOS.OFERTA_COD_OFERTA";
	public static String C_OFER_CONO_CONOCIMIENTO = "OFERTA_CONOCIMIENTOS.CONOCIMIENTOS_NOMBRE";

}
