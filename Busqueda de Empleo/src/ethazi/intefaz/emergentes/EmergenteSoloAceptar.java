package ethazi.intefaz.emergentes;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

import ethazi.intefaz.frame.VentanaPrincipal;

public class EmergenteSoloAceptar extends JDialog{
	private JButton btnAceptar;
	private static final long serialVersionUID = 1L;

	public EmergenteSoloAceptar(String texto) {
		//
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel contentPanel=new JPanel();
		setBounds(100, 100, 450, 300);
		contentPanel.setVisible(true);
		contentPanel.setLayout(null);
		
		btnAceptar=new JButton("Aceptar");
		btnAceptar.setBounds(162, 216, 128, 23);
		contentPanel.add(btnAceptar);
		
		getContentPane().add(contentPanel);
		
		JLabel labelTexto = new JLabel(texto);
		labelTexto.setHorizontalAlignment(SwingConstants.CENTER);
		labelTexto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelTexto.setBounds(10, 44, 414, 77);
		contentPanel.add(labelTexto);
	}
	
	public static void createWindow(String texto, TieneEmergente p_padre)
	{	
		VentanaPrincipal.desHabVentana(false, ((JPanel)p_padre).getParent());
		EmergenteSoloAceptar ventanaEmergente=new EmergenteSoloAceptar(texto);
		ventanaEmergente.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventanaEmergente.setVisible(true);
		ventanaEmergente.getBtnAceptar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaEmergente.setVisible(false);
				ventanaEmergente.removeAll();
				p_padre.funcionalidad(true);
				VentanaPrincipal.desHabVentana(true, ((JPanel)p_padre).getParent());
			}
		});
		ventanaEmergente.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				VentanaPrincipal.desHabVentana(true, ((JPanel)p_padre).getParent());
			}
		});
	}
	public JButton getBtnAceptar() {
		return btnAceptar;
	}

}