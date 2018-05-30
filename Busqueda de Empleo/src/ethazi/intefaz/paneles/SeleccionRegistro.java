package ethazi.intefaz.paneles;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import ethazi.intefaz.frame.VentanaIdentificarse;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * The panel shows two options to register: Empresa or Candidato
 * @author mañana
 *
 */
public class SeleccionRegistro extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 public SeleccionRegistro() {
		setLayout(new BorderLayout(0, 0));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		add(splitPane);
		
		JButton btnRegistroCandidato = new JButton("Candidato");
		btnRegistroCandidato.setPreferredSize(new Dimension(100, 100));
		btnRegistroCandidato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaIdentificarse.getSelect().setVisible(false);
				VentanaIdentificarse.getPa_registrarCandidato().setVisible(true);
				VentanaIdentificarse.cambiarTam(new Dimension(790, 530));
			}
		});
		splitPane.setLeftComponent(btnRegistroCandidato);
		
		JButton btnRegistroEmpresa = new JButton("Empresa");
		btnRegistroEmpresa.setPreferredSize(new Dimension(100, 100));
		btnRegistroEmpresa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaIdentificarse.getSelect().setVisible(false);
				VentanaIdentificarse.getPa_registrarEmpresa().setVisible(true);
				VentanaIdentificarse.cambiarTam(new Dimension(590, 430));
			}
		});
		splitPane.setRightComponent(btnRegistroEmpresa);
	}

}
