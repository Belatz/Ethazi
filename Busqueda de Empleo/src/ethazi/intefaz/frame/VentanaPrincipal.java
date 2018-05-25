package ethazi.intefaz.frame;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
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
import ethazi.datos.Conexion;
import ethazi.datos.Tablas;
import ethazi.datos.UtilidadesBD;
import ethazi.excepciones.PanelNoDisponible;
import ethazi.intefaz.Elemento_A_Listar;
import ethazi.intefaz.Elemento_Listable;
import ethazi.intefaz.paneles.GenericoDePanelesConLista;
import ethazi.intefaz.paneles.PanelAbrirOferta;
import ethazi.intefaz.paneles.PanelAnalizarCandidato;
import ethazi.intefaz.paneles.PanelBarraHerramientas;
import ethazi.intefaz.paneles.PanelConocimientosBuscados;
import ethazi.intefaz.paneles.PanelMenu;
import ethazi.intefaz.paneles.PanelPublicarOferta;
import ethazi.intefaz.paneles.PanelRealizarSolicitud;
import ethazi.intefaz.paneles.PanelVerPerfil;

public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static JPanel pa_contenedor = new JPanel();
	private static byte visMenu = 0;
	private static VentanaPrincipal frame;
	private static JPanel currentPanel;

	private static JPanel pa_buscarOfertas = null;
	private static JPanel pa_ofertasAdecuadas = null;
	private static JPanel pa_susSolicitudes = null;
	private static JPanel pa_conocimientosBuscados = null;
	private static JPanel pa_realizarSolicitud = null;
	private static JPanel pa_abrirOferta = null;
	private static JPanel pa_verPerfil = null;
	private static JPanel pa_consultarCandidatos = null;
	private static JPanel pa_susOfertas;
	private static JPanel panelDeOfertas;
	private static JPanel pa_publicarOferta = null;
	private static JPanel pa_analizarCandidato = null;
	private static JPanel pa_analizarSolicitudes = null;
	private static JPanel pa_ofertasConSolici = null;
	private static JPanel menu;

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

	// variable de prueba
	// ArrayList<Elemento_Listable> ofertas = new ArrayList<Elemento_Listable>();

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
	 */
	public VentanaPrincipal() {
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
		menu = new PanelMenu();
		if (Aplicacion.getUsuario() instanceof Candidato) {
			menu.setBounds(350, 0, 251, 115);
		} else {
			menu.setBounds(350, 0, 251, 147);
		}
		contentPane.add(menu);
		menu.setLayout(null);
		menu.setVisible(false);
		MouseListener ml = new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("ola");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				menu.setVisible(false);
				PanelBarraHerramientas.botonMenuInv();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		};
		menu.addMouseListener(ml);

		// Crear contenedor
		pa_contenedor.setBounds(0, 55, 762, 488);
		contentPane.add(pa_contenedor);
		pa_contenedor.setLayout(new CardLayout(0, 0));

		// Barra de herramientas
		JPanel pa_barraHerramientas = new PanelBarraHerramientas();
		pa_barraHerramientas.setLocation(0, 0);
		contentPane.add(pa_barraHerramientas);

		// Crear panel inicial
		try {
			crearPaneles();
			crearPrimerPanel();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @author belatz
	 * @throws SQLException
	 */
	public static void crearPrimerPanel() throws SQLException {
		if (Aplicacion.getUsuario() instanceof Candidato) {
			// Buscar ofertas adecuadas
			currentPanel = pa_ofertasAdecuadas;
		} else {
			ArrayList<Oferta> _ofertas = UtilidadesBD.buscarOfertasEmpresa(Aplicacion.getUsuario().getNumID());

			if (_ofertas.isEmpty()) { // Si no tiene ofertas publicadas
				currentPanel = pa_publicarOferta;
			} else {
				// Buscar ofertas con solicitudes
				currentPanel = pa_ofertasConSolici;
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
	public void crearPaneles() throws SQLException {
		ArrayList<Elemento_Listable> _elementos = new ArrayList<>();

		if (Aplicacion.getUsuario() instanceof Candidato) { // Si es candidato crea sus posibles ventanas
			Candidato _usr = (Candidato) Aplicacion.getUsuario();

			// Crear consultar ofertas adecuadas
			_elementos = Utilidades.cambiarOfertaAElemento(UtilidadesBD.filtrarOfertas(null, null, null, null,
					String.valueOf(_usr.getExperienciaProfesional()), null, null,
					UtilidadesBD.descargarConocimientosCandidato(_usr.getNumID())));
			pa_ofertasAdecuadas = new GenericoDePanelesConLista(_elementos, Elemento_A_Listar.C_CONSULTAR_OFERTAS);
			pa_contenedor.add(pa_ofertasAdecuadas);
			pa_ofertasAdecuadas.setVisible(false);
			// Crear consultar sus solicitudes
			_elementos = Utilidades.cambiarSolicitudAElemento(UtilidadesBD.descargarSolicitudes(_usr));
			pa_susSolicitudes = new GenericoDePanelesConLista(_elementos,
					Elemento_A_Listar.C_CONSULTAR_SUS_SOLICITUDES);
			pa_contenedor.add(pa_susSolicitudes);
			pa_susSolicitudes.setVisible(false);
			// Crear consultar conocimientos mas buscados
			pa_conocimientosBuscados = new PanelConocimientosBuscados();
			pa_contenedor.add(pa_conocimientosBuscados);
			pa_conocimientosBuscados.setVisible(false);
			// Crear realizar solicitud
			pa_realizarSolicitud = new PanelRealizarSolicitud();
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
			// TODO añadir listado de candidatos
			/*pa_consultarCandidatos = new GenericoDePanelesConLista(listaDeElementosListables,
					Elemento_A_Listar.C_BUSCAR_CANDIDATOS); 
			pa_contenedor.add(pa_consultarCandidatos);
			pa_consultarCandidatos.setVisible(false);*/
			// Crear consultar sus ofertas
			_elementos = Utilidades.cambiarOfertaAElemento(UtilidadesBD.buscarOfertasEmpresa(_usr.getNumID()));
			pa_susOfertas = new GenericoDePanelesConLista(_elementos, Elemento_A_Listar.C_CONSULTAR_SUS_OFERTAS);
			pa_contenedor.add(pa_susOfertas);
			pa_susOfertas.setVisible(false);
			// Crear publicar oferta
			pa_publicarOferta = new PanelPublicarOferta();
			pa_contenedor.add(pa_publicarOferta);
			pa_publicarOferta.setVisible(false);
			// Crear analizar solicitudes
			// TODO añadir listado de solicitudes
			/*pa_analizarSolicitudes = new GenericoDePanelesConLista(listaDeElementosListables,
					Elemento_A_Listar.C_ANALIZAR_SOLICITUDES); */
			// Crear consultar ofertas con solicitudes
			_elementos = Utilidades.cambiarOfertaAElemento(UtilidadesBD.buscarOfertasConSolicitud(_usr.getNumID()));
			pa_ofertasConSolici = new GenericoDePanelesConLista(_elementos,
					Elemento_A_Listar.C_VER_OFERTAS_CON_SOLICITUD);
			pa_contenedor.add(pa_ofertasConSolici);
			pa_ofertasConSolici.setVisible(false);
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

	/**
	 * Switches between panels
	 * 
	 * @author belatz
	 * @param p_nuevoPanel
	 *            The new panel to show
	 * @throws PanelNoDisponible
	 *             If the choosen panel doesn't exist
	 */
	public static void cambiarPanel(short p_nuevoPanel) throws PanelNoDisponible {
		currentPanel.setVisible(false);
		JPanel nuevoPanel = null;

		switch (p_nuevoPanel) {
		case C_ABRIR_OFERTA:
			nuevoPanel = pa_abrirOferta;
			break;
		case C_ANALIZAR_CANDIDATO:

			break;
		case C_ANALIZAR_EMPRESA:

			break;
		case C_ANALIZAR_SOLICITUDES:

			break;
		case C_BUSCAR_OFERTA:
			pa_buscarOfertas.updateUI();
			;
			pa_buscarOfertas.setVisible(true);
			break;
		case C_CONOCIMIENTOS_BUSCADOS:
			nuevoPanel = pa_conocimientosBuscados;
			break;
		case C_CONSULTAR_CANDIDATOS:

			break;
		case C_OFERTAS_ADECUADAS:

			break;
		case C_OFERTAS_CON_SOLICITUDES:
			nuevoPanel = pa_ofertasConSolici;
			break;
		case C_PUBLICAR_OFERTA:
			nuevoPanel = pa_publicarOferta;
			break;
		case C_REALIZAR_SOLICITUD:
			nuevoPanel = pa_realizarSolicitud;
			break;
		case C_SUS_OFERTAS:

			break;
		case C_SUS_SOLICITUDES:

			break;
		case C_VER_PERFIL:

			break;

		default:
			throw new PanelNoDisponible("La opcion elegida no existe");
		}

		if (nuevoPanel == null) {
			throw new PanelNoDisponible("El panel elegido no se ha generado");
		}

		nuevoPanel.setVisible(true);
		currentPanel = nuevoPanel;
	}

	public static void actualizar(ArrayList<Elemento_Listable> listaDeOfertas) {
		pa_buscarOfertas.updateUI();
		pa_buscarOfertas = new GenericoDePanelesConLista(listaDeOfertas, (byte) 1);
	}

	public static void visibilidadMenu() {
		visMenu = 0;
		menu.setVisible(true);
		menu.requestFocus();
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
	public static void cerrar() {
		frame.setVisible(false);
	}

	/**
	 * Hace visible la ventana
	 */
	public static void abrir() {
		frame.setVisible(true);
	}
}
