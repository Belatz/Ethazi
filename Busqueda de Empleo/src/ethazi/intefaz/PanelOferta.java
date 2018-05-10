package ethazi.intefaz;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelOferta extends JPanel {
	private JPanel panel;

	/**
	 * JOn: este objeto recibe solo un objeto, no un conjunto
	 * porejemplo: solo una oferta
	 * mostrara unos datos y unos botones segun que sea,
	 * es dedir, segun que reciba se crearan unas cosas u otras
	 */
	public PanelOferta() {

		setLayout(null);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(324, 5, 32, 23);
		add(btnNewButton_1);

		JButton button = new JButton("tiiituloo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(10, 5, 304, 23);
		add(button);

		JButton button_1 = new JButton("New button");
		button_1.setBounds(366, 5, 32, 23);
		add(button_1);

		JButton button_2 = new JButton("New button");
		button_2.setBounds(408, 5, 32, 23);
		add(button_2);

		JLabel lblNewLabel = new JLabel("New labelsdssssssssssssssssssssssdddddffffffffffffffffd");
		lblNewLabel.setBounds(10, 39, 430, 30);
		add(lblNewLabel);

		panel = new JPanel();
		panel.setBounds(10, 60, 608, 91);

	}
}
