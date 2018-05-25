package ethazi.intefaz.frame;

import java.awt.CardLayout;

import ethazi.aplicacion.*;

import java.awt.Component;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.UpdatableResultSet;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import ethazi.aplicacion.excepciones.PanelNoDisponible;

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

import java.util.ArrayList;

import java.awt.Font;

import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.CardLayout;

public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */

	private static byte visMenu = 0;
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JPanel pa_contenedor = new JPanel();
	private static JPanel currentPanel;

	public static GenericoDePanelesConLista pa_buscarOfertas;

	
	// Crear analizar empresa
	// Crear consultar ofertas adecuadas
	// Crear consultar sus solicitudes
	private static JPanel pa_conocimientosBuscados = null;
	private static JPanel pa_realizarSolicitud = null;
	private static JPanel pa_abrirOferta = null;
	// Crear ver perfil
	// Crear editar perfil
	// Crear consultar candidatos
	// Crear consultar sus ofertas

	private static JPanel pa_publicarOferta = null;
	private static JPanel pa_editarOferta = null;
	// Crear analizar candidato
	// Crear analizar solicitudes

	private static JPanel pa_ofertasConSolici = null;
	private static PanelMenu menu;
	public static ArrayList<Elemento_Listable> listaDeOfertas = new ArrayList<Elemento_Listable>();
	static boolean genericousado = true;

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

	// variable de prueba
	// ArrayList<Elemento_Listable> ofertas = new ArrayList<Elemento_Listable>();

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
		menu = new PanelMenu();
		menu.setBounds(350, 0, 251, 115);
		contentPane.add(menu);
		menu.setLayout(null);

		// Crear contenedor
		pa_contenedor.setBounds(0, 55, 762, 488);

		pa_contenedor.setLayout(new CardLayout(0, 0));
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
		JPanel pa_barraHerramientas = new PanelBarraHerramientas();
		pa_barraHerramientas.setLocation(0, 0);
		contentPane.add(pa_barraHerramientas);

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
		crearPaneles();

	}

	/**
	 * Creates all the panels that could be used by the current user
	 * 
	 * @author belatz
	 * @throws SQLException 
	 */
	public void crearPaneles() throws SQLException {
		listaDeOfertas = UtilidadesBD.buscarOfertas("Pro");
		pa_buscarOfertas = new GenericoDePanelesConLista(listaDeOfertas, (byte) 1);
		menu.setVisible(false);
		currentPanel = new JPanel();
	
	

		pa_buscarOfertas.setVisible(true);
	//	pa_contenedor.add(currentPanel);
		pa_contenedor.add(pa_buscarOfertas);
		contentPane.add(pa_contenedor);

		// Crear consultar ofertas

		
		// Crear analizar empresa

		// if (Aplicacion.getUsuario() instanceof Candidato) { // Si es candidato crea
		// sus posibles ventanas // Crear consultar ofertas adecuadas

		// Crear consultar sus solicitudes

		// Crear consultar conocimientos mas buscados pa_conocimientosBuscados = new
		// PanelConocimientosBuscados(); // Crear realizar solicitud
		// pa_realizarSolicitud = new PanelRealizarSolicitud();
		// pa_contenedor.add(pa_realizarSolicitud); // Crear abrir oferta

		// Crear ver perfil

		// Crear editar perfil

		// } else { // Si es empresa crea sus posibles ventanas // Crear consultar //
		// candidatos
		//
		// Crear consultar sus ofertas

		// Crear publicar oferta pa_publicarOferta = new PanelPublicarOferta();
		// pa_contenedor.add(pa_publicarOferta); // Crear editar oferta pa_editarOferta
		// = new PanelEditarOferta(); pa_contenedor.add(pa_editarOferta); // Crear //
		// analizar candidato

		// Crear analizar solicitudes

		// Crear consultar ofertas con solicitudes // Crear abrir oferta

		// pa_contenedor.add(pa_abrirOferta); // Crear ver perfil

		// Crear editar perfil

		// }

		// if (Aplicacion.getUsuario() instanceof Empresa) {
		// Si es candidato crea sus posibles ventanas // Crear consultar ofertas
		// adecuadas

		// Crear consultar sus solicitudes

		// Crear consultar conocimientos mas buscados pa_conocimientosBuscados = new
		// PanelConocimientosBuscados();
		// Crear realizar solicitud
		// pa_realizarSolicitud = new PanelRealizarSolicitud();
		// pa_contenedor.add(pa_realizarSolicitud); // Crear abrir oferta pa_abrirOferta
		// = new JPanel(); pa_contenedor.add(pa_abrirOferta); // Crear ver perfil
		//
		// Crear editar perfil

		// } else { // Si es empresa crea sus posibles ventanas // Crear consultar
		// candidatos

		// Crear consultar sus ofertas

		// Crear publicar oferta // pa_publicarOferta = new PanelPublicarOferta(); //
		// pa_contenedor.add(pa_publicarOferta); // Crear editar oferta //
		// pa_editarOferta = new PanelEditarOferta(); //
		// pa_contenedor.add(pa_editarOferta); // Crear analizar candidato

		// Crear analizar solicitudes

		// Crear consultar ofertas con solicitudes //
		// pa_contenedor.add(pa_ofertasConSolici); // Crear abrir oferta

		// pa_contenedor.add(pa_abrirOferta); // Crear ver perfil

		// Crear editar perfil

		// }

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
			actualizarOfertas();

			// __________________________________
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

	//	if (nuevoPanel == null) {
	//		// throw new PanelNoDisponible("El panel elegido no se ha generado");
	//	}

		//nuevoPanel.setVisible(true);
		currentPanel = nuevoPanel;
		//currentPanel.setVisible(true);
		pa_buscarOfertas.setVisible(true);
	}

	public static void actualizarOfertas() {

		try {
			pa_buscarOfertas.removeAll();
			cargarOfertas();
			pa_buscarOfertas.updateUI();
			pa_buscarOfertas.repaint();

		} catch (Exception e) {

		}

	}

	public static void visibilidadMenu() {
		visMenu = 0;
		menu.setVisible(true);
		menu.requestFocus();
	}

	public static void cargarOfertas() throws SQLException {


		listaDeOfertas = UtilidadesBD.buscarOfertas(PanelBarraHerramientas.txField_buscar.getText());
		
			pa_buscarOfertas.actualizar(listaDeOfertas, (byte)1);
		
	
		// PanelBarraHerramientas.txField_buscar.getText()
	}

}
