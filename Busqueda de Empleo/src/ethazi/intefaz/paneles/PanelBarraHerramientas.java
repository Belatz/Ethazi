package ethazi.intefaz.paneles;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.Utilidades;
import ethazi.aplicacion.Oferta;
import ethazi.datos.UtilidadesBD;
import ethazi.excepciones.PanelNoDisponible;
import ethazi.intefaz.Elemento_Listable;
import ethazi.intefaz.frame.VentanaIdentificarse;
import ethazi.intefaz.frame.VentanaPrincipal;
import javax.swing.ImageIcon;

/**
 *
 * This bar appears in most of the panels so the user can use the tools which
 * are provided by the bar. Like switch off the program, find an offer or go to
 * the user's profile.
 * 
 * @author Nestor
 *
 */
public class PanelBarraHerramientas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField txField_buscar;

	/*
	 * public static ArrayList<Elemento_Listable> listaDeOfertas = new
	 * ArrayList<Elemento_Listable>();
	 * 
	 * public PanelBarraHerramientas(GenericoDePanelesConLista pa_buscarOfertas) {
	 */
	private static boolean menu = true;
	private static JButton btnMenu;

	/*
	 * PARA LOS DE EL JAVADOCK ESTE BOTON AL PULSARLO si es candidato busca ofertas,
	 * si es empresa busca candidatos
	 */
	public PanelBarraHerramientas() {
		setLayout(null);
		JButton btn_buscar = new JButton("");
		btn_buscar.setIcon(new ImageIcon(PanelBarraHerramientas.class.getResource("/ethazi/intefaz/iconos/search.ico.png")));
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        try {
					VentanaPrincipal.setListaDeElementos(Utilidades.cambiarOfertaAElemento(UtilidadesBD
							.filtrarOfertas(txField_buscar.getText(), null, null, null, null, 0, null, null)));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
      }
			}
		});
		btn_buscar.setBounds(0, 0, 50, 50);
		add(btn_buscar);
		setBounds(0, 0, 762, 50);

		JButton btn_perfil = new JButton("");
		btn_perfil.setIcon(new ImageIcon(PanelBarraHerramientas.class.getResource("/ethazi/intefaz/iconos/perfil.ico")));
		btn_perfil.setToolTipText("Ver Perfil");
		btn_perfil.setPreferredSize(new Dimension(33, 9));
		btn_perfil.setMinimumSize(new Dimension(33, 9));
		btn_perfil.setMaximumSize(new Dimension(33, 9));
		btn_perfil.setBounds(642, 0, 50, 50);

		btn_perfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_VER_PERFIL);
				} catch (PanelNoDisponible e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		add(btn_perfil);

		JButton btn_apagar = new JButton("");
		btn_apagar.setIcon(new ImageIcon(PanelBarraHerramientas.class.getResource("/ethazi/intefaz/iconos/apagar.png")));
		btn_apagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Borrar el usuario
				Aplicacion.setUsuario(null);
				// Abrir la ventana identificarse
				VentanaPrincipal.cerrar();
				VentanaIdentificarse.abrir();
			}
		});
		btn_apagar.setToolTipText("Cerrar Sesi\u00F3n");
		btn_apagar.setAlignmentY(0.0f);
		btn_apagar.setAlignmentX(1.0f);
		btn_apagar.setBounds(702, 0, 50, 50);
		add(btn_apagar);

		txField_buscar = new JTextField();
		txField_buscar.setHorizontalAlignment(SwingConstants.RIGHT);
		txField_buscar.setToolTipText("");
		txField_buscar.setText("Introduzca el nombre de la Oferta....\r\n");
		txField_buscar.setHorizontalAlignment(SwingConstants.CENTER);
		txField_buscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txField_buscar.setColumns(10);
		txField_buscar.setBounds(51, 0, 277, 50);
		add(txField_buscar);

		btnMenu = new JButton("Otras cosas");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal.visibilidadMenu();
				botonMenuInv();
			}
		});
		btnMenu.setBounds(369, 11, 229, 23);
		add(btnMenu);

		btnMenu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				botonMenuInv();
				VentanaPrincipal.visibilidadMenu();
			}
		});
	}

	public static void botonMenuInv() {
		if (menu) {
			menu = false;
			btnMenu.setVisible(false);
		} else {
			menu = true;
			btnMenu.setVisible(true);
		}
	}

	public static String getTxField_buscar() {
		return txField_buscar.getText();
	}

}
