package ethazi.intefaz.frame;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ethazi.intefaz.paneles.PanelIdentificarse;
import ethazi.intefaz.paneles.PanelRegistroCandidato;
import ethazi.intefaz.paneles.PanelRegistroEmpresa;
import ethazi.intefaz.paneles.SeleccionRegistro;

import java.awt.Cursor;
import java.awt.Dimension;

	/**
	 * This window is used by the user to identify as Candidato or Empresa.
	 */
public class VentanaIdentificarse extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JPanel contentPane;
	private static JPanel pa_identificarse;
	private static SeleccionRegistro select;
	private static JPanel pa_registrarEmpresa;
	private static JPanel pa_registrarCandidato;

	private static VentanaIdentificarse frame;

	/**
	 * Launch the application.
	 */
	public static void ejecutar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaIdentificarse();
					cambiarTam(new Dimension(300,300));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void cerrar() {
		frame.setVisible(false);
	}
	public static void abrir() {
		frame.setVisible(true);
	}

	/**
	 * Create the frame Identificarse.
	 */
	public VentanaIdentificarse() {
		setTitle("Identificarse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		setResizable(false);

		pa_identificarse= new PanelIdentificarse();
		pa_identificarse.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.add(pa_identificarse);
		
		select= new SeleccionRegistro();
		contentPane.add(select);

		pa_registrarEmpresa= new PanelRegistroEmpresa();
		contentPane.add(pa_registrarEmpresa);
		
		pa_registrarCandidato=new PanelRegistroCandidato();
		contentPane.add(pa_registrarCandidato);
	}

	public static void cambiarTam(Dimension d){
		frame.setMaximumSize(d);
		frame.setMinimumSize(d);
		frame.setSize(d);
	}

	public static JPanel getPa_identificarse() {
		return pa_identificarse;
	}

	public static SeleccionRegistro getSelect() {
		return select;
	}

	public static JPanel getPa_registrarEmpresa() {
		return pa_registrarEmpresa;
	}

	public static JPanel getPa_registrarCandidato() {
		return pa_registrarCandidato;
	}
	
}
