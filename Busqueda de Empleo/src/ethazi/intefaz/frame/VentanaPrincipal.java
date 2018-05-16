package ethazi.intefaz.frame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.Oferta;

import ethazi.intefaz.paneles.PanelAbrirOfertaCandidato;
import ethazi.intefaz.paneles.PanelAbrirOfertaEmpresa;
import ethazi.intefaz.paneles.PanelAtrasAlante;
import ethazi.intefaz.paneles.PanelConsultarOfertas;
import ethazi.intefaz.paneles.PanelEditarOferta;
import ethazi.intefaz.paneles.PanelFiltrosOferta;
import ethazi.intefaz.paneles.PanelPublicarOferta;
import ethazi.intefaz.paneles.PanelFiltrosOferta;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.CardLayout;
import javax.swing.JSplitPane;

public class VentanaPrincipal extends JFrame {
	private JPanel contentPane;
	private JTextField txField_buscar;
	private JPanel pa_contenedor = new JPanel();
	//variable de prueba
	ArrayList<Oferta> ofertas = new ArrayList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	 * Create the frame
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

		lanzarBarraHerramientas();

		// Crear contenedor
		pa_contenedor.setBounds(0, 55, 762, 488);
		contentPane.add(pa_contenedor);
		pa_contenedor.setLayout(new CardLayout(0, 0));
		/*Prueba jonor*/
		int cont = 0;
		Oferta oferta;
		
		while(cont < 200) {
			oferta = new Oferta ("Nombre"+cont, "Empresaaa"+cont,"descripppcciooooon"+cont,1000+cont);
			ofertas.add(oferta);
			cont++;
		}
		/*Prueba jonor*/
		crearPaneles();

	}

	public void crearPaneles() {
		// Crear consultar ofertas
	JPanel pa_buscarOfertas = new PanelConsultarOfertas(ofertas);
		pa_contenedor.add(pa_buscarOfertas);
		// Crear analizar empresa

		if (Aplicacion.getUsuario() instanceof Candidato) { // Si es candidato crea sus posibles ventanas
			// Crear consultar ofertas adecuadas

			// Crear consultar sus solicitudes

			// Crear consultar conocimientos mas buscados

			// Crear realizar solicitud

			// Crear abrir oferta
			JPanel pa_abrirOferta;
			pa_abrirOferta = new PanelAbrirOfertaCandidato();
			pa_contenedor.add(pa_abrirOferta);
			// Crear ver perfil

			// Crear editar perfil

		} else { // Si es empresa crea sus posibles ventanas
			// Crear consultar candidatos

			// Crear consultar sus ofertas

			// Crear publicar oferta
			JPanel pa_publicarOferta = new PanelPublicarOferta();
			pa_contenedor.add(pa_publicarOferta);
			// Crear editar oferta
			JPanel pa_editarOferta = new PanelEditarOferta();
			pa_contenedor.add(pa_editarOferta);
			// Crear analizar candidato

			// Crear analizar solicitudes

			// Crear consultar ofertas con solicitudes

			// Crear abrir oferta
			JPanel pa_abrirOferta;
			pa_abrirOferta = new PanelAbrirOfertaEmpresa();
			pa_contenedor.add(pa_abrirOferta);
			// Crear ver perfil

			// Crear editar perfil

		}

	}

	public void lanzarBarraHerramientas() {
		JPanel pa_barraHerramientas = new JPanel();
		pa_barraHerramientas.setLayout(null);
		JButton btn_buscar = new JButton("");
		btn_buscar.setBounds(0, 0, 50, 50);
		pa_barraHerramientas.add(btn_buscar);
		pa_barraHerramientas.setBounds(0, 0, 762, 50);
		contentPane.add(pa_barraHerramientas);

		JButton btn_perfil = new JButton("");
		btn_perfil.setToolTipText("Ver Perfil");
		btn_perfil.setPreferredSize(new Dimension(33, 9));
		btn_perfil.setMinimumSize(new Dimension(33, 9));
		btn_perfil.setMaximumSize(new Dimension(33, 9));
		btn_perfil.setBounds(642, 0, 50, 50);
		pa_barraHerramientas.add(btn_perfil);

		JButton btn_apagar = new JButton("");
		btn_apagar.setToolTipText("Cerrar Sesi\u00F3n");
		btn_apagar.setAlignmentY(0.0f);
		btn_apagar.setAlignmentX(1.0f);
		btn_apagar.setBounds(702, 0, 50, 50);
		pa_barraHerramientas.add(btn_apagar);

		txField_buscar = new JTextField();
		txField_buscar.setToolTipText("");
		txField_buscar.setText("Introduzca el nombre de la Oferta....\r\n");
		txField_buscar.setHorizontalAlignment(SwingConstants.CENTER);
		txField_buscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txField_buscar.setColumns(10);
		txField_buscar.setBounds(51, 0, 195, 50);
		pa_barraHerramientas.add(txField_buscar);

		JComboBox combo_menu = new JComboBox();
		combo_menu.setToolTipText("Men\u00FA");
		combo_menu.setName("");
		combo_menu.setBounds(252, 0, 380, 50);
		pa_barraHerramientas.add(combo_menu);
	}
}
