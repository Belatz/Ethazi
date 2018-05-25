package ethazi.intefaz.emergentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

/**
 * @author Eduardo
 */

public class RecuperarContrasena extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This is recover password window, it send a code to a email account that we
	 * write.
	 */

	private final JPanel contentPanel = new JPanel();
	private JTextField txField_correo;

	/**
	 * Launch the application.
	 */
	public static void crearVentana(Object p_padre) {
		try {
			RecuperarContrasena dialog = new RecuperarContrasena();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RecuperarContrasena() {
		setTitle("Introduzca su correo");
		setBounds(100, 100, 432, 186);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_correoErroneo = new JLabel("(Correo incorrecto)");
			lbl_correoErroneo.setBounds(290, 60, 109, 14);
			contentPanel.add(lbl_correoErroneo);
			lbl_correoErroneo.setForeground(new Color(139, 0, 0));
			lbl_correoErroneo.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		{
			JLabel lbl_email = new JLabel("Email:");
			lbl_email.setBounds(46, 60, 33, 14);
			contentPanel.add(lbl_email);
			lbl_email.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		{
			txField_correo = new JTextField();
			txField_correo.setBounds(89, 56, 195, 22);
			contentPanel.add(txField_correo);
			txField_correo.setText("nombre@gmail.com");
			txField_correo.setFont(new Font("Tahoma", Font.BOLD, 11));
			txField_correo.setColumns(10);
			txField_correo.setBackground(new Color(255, 239, 213));
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_enviar = new JButton("Enviar");
				btn_enviar.setActionCommand("OK");
				buttonPane.add(btn_enviar);
				getRootPane().setDefaultButton(btn_enviar);
			}
			{
				JButton btn_cancelar = new JButton("Cancelar");
				btn_cancelar.setActionCommand("Cancel");
				buttonPane.add(btn_cancelar);
			}
		}
	}

}
