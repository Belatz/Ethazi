package ethazi.intefaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class VentanaPrincipal extends JFrame {
//jon:breve descripcion en su clase.
	private JScrollconMolde scroll;
	private JPanel contentPane;

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
		setBounds(100, 100, 744, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		/**/contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		scroll = new JScrollconMolde();

		getContentPane().add(scroll);

		JPanel pa_barraHerramientas = new JPanel();
		pa_barraHerramientas.setBounds(5, 5, 728, 51);
		contentPane.add(pa_barraHerramientas);
		pa_barraHerramientas.setLayout(null);

		JButton btn_buscar = new JButton("");
		btn_buscar.setBounds(0, 0, 50, 50);
		pa_barraHerramientas.add(btn_buscar);

		/*
		 * jon:Lo retiro por el momento porque el scroll no funciona correctamente
		 * dentro de el panel
		 */
		/*
		 * JPanel pa_contenedorPaneles = new JPanel(); pa_contenedorPaneles.setBounds(5,
		 * 57, 728, 426);
		 */

		contentPane.add(scroll);
	}
}
