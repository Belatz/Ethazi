package ethazi.intefaz.frame;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.Empresa;
import ethazi.aplicacion.Oferta;
import ethazi.aplicacion.Usuario;
import ethazi.aplicacion.Utilidades;
import ethazi.datos.UtilidadesBD;
import ethazi.excepciones.PanelNoDisponible;
import ethazi.intefaz.Elemento_A_Listar;
import ethazi.intefaz.Elemento_Listable;
import ethazi.intefaz.paneles.GenericoDePanelesConLista;
import ethazi.intefaz.paneles.PanelAbrirOferta;
import ethazi.intefaz.paneles.PanelBarraHerramientas;
import ethazi.intefaz.paneles.PanelConocimientosBuscados;
import ethazi.intefaz.paneles.PanelMenu;
import ethazi.intefaz.paneles.PanelPublicarOferta;
import ethazi.intefaz.paneles.PanelRealizarSolicitud;
import ethazi.intefaz.paneles.PanelVerPerfil;

/**
 * @author Nestor, Belatz, Xavier, JonOr, Urtzi, Edu
 */
public class VentanaPrincipal extends JFrame {
	/**
	 * Is the main window from where we load the JPanels
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static JPanel pa_contenedor = new JPanel();
	private static VentanaPrincipal frame;
	private static JPanel currentPanel;
	private static ArrayList<Elemento_Listable> listaDeElementos = new ArrayList<Elemento_Listable>();
	private static GenericoDePanelesConLista panelListadoGenerico = null;
	private static PanelBarraHerramientas pa_barraHerramientas;
	private static PanelAbrirOferta pa_abrirOferta = null;
	private static PanelVerPerfil pa_verPerfil = null;
	private static PanelPublicarOferta pa_publicarOferta = null;
	private static PanelConocimientosBuscados pa_conocimientosBuscados = null;
	private static PanelMenu menu;
	private static PanelRealizarSolicitud pa_realizarSolicitud;

	public static final short C_BUSCAR_OFERTA = 0;
	public static final short C_ANALIZAR_EMPRESA = 1;
	public static final short C_ANALIZAR_CANDIDATO = 2;
	public static final short C_OFERTAS_ADECUADAS = 3;
	public static final short C_CONOCIMIENTOS_BUSCADOS = 4;
	public static final short C_SUS_SOLICITUDES = 5;
	public static final short C_SUS_OFERTAS = 6;
	public static final short C_REALIZAR_SOLICITUD = 7;
	public static final short C_PUBLICAR_OFERTA = 8;
	public static final short C_ABRIR_OFERTA = 9;
	public static final short C_VER_PERFIL = 11;
	public static final short C_CONSULTAR_CANDIDATOS = 12;
	public static final short C_ANALIZAR_SOLICITUDES = 13;
	public static final short C_OFERTAS_CON_SOLICITUDES = 14;

	/**
	 * Launches the frame
	 */
	public static void ejecutar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame and panels
	 * 
	 * @throws SQLException
	 */
	public VentanaPrincipal() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 575);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		// Menu desplegable
		// EL menu comienza ahora mas abajo para que no quede encima de el boton que lo
		// abre al usar un boton
		// de el menu
		menu = new PanelMenu();

		if (Aplicacion.getUsuario() instanceof Candidato) {
			menu.setBounds(365, 11, 258, 143);
		} else {
			menu.setBounds(365, 11, 258, 173);
		}
		contentPane.add(menu);
		menu.setLayout(null);
		menu.setVisible(false);
		// Prueba jonor: si lo borrais moris
		/*
		 * Oferta oferta; Empresa empresa; empresa = new
		 * Empresa("ASD","asd","asd","asd","asd","asd","asd","asd","asd");
		 * ArrayList<String> con = new ArrayList<String>(); con.add("asd"); int cont =
		 * 0; while (cont < 12) { oferta = new Oferta(2+cont, "titulo"+cont,"sd",
		 * "sdf",4,4,3, "sdf","asdf",true,(byte)1,empresa,con);
		 * listaDeOfertas.add(oferta); cont++; pa_buscarOfertas = new
		 * GenericoDePanelesConLista(listaDeOfertas, (byte)1); }
		 */
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				menu.setVisible(false);
				PanelBarraHerramientas.botonMenuInv();
			}
		});

		// Crear contenedor
		pa_contenedor.setBounds(0, 55, 762, 488);
		contentPane.add(pa_contenedor);
		pa_contenedor.setLayout(new CardLayout(0, 0));

		// Barra de herramientas
		pa_barraHerramientas = new PanelBarraHerramientas();
		pa_barraHerramientas.setLocation(0, 0);
		contentPane.add(pa_barraHerramientas);

		// Crear paneles
		crearPaneles();

		// Crear panel inicial
		crearPrimerPanel();
	}

	public static PanelBarraHerramientas getPa_barraHerramientas() {
		return pa_barraHerramientas;
	}

	/**
	 * @author belatz
	 * @throws SQLException
	 */
	public static void crearPrimerPanel() throws SQLException {
		if (Aplicacion.getUsuario() instanceof Candidato) {
			// Buscar ofertas adecuadas
			currentPanel = panelListadoGenerico;

		} else {
			listaDeElementos = Utilidades
					.cambiarOfertaAElemento(UtilidadesBD.buscarOfertasEmpresa(Aplicacion.getUsuario().getNumID()));
			if (listaDeElementos.isEmpty()) { // Si no tiene ofertas publicadas
				currentPanel = pa_publicarOferta;
				System.out.println("LOG: PANEL ACTUAL -- Publicar Oferta");
			} else {

				currentPanel = panelListadoGenerico;
			}
		}
		currentPanel.setVisible(true);
	}

	/**
	 * Creates all the panels that could be used by the current user
	 * 
	 * @author belatz
	 * @throws SQLException
	 */
	@SuppressWarnings("null")
	public void crearPaneles() throws SQLException {
		// ArrayList<Oferta> Ofertas = new ArrayList<Oferta>();
		if (Aplicacion.getUsuario() instanceof Candidato) { // Si es candidato crea sus posibles ventanas
			Candidato _usr = (Candidato) Aplicacion.getUsuario();

			try {
				listaDeElementos = Utilidades.cambiarOfertaAElemento(UtilidadesBD.filtrarOfertas(null, null, null, null,
						String.valueOf(_usr.getExperienciaProfesional()), -1, null,
						UtilidadesBD.descargarConocimientosCandidato(_usr.getNumID())));

			} catch (SQLException e) {
				e.printStackTrace();
			}

			panelListadoGenerico = new GenericoDePanelesConLista(listaDeElementos,
					Elemento_A_Listar.C_CONSULTAR_OFERTAS);
			pa_contenedor.add(panelListadoGenerico);
			panelListadoGenerico.setVisible(false);
			/*
			 * pa_buscarOfertas = new GenericoDePanelesConLista(listaDeElementos, (byte) 1);
			 * currentPanel = new JPanel(); pa_buscarOfertas.setVisible(false); // Crear
			 * consultar ofertas adecuadas _elementos =
			 * Utilidades.cambiarOfertaAElemento(UtilidadesBD.filtrarOfertas(null, null,
			 * null, null, String.valueOf(_usr.getExperienciaProfesional()), -1, null,
			 * UtilidadesBD.descargarConocimientosCandidato(_usr.getNumID())));
			 * pa_ofertasAdecuadas = new GenericoDePanelesConLista(_elementos,
			 * Elemento_A_Listar.C_CONSULTAR_OFERTAS);
			 * pa_contenedor.add(pa_ofertasAdecuadas);
			 * pa_ofertasAdecuadas.setVisible(false);
			 */
			// Crear consultar sus solicitudes
			/*
			 * _elementos =
			 * Utilidades.cambiarSolicitudAElemento(UtilidadesBD.descargarSolicitudes(_usr))
			 * ; pa_susSolicitudes = new GenericoDePanelesConLista(_elementos,
			 * Elemento_A_Listar.C_CONSULTAR_SUS_SOLICITUDES);
			 * pa_contenedor.add(pa_susSolicitudes); pa_susSolicitudes.setVisible(false);
			 */
			// Crear consultar conocimientos mas buscados
			pa_conocimientosBuscados = new PanelConocimientosBuscados();
			pa_contenedor.add(pa_conocimientosBuscados);
			pa_conocimientosBuscados.setVisible(false);

			// Crear realizar solicitud
			PanelRealizarSolicitud pa_realizarSolicitud = new PanelRealizarSolicitud();
			pa_contenedor.add(pa_realizarSolicitud);
			pa_realizarSolicitud.setVisible(false);

			// Crear abrir oferta
			pa_abrirOferta = new PanelAbrirOferta();
			pa_contenedor.add(pa_abrirOferta);
			pa_abrirOferta.setVisible(false);
			// Crear ver perfil
			pa_verPerfil = new PanelVerPerfil();
			pa_contenedor.add(pa_verPerfil);
			pa_verPerfil.setVisible(false);
		} else { // Si es empresa crea sus posibles ventanas
			Empresa _usr = (Empresa) Aplicacion.getUsuario();

			// Crear consultar candidatos
			listaDeElementos = Utilidades.cambiarCandidatoAElemento(
					UtilidadesBD.filtrarCandidatos(null, null, null, null, false, false, false, null));
			panelListadoGenerico = new GenericoDePanelesConLista(listaDeElementos,
					Elemento_A_Listar.C_BUSCAR_CANDIDATOS);
			pa_contenedor.add(panelListadoGenerico);
			panelListadoGenerico.setVisible(false);
			// Crear consultar sus ofertas

			/*
			 * Importante listaDeElementos =
			 * Utilidades.cambiarOfertaAElemento(UtilidadesBD.buscarOfertasEmpresa(_usr.
			 * getNumID())); panelListadoGenerico = new
			 * GenericoDePanelesConLista(listaDeElementos,
			 * Elemento_A_Listar.C_CONSULTAR_SUS_OFERTAS);
			 * pa_contenedor.add(panelListadoGenerico);
			 * panelListadoGenerico.setVisible(false);
			 */
			// Crear publicar oferta
			pa_publicarOferta = new PanelPublicarOferta();
			pa_contenedor.add(pa_publicarOferta);
			pa_publicarOferta.setVisible(false);
			// Crear analizar solicitudes
			panelListadoGenerico = new GenericoDePanelesConLista(new ArrayList<Elemento_Listable>(),
					Elemento_A_Listar.C_ANALIZAR_SOLICITUDES);
			// Crear consultar ofertas con solicitudes
			listaDeElementos = Utilidades
					.cambiarOfertaAElemento(UtilidadesBD.buscarOfertasConSolicitud(_usr.getNumID()));
			panelListadoGenerico = new GenericoDePanelesConLista(listaDeElementos,
					Elemento_A_Listar.C_VER_OFERTAS_CON_SOLICITUD);
			pa_contenedor.add(panelListadoGenerico);
			panelListadoGenerico.setVisible(false);
			// Crear abrir oferta
			pa_abrirOferta = new PanelAbrirOferta();
			pa_contenedor.add(pa_abrirOferta);
			pa_abrirOferta.setVisible(false);
			// Crear ver perfil
			pa_verPerfil = new PanelVerPerfil();
			pa_contenedor.add(pa_verPerfil);
			pa_verPerfil.setVisible(false);
		}
	}

	public static void cambiarPanel(short p_nuevoPanel) throws PanelNoDisponible, SQLException {
		cambiarPanel(p_nuevoPanel, null);
	}

	/**
	 * Switches between panels
	 * 
	 * @author belatz
	 * @param p_nuevoPanel
	 *            The new panel to show
	 * @throws PanelNoDisponible
	 *             If the choosen panel doesn't exist
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public static void cambiarPanel(short p_nuevoPanel, Object p_obj) throws PanelNoDisponible, SQLException {
		currentPanel.setVisible(false);
		JPanel nuevoPanel = new JPanel();

		if (p_obj instanceof ArrayList<?>) {
			listaDeElementos = (ArrayList<Elemento_Listable>) p_obj;
		}
//d
		switch (p_nuevoPanel) {
		case C_ABRIR_OFERTA:
		{
			pa_abrirOferta.cambiarOferta((Oferta) p_obj);
			nuevoPanel = pa_abrirOferta;
		}
			break;
		case C_ANALIZAR_CANDIDATO:
			pa_verPerfil.cambiarPerfil((Usuario) p_obj, false);
			nuevoPanel = pa_verPerfil;
			break;
		case C_ANALIZAR_EMPRESA:
			pa_verPerfil.cambiarPerfil((Usuario) p_obj, false);
			nuevoPanel = pa_verPerfil;
			break;
		case C_ANALIZAR_SOLICITUDES:
			panelListadoGenerico.actualizar(listaDeElementos, Elemento_A_Listar.C_ANALIZAR_SOLICITUDES);
			nuevoPanel = panelListadoGenerico;
			// nuevoPanel = pa_analizarSolicitudes;
			break;
		case C_BUSCAR_OFERTA:
			panelListadoGenerico.actualizar(listaDeElementos, Elemento_A_Listar.C_CONSULTAR_OFERTAS);
			nuevoPanel = panelListadoGenerico;
			break;
		case C_CONOCIMIENTOS_BUSCADOS:
			nuevoPanel = pa_conocimientosBuscados;
			break;
		case C_CONSULTAR_CANDIDATOS:
			panelListadoGenerico.actualizar(listaDeElementos, Elemento_A_Listar.C_BUSCAR_CANDIDATOS);
			nuevoPanel = panelListadoGenerico;
			// nuevoPanel = pa_consultarCandidatos;
			break;
		case C_OFERTAS_ADECUADAS:
			panelListadoGenerico.actualizar(listaDeElementos, Elemento_A_Listar.C_CONSULTAR_OFERTAS);
			nuevoPanel = panelListadoGenerico;
			// nuevoPanel = pa_ofertasAdecuadas;
			break;
		case C_OFERTAS_CON_SOLICITUDES:
			panelListadoGenerico.actualizar(listaDeElementos, Elemento_A_Listar.C_VER_OFERTAS_CON_SOLICITUD);
			nuevoPanel = panelListadoGenerico;
			break;
		case C_PUBLICAR_OFERTA:
			nuevoPanel = pa_publicarOferta;
			break;
		case C_REALIZAR_SOLICITUD:
			nuevoPanel = pa_realizarSolicitud;
			break;
		case C_SUS_OFERTAS:
			panelListadoGenerico.actualizar(listaDeElementos, Elemento_A_Listar.C_CONSULTAR_SUS_OFERTAS);
			nuevoPanel = panelListadoGenerico;
			// nuevoPanel = pa_susOfertas;
			break;
		case C_SUS_SOLICITUDES:
			panelListadoGenerico.actualizar(listaDeElementos, Elemento_A_Listar.C_CONSULTAR_SUS_SOLICITUDES);
			nuevoPanel = panelListadoGenerico;
			// nuevoPanel = pa_susSolicitudes;
			break;
		case C_VER_PERFIL:
			pa_verPerfil.cambiarPerfil(Aplicacion.getUsuario(), true);
			nuevoPanel = pa_verPerfil;
			break;

		default:
			throw new PanelNoDisponible("La opcion elegida no existe");
		}

		if (nuevoPanel == null) {
			throw new PanelNoDisponible("El panel elegido no se ha generado");
		}

		nuevoPanel.setVisible(true);
		currentPanel = nuevoPanel;
		// pa_buscarOfertas.setVisible(true);
		System.out.println("LOG: PANEL ACTUAL -- " + currentPanel.getName());
		pa_contenedor.updateUI();
	}

	/**
	 * @author Jon
	 * @param listaDeOfertas
	 */

	/**
	 * @author Belatz
	 * @param listaDeOfertas
	 * @param tipoPanel
	 */

	public static void visibilidadMenu() {

		menu.setVisible(true);
		menu.requestFocus();
	}

	public static void visMenu2() {
		menu.setVisible(false);
	}

	public static void desHabVentana(boolean hab, Container pane) {
		for (int i = 0; i < pane.getComponentCount(); i++) {
			pane.getComponent(i).setEnabled(hab);
			if (pane.getComponent(i) instanceof JPanel) {
				desHabVentana(hab, (JPanel) pane.getComponent(i));
			}
		}
	}

	/**
	 * Quita la visibilidad a la ventana
	 */
	// TODO arreglar
	public static void cerrar() {
		frame.setVisible(false);
		currentPanel.setVisible(false);
	}

	/**
	 * Hace visible la ventana
	 */
	public static void abrir() {
		frame.setVisible(true);
	}

	public static ArrayList<Elemento_Listable> getListaDeElementos() {
		return listaDeElementos;
	}

	public static void setListaDeElementos(ArrayList<Elemento_Listable> listaDeElementos) {
		VentanaPrincipal.listaDeElementos = listaDeElementos;
	}

	public static GenericoDePanelesConLista getPanelListadoGenerico() {
		return panelListadoGenerico;
	}

}
