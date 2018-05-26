package ethazi.intefaz.frame;

import java.awt.CardLayout;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import ethazi.intefaz.paneles.PanelBarraHerramientas;
import ethazi.intefaz.paneles.PanelConocimientosBuscados;

import ethazi.intefaz.paneles.PanelEditarOferta;
import ethazi.intefaz.paneles.PanelMenu;
import ethazi.intefaz.paneles.PanelPublicarOferta;
import ethazi.intefaz.paneles.PanelRealizarSolicitud;
import ethazi.intefaz.Elemento_A_Listar;
import ethazi.intefaz.Elemento_Listable;
import ethazi.intefaz.paneles.GenericoDePanelesConLista;

import javax.swing.JTextField;

import javax.swing.JButton;

import java.awt.Font;

import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.Oferta;
import ethazi.aplicacion.Usuario;
import ethazi.aplicacion.Utilidades;
import ethazi.datos.Conexion;
import ethazi.datos.Tablas;
import ethazi.datos.UtilidadesBD;
import ethazi.excepciones.PanelNoDisponible;
import ethazi.intefaz.paneles.PanelAnalizarCandidato;
import ethazi.intefaz.paneles.PanelVerPerfil;

public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static byte visMenu = 0;
	private static VentanaPrincipal frame;
	private static JPanel currentPanel;

	private static JPanel contentPane;
	private static JPanel pa_contenedor = new JPanel();
	public static ArrayList<Elemento_Listable> listaDeElementos = new ArrayList<Elemento_Listable>();
	private static boolean genericousado = true;

	private static GenericoDePanelesConLista pa_buscarOfertas = null;
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
		menu = new PanelMenu();
		if (Aplicacion.getUsuario() instanceof Candidato) {
			menu.setBounds(350, 0, 251, 115);
		} else {
			menu.setBounds(350, 0, 251, 147);
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
			crearPrimerPanel();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Crear paneles
		crearPaneles();
	}

	/**
	 * @author belatz
	 * @throws SQLException
	 */
	public static void crearPrimerPanel() throws SQLException {
		Usuario usr = Aplicacion.getUsuario();
		if (Aplicacion.getUsuario() instanceof Candidato) {
			// Buscar ofertas adecuadas
			Candidato _usr = (Candidato) usr;
			ArrayList<Elemento_Listable> _ofertas = Utilidades.cambiarOfertaAElemento(UtilidadesBD.filtrarOfertas(null,
					null, null, null, String.valueOf(_usr.getExperienciaProfesional()), null, null,
					UtilidadesBD.descargarConocimientosCandidato(_usr.getNumID())));
			
			pa_ofertasAdecuadas = new GenericoDePanelesConLista(_ofertas, Elemento_A_Listar.C_CONSULTAR_OFERTAS);
			pa_contenedor.add(pa_ofertasAdecuadas);
		} else {
			ArrayList<Oferta> _ofertas = UtilidadesBD.buscarOfertasEmpresa(Aplicacion.getUsuario().getNumID());

			if (_ofertas.isEmpty()) { // Si no tiene ofertas publicadas
				pa_publicarOferta = new PanelPublicarOferta();
				pa_contenedor.add(pa_publicarOferta);
			} else {
				// Buscar ofertas con solicitudes
				ArrayList<Elemento_Listable> _ofertasConSolicitud = new ArrayList<>();
				ResultSet _rs = Conexion.consultar("SELECT "+Tablas.C_OFERTA_CODIGO+" FROM "+Tablas.C_OFERTA_TABLA+", "+Tablas.C_SOLICITUD_TABLA+" WHERE "+Tablas.C_OFERTA_CODIGO+"="+Tablas.C_SOLICITUD_OFERTA+";");
				
				while(_rs.next()) {
					_ofertas.add(UtilidadesBD.toOferta(_rs.getString(Tablas.C_OFERTA_CODIGO)));
				}
				
				pa_ofertasConSolici = new GenericoDePanelesConLista(_ofertasConSolicitud,
						Elemento_A_Listar.C_VER_OFERTAS_CON_SOLICITUD);
				pa_contenedor.add(pa_ofertasConSolici);
			}
		}
	}

	/**
	 * Creates all the panels that could be used by the current user
	 * 
	 * @deprecated
	 * @author belatz
	 * @throws SQLException
	 */
	public void crearPaneles() {
		if (Aplicacion.getUsuario() instanceof Candidato) { // Si es candidato crea sus posibles ventanas
			// Buscar ofertas
			try {
				listaDeElementos = UtilidadesBD.buscarOfertas("Pro");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pa_buscarOfertas = new GenericoDePanelesConLista(listaDeElementos, (byte) 1);
			currentPanel = new JPanel();
			pa_buscarOfertas.setVisible(true);
			// Crear consultar ofertas adecuadas
			// Crear consultar sus solicitudes
			// Crear consultar conocimientos mas buscados
			pa_conocimientosBuscados = new PanelConocimientosBuscados();
			// Crear realizar solicitud
			pa_realizarSolicitud = new PanelRealizarSolicitud();
			pa_contenedor.add(pa_realizarSolicitud);
			// Crear abrir oferta
			pa_abrirOferta = new JPanel();
			pa_contenedor.add(pa_abrirOferta);
			// Crear ver perfil
			pa_verPerfil = new PanelVerPerfil(Aplicacion.getUsuario(), true);
			pa_contenedor.add(pa_verPerfil);
		} else { // Si es empresa crea sus posibles ventanas
			// Crear consultar candidatos
			// Crear consultar sus ofertas
			// Crear publicar oferta
			pa_publicarOferta = new PanelPublicarOferta();
			pa_contenedor.add(pa_publicarOferta);
			// Crear analizar candidato
			pa_analizarCandidato = new PanelAnalizarCandidato();
			pa_contenedor.add(pa_analizarCandidato);
			// Crear analizar solicitudes
			// Crear consultar ofertas con solicitudes
			// pa_contenedor.add(pa_ofertasConSolici);
			// Crear abrir oferta
			// pa_contenedor.add(pa_abrirOferta);
			// Crear ver perfil
			// Crear editar perfil
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
		JPanel nuevoPanel = new JPanel();

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
			try {
				cargarListado(Elemento_A_Listar.C_CONSULTAR_OFERTAS);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// __________________________________
			pa_buscarOfertas.updateUI();
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

		// if (nuevoPanel == null) {
		// // throw new PanelNoDisponible("El panel elegido no se ha generado");
		// }

		// nuevoPanel.setVisible(true);
		currentPanel = nuevoPanel;
		// currentPanel.setVisible(true);
		pa_buscarOfertas.setVisible(true);
	}

	public static void actualizar(ArrayList<Elemento_Listable> listaDeOfertas) {
		pa_buscarOfertas.updateUI();
		pa_buscarOfertas = new GenericoDePanelesConLista(listaDeOfertas, (byte) 1);
	}

	public static void visibilidadMenu() {

		menu.setVisible(true);
		menu.requestFocus();
	}

	public static void cargarListado(byte tipo) throws SQLException {
		switch (tipo) {
		case Elemento_A_Listar.C_CONSULTAR_SUS_SOLICITUDES:

			break;
		case Elemento_A_Listar.C_CONSULTAR_OFERTAS:
			listaDeElementos = UtilidadesBD.buscarOfertas(PanelBarraHerramientas.txField_buscar.getText());
			pa_buscarOfertas.actualizar(listaDeElementos, tipo);
			break;

		default:
			break;
		}

	}
	public static void visMenu2() {
	menu.setVisible(false);
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