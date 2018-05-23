package ethazi.intefaz.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * 
 * @author Nestor
 *
 */

public class PanelRealizarSolicitud extends JPanel {
	private JTextField textField;

	/**
	 * Adds a request to the data base.
	 */
	public PanelRealizarSolicitud() {
		setLayout(null);

		JLabel lblPresentacionCandidato = new JLabel("Presentacion candidato");
		lblPresentacionCandidato.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPresentacionCandidato.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresentacionCandidato.setBounds(21, 23, 720, 47);
		add(lblPresentacionCandidato);

		textField = new JTextField();
		textField.setBounds(31, 71, 704, 342);
		add(textField);
		textField.setColumns(10);

		JButton button = new JButton("<----");
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(38, 443, 73, 23);
		add(button);

		JButton btnRealizarSolicitud = new JButton("Realizar solicitud");
		btnRealizarSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRealizarSolicitud.setBounds(570, 443, 163, 23);
		add(btnRealizarSolicitud);
	}
}
