package ethazi.intefaz.frame;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Candidato;
import ethazi.intefaz.paneles.PanelAbrirOfertaCandidato;
import ethazi.intefaz.paneles.PanelAbrirOfertaEmpresa;
import ethazi.intefaz.paneles.PanelBarraHerramientas;
import ethazi.intefaz.paneles.PanelConsultarOfertas;
import ethazi.intefaz.paneles.PanelEditarOferta;
import ethazi.intefaz.paneles.PanelPublicarOferta;
import ethazi.intefaz.paneles.PanelRealizarSolicitud;
import ethazi.intefaz.paneles.PanelVerOfertasConSolicitudes;

public class VentanaPrincipal extends JFrame {
	private JPanel contentPane;
	private JPanel pa_contenedor = new JPanel();

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

		JPanel pa_barraHerramientas = new PanelBarraHerramientas();
		contentPane.add(pa_barraHerramientas);

		// Crear contenedor
		pa_contenedor.setBounds(0, 55, 762, 488);
		contentPane.add(pa_contenedor);
		pa_contenedor.setLayout(new CardLayout(0, 0));

		crearPaneles();

	}

	public void crearPaneles() {
		// Crear consultar ofertas
		JPanel pa_buscarOfertas = new PanelConsultarOfertas();
		pa_contenedor.add(pa_buscarOfertas);
		// Crear analizar empresa

		if (Aplicacion.getUsuario() instanceof Candidato) { // Si es candidato crea sus posibles ventanas
			// Crear consultar ofertas adecuadas

			// Crear consultar sus solicitudes

			// Crear consultar conocimientos mas buscados

			// Crear realizar solicitud
			JPanel pa_realizarSolicitud = new PanelRealizarSolicitud();
			pa_contenedor.add(pa_realizarSolicitud);
			// Crear abrir oferta
			JPanel pa_abrirOferta = new PanelAbrirOfertaCandidato();
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
			JPanel pa_ofertasConSolici = new PanelVerOfertasConSolicitudes();
			pa_contenedor.add(pa_ofertasConSolici);
			// Crear abrir oferta
			JPanel pa_abrirOferta;
			pa_abrirOferta = new PanelAbrirOfertaEmpresa();
			pa_contenedor.add(pa_abrirOferta);
			// Crear ver perfil

			// Crear editar perfil

		}

	}
}
