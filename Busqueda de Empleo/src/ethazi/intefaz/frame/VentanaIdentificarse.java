package ethazi.intefaz.frame;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ethazi.intefaz.paneles.PanelIdentificarse;
import ethazi.intefaz.paneles.PanelRegistroEmpresa;

public class VentanaIdentificarse extends JFrame {

	private JPanel contentPane;

	public static VentanaIdentificarse frame;

	/**
	 * Launch the application.
	 */
	public static void ejecutar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaIdentificarse();
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

		JPanel pa_identificarse = new PanelIdentificarse();
		contentPane.add(pa_identificarse);

		JPanel pa_registrarEmpresa = new PanelRegistroEmpresa();
		contentPane.add(pa_registrarEmpresa);
	}
}
