package ethazi.intefaz.paneles;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

<<<<<<< HEAD
import com.mysql.jdbc.Statement;

import ethazi.aplicacion.Conexion;
import ethazi.aplicacion.UtilidadesBD;
import ethazi.aplicacion.excepciones.PanelNoDisponible;
import ethazi.intefaz.Elemento_A_Listar;
import ethazi.intefaz.Elemento_Listable;
import ethazi.intefaz.frame.VentanaPrincipal;
/**
 *
 * This bar appears in most of the panels so the user can use
 * the tools which are provided by the bar. Like switch off the program, find an offer or 
 * go to the user's profile.
 * 
 * @author Nestor
 *
 */
public class PanelBarraHerramientas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txField_buscar;

/*	public static ArrayList<Elemento_Listable> listaDeOfertas = new ArrayList<Elemento_Listable>();
	
	public PanelBarraHerramientas(GenericoDePanelesConLista pa_buscarOfertas) {*/

	public PanelBarraHerramientas() {
		setLayout(null);
		JButton btn_buscar = new JButton("");
		btn_buscar.setBounds(0, 0, 50, 50);
		add(btn_buscar);
		setBounds(0, 0, 762, 50);

		JButton btn_perfil = new JButton("");
		btn_perfil.setToolTipText("Ver Perfil");
		btn_perfil.setPreferredSize(new Dimension(33, 9));
		btn_perfil.setMinimumSize(new Dimension(33, 9));
		btn_perfil.setMaximumSize(new Dimension(33, 9));
		btn_perfil.setBounds(642, 0, 50, 50);
		btn_perfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				pa_buscarOfertas.removeAll();
				}
				catch (Exception e) {
					
				}
				try {
					listaDeOfertas = UtilidadesBD.buscarOfertas(txField_buscar.getText());
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				VentanaPrincipal.actualizar(listaDeOfertas);
			
				try {
					VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_BUSCAR_OFERTA);
				} catch (PanelNoDisponible e) {
					
					e.printStackTrace();
				}

			}
		});
		add(btn_perfil);

		JButton btn_apagar = new JButton("");
		btn_apagar.setToolTipText("Cerrar Sesi\u00F3n");
		btn_apagar.setAlignmentY(0.0f);
		btn_apagar.setAlignmentX(1.0f);
		btn_apagar.setBounds(702, 0, 50, 50);
		add(btn_apagar);

		txField_buscar = new JTextField();
		txField_buscar.setToolTipText("");
		txField_buscar.setText("Introduzca el nombre de la Oferta....\r\n");
		txField_buscar.setHorizontalAlignment(SwingConstants.CENTER);
		txField_buscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txField_buscar.setColumns(10);
		txField_buscar.setBounds(51, 0, 195, 50);
		add(txField_buscar);

		JComboBox combo_menu = new JComboBox();
		combo_menu.setToolTipText("Men\u00FA");
		combo_menu.setName("");
		combo_menu.setBounds(252, 0, 380, 50);
		add(combo_menu);
	}

}
