package ethazi.intefaz.paneles;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelBarraHerramientas extends JPanel {
	private JTextField txField_buscar;

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
