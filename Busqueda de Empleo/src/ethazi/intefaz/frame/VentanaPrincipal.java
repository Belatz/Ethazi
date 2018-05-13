package ethazi.intefaz.frame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ethazi.intefaz.PaneldePOfertas;
import ethazi.intefaz.paneles.PanelFiltrosOferta;
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
	private PaneldePOfertas pOfertas;
	private JTextField txField_buscar;

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
		lanzarScrollPane();

		/*
		 * jon:Lo retiro por el momento porque el scroll no funciona correctamente
		 * dentro de el panel
		 */
		/*
		 * JPanel pa_contenedorPaneles = new JPanel(); pa_contenedorPaneles.setBounds(5,
		 * 57, 728, 426);
		 */

	}

	/*
	 * Jon: Este metodo tiene un JScrollPane y un PaneldeOfertas Configura el
	 * JScrollPane Añade al JScrollPane el PaneldeOfertas Y lanza el JScrollPane
	 */
	public void lanzarScrollPane() {
		contentPane.setLayout(null);

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

		JScrollPane scroll = new JScrollPane();
		PaneldePOfertas pOfertas_1 = new PaneldePOfertas();

		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(10, 60, 500, 440);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.setViewportView(pOfertas_1);

		getContentPane().add(scroll);
		contentPane.add(scroll);

		JPanel pa_contenedor = new JPanel();
		pa_contenedor.setBounds(0, 49, 762, 488);
		contentPane.add(pa_contenedor);
		pa_contenedor.setLayout(new CardLayout(0, 0));

		JPanel pa_buscarOfertas = new JPanel();
		pa_contenedor.add(pa_buscarOfertas, "name_745028646498");
		pa_buscarOfertas.setLayout(null);

		JScrollPane pa_filtros = new PanelFiltrosOferta();
		pa_filtros.setBounds(512, 0, 247, 488);
		pa_buscarOfertas.add(pa_filtros);
	}
}
