package ethazi.intefaz.emergentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import java.awt.Color;

public class ValidarCodigo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txField_codigo;

	/**
	 * Launch the application.
	 */
	public static void crearVentana(Object p_padre) {
		try {
			ValidarCodigo dialog = new ValidarCodigo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ValidarCodigo() {
		setTitle("Introduzca el codigo");
		setBounds(100, 100, 439, 207);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_codigo = new JLabel("C\u00F3digo:");
			lbl_codigo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_codigo.setBounds(43, 62, 46, 14);
			contentPanel.add(lbl_codigo);
		}
		{
			txField_codigo = new JTextField();
			txField_codigo.setText("Introduce el c\u00F3digo");
			txField_codigo.setFont(new Font("Tahoma", Font.BOLD, 11));
			txField_codigo.setColumns(10);
			txField_codigo.setBackground(new Color(255, 239, 213));
			txField_codigo.setBounds(95, 59, 142, 20);
			contentPanel.add(txField_codigo);
			txField_codigo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txField_codigo.setText("");
				}
			});
		}
		{
			JLabel lbl_codigoErroneo = new JLabel("(C\u00F3digo incorrecto)");
			lbl_codigoErroneo.setForeground(new Color(139, 0, 0));
			lbl_codigoErroneo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_codigoErroneo.setBounds(256, 62, 133, 14);
			contentPanel.add(lbl_codigoErroneo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Validar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
