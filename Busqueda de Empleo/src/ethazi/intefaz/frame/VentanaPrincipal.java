package ethazi.intefaz.frame;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.excepciones.PanelNoDisponible;
import ethazi.intefaz.paneles.PanelAbrirOfertaCandidato;
import ethazi.intefaz.paneles.PanelAbrirOfertaEmpresa;
import ethazi.intefaz.paneles.PanelBarraHerramientas;
import ethazi.intefaz.paneles.PanelConocimientosBuscados;
import ethazi.intefaz.paneles.PanelConsultarOfertas;
import ethazi.intefaz.paneles.PanelEditarOferta;
import ethazi.intefaz.paneles.PanelPublicarOferta;
import ethazi.intefaz.paneles.PanelRealizarSolicitud;
import ethazi.intefaz.paneles.PanelVerOfertasConSolicitudes;


public class VentanaPrincipal extends JFrame {
	private JPanel contentPane;
	private JPanel pa_contenedor = new JPanel();
	private JPanel currentPanel;

	private JPanel pa_buscarOfertas = null;
	// Crear analizar empresa
	// Crear consultar ofertas adecuadas
	// Crear consultar sus solicitudes
	private JPanel pa_conocimientosBuscados = null;
	private JPanel pa_realizarSolicitud = null;
	private JPanel pa_abrirOferta = null;
	// Crear ver perfil
	// Crear editar perfil
	// Crear consultar candidatos
	// Crear consultar sus ofertas
	private JPanel pa_publicarOferta = null;
	private JPanel pa_editarOferta = null;
	// Crear analizar candidato
	// Crear analizar solicitudes
	private JPanel pa_ofertasConSolici = null;

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
	public static final short C_EDITAR_OFERTA = 10;
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
					VentanaPrincipal frame = new VentanaPrincipal();
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
		setBounds(100, 100, 768, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JPanel pa_barraHerramientas = new PanelBarraHerramientas();
		contentPane.add(pa_barraHerramientas);

		// Crear contenedor
		pa_contenedor.setBounds(0, 55, 762, 488);
		contentPane.add(pa_contenedor);
		pa_contenedor.setLayout(new CardLayout(0, 0));

		crearPaneles();

	}

	/**
	 * Creates all the panels that could be used by the current user
	 * 
	 * @author belatz
	 */
	public void crearPaneles() {
		// Crear consultar ofertas
		pa_buscarOfertas = new PanelConsultarOfertas();
		pa_contenedor.add(pa_buscarOfertas);
		// Crear analizar empresa

		if (Aplicacion.getUsuario() instanceof Candidato) { // Si es candidato crea sus posibles ventanas
			// Crear consultar ofertas adecuadas

			// Crear consultar sus solicitudes

			// Crear consultar conocimientos mas buscados
			pa_conocimientosBuscados = new PanelConocimientosBuscados();
			// Crear realizar solicitud
			pa_realizarSolicitud = new PanelRealizarSolicitud();
			pa_contenedor.add(pa_realizarSolicitud);
			// Crear abrir oferta
			pa_abrirOferta = new PanelAbrirOfertaCandidato();
			pa_contenedor.add(pa_abrirOferta);
			// Crear ver perfil

			// Crear editar perfil

		} else { // Si es empresa crea sus posibles ventanas
			// Crear consultar candidatos

			// Crear consultar sus ofertas

			// Crear publicar oferta
			pa_publicarOferta = new PanelPublicarOferta();
			pa_contenedor.add(pa_publicarOferta);
			// Crear editar oferta
			pa_editarOferta = new PanelEditarOferta();
			pa_contenedor.add(pa_editarOferta);
			// Crear analizar candidato

			// Crear analizar solicitudes

			// Crear consultar ofertas con solicitudes
			pa_ofertasConSolici = new PanelVerOfertasConSolicitudes();
			pa_contenedor.add(pa_ofertasConSolici);
			// Crear abrir oferta
			pa_abrirOferta = new PanelAbrirOfertaEmpresa();
			pa_contenedor.add(pa_abrirOferta);
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
	public void cambiarPanel(short p_nuevoPanel) throws PanelNoDisponible {
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

			break;
		case C_CONOCIMIENTOS_BUSCADOS:
			nuevoPanel = pa_conocimientosBuscados;
			break;
		case C_CONSULTAR_CANDIDATOS:

			break;
		case C_EDITAR_OFERTA:
			nuevoPanel = pa_editarOferta;
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
}
