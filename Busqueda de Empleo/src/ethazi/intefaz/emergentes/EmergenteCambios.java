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

public class EmergenteCambios extends JDialog{
	private JButton btnAceptar;
	private JButton btnCancelar;
	private static final long serialVersionUID = 1L;

	public EmergenteCambios(String texto) {
		//
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel contentPanel=new JPanel();
		setBounds(100, 100, 450, 300);
		contentPanel.setVisible(true);
		contentPanel.setLayout(null);
		
		btnAceptar=new JButton("Aceptar");
		btnAceptar.setBounds(10, 217, 128, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar=new JButton("Cancelar");
		btnCancelar.setBounds(296, 217, 128, 23);
		contentPanel.add(btnCancelar);
		getContentPane().add(contentPanel);
		
		JLabel labelTexto = new JLabel("");
		labelTexto.setHorizontalAlignment(SwingConstants.CENTER);
		labelTexto.setText(texto);
		labelTexto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelTexto.setBounds(69, 44, 292, 77);
		contentPanel.add(labelTexto);
	}
	
	public static void createWindow(String texto, TieneEmergente p_padre)
	{	
		VentanaPrincipal.desHabVentana(false);
		EmergenteCambios ventanaEmergente=new EmergenteCambios(texto);
		ventanaEmergente.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventanaEmergente.setVisible(true);
		ventanaEmergente.getBtnAceptar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaEmergente.setVisible(false);
				ventanaEmergente.removeAll();
				p_padre.funcionalidad(true);
				VentanaPrincipal.desHabVentana(true);
			}
		});
		ventanaEmergente.getBtnCancelar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaEmergente.setVisible(false);
				ventanaEmergente.removeAll();
				p_padre.funcionalidad(false);
				VentanaPrincipal.desHabVentana(true);
			}
		});
		ventanaEmergente.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				VentanaPrincipal.desHabVentana(true);
			}
		});
	}
	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
