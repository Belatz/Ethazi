package ethazi.intefaz.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Empresa;
import ethazi.aplicacion.Utilidades;
import ethazi.datos.UtilidadesBD;
import ethazi.intefaz.emergentes.EmergenteCambios;
import ethazi.intefaz.emergentes.TieneEmergente;
import ethazi.intefaz.frame.VentanaIdentificarse;
import ethazi.intefaz.frame.VentanaPrincipal;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * The panel RegistroEmpresa will show the data that the user will have to fill,
 * so he can register as a Empresa.
 * 
 * @author Xabi
 *
 */

public class PanelRegistroEmpresa extends JPanel implements TieneEmergente {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNick;
	private JTextField textFieldPass;
	private JTextField textFieldNombre;
	private JTextField textFieldCif;
	private JTextField textFieldDir;
	private JTextField textFieldEmail;
	private JTextField textFieldTel;
	private JTextField textFieldContact;
	private JPanel padre;
	private JTextArea textAreaDesc;
	private JLabel lbl_Invalido;

	public PanelRegistroEmpresa() {
		padre = this;
		setLayout(null);

		JLabel lblNombreDeUsuario = new JLabel("Nick:");
		lblNombreDeUsuario.setBounds(10, 70, 46, 14);
		add(lblNombreDeUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(210, 70, 74, 14);
		add(lblContrasea);

		JLabel lblCorreoElectronico = new JLabel("Correo electr\u00F3nico:");
		lblCorreoElectronico.setBounds(10, 145, 111, 14);
		add(lblCorreoElectronico);

		JLabel lblNewLabel = new JLabel("Registrar una empresa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(133, 11, 278, 24);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre de la empresa:");
		lblNewLabel_1.setBounds(10, 95, 136, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CIF:");
		lblNewLabel_2.setBounds(378, 95, 46, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_3.setBounds(10, 120, 63, 14);
		add(lblNewLabel_3);

		textFieldNick = new JTextField();
		textFieldNick.setBounds(44, 68, 165, 17);
		add(textFieldNick);
		textFieldNick.setColumns(10);

		textFieldPass = new JTextField();
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(294, 68, 265, 17);
		add(textFieldPass);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(156, 95, 199, 17);
		add(textFieldNombre);

		textFieldCif = new JTextField();
		textFieldCif.setColumns(10);
		textFieldCif.setBounds(404, 93, 136, 17);
		add(textFieldCif);

		textFieldDir = new JTextField();
		textFieldDir.setColumns(10);
		textFieldDir.setBounds(83, 120, 457, 17);
		add(textFieldDir);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(125, 143, 230, 17);
		add(textFieldEmail);

		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(404, 143, 136, 17);
		add(textFieldTel);

		JLabel lblNewLabel_6 = new JLabel("Persona contacto:");
		lblNewLabel_6.setBounds(10, 170, 111, 14);
		add(lblNewLabel_6);

		textFieldContact = new JTextField();
		textFieldContact.setBounds(118, 167, 191, 20);
		add(textFieldContact);
		textFieldContact.setColumns(10);

		textFieldNick.setText("");
		textFieldPass.setText("");
		textFieldNombre.setText("");
		textFieldCif.setText("");
		textFieldDir.setText("");
		textFieldEmail.setText("");
		textFieldTel.setText("");
		textFieldContact.setText("");

		JLabel lblDescripcion = new JLabel("Descripcion de la empresa:");
		lblDescripcion.setBounds(10, 193, 190, 14);
		add(lblDescripcion);

		JButton btnRegistarEmpresa = new JButton("Registrar empresa");
		btnRegistarEmpresa.setToolTipText("Registrar los Datos");
		btnRegistarEmpresa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmergenteCambios.createWindow("¿Desea registrar estos datos de la Empresa?", (TieneEmergente) padre);
			}
		});
		btnRegistarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistarEmpresa.setBounds(386, 350, 154, 23);
		add(btnRegistarEmpresa);

		JLabel lblTelefono = new JLabel("Tel:");
		lblTelefono.setBounds(365, 145, 46, 14);
		add(lblTelefono);

		JButton buttonRetroceder = new JButton("<--");
		buttonRetroceder.setToolTipText("Volver a la Ventana de Identificaci\u00F3n");
		buttonRetroceder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldCif.setText("");
				textFieldContact.setText("");
				textFieldDir.setText("");
				textFieldEmail.setText("");
				textFieldNick.setText("");
				textFieldNombre.setText("");
				textFieldPass.setText("");
				textFieldTel.setText("");
				textAreaDesc.setText("");
				VentanaIdentificarse.getPa_registrarEmpresa().setVisible(false);
				VentanaIdentificarse.getPa_identificarse().setVisible(true);
				VentanaIdentificarse.cambiarTam(new Dimension(300, 300));
			}
		});
		buttonRetroceder.setBounds(10, 350, 89, 23);
		add(buttonRetroceder);

		textAreaDesc = new JTextArea();
		textAreaDesc.setBounds(10, 218, 530, 120);
		add(textAreaDesc);

		lbl_Invalido = new JLabel("Campos inv\u00E1lidos/vac\u00EDos:");
		lbl_Invalido.setForeground(Color.RED);
		lbl_Invalido.setBounds(10, 40, 549, 14);
		lbl_Invalido.setVisible(false);
		add(lbl_Invalido);

	}

	@Override
	public void funcionalidad(boolean aceptado) {
		if (aceptado) {
			Empresa aux = null;
			lbl_Invalido.setVisible(false);
			lbl_Invalido.setText("Campos inválidos/vacíos:");
			try {
				boolean valido = true;
				if (textFieldNick.getText().compareTo("") == 0 || textFieldNick.getText().charAt(0) == ' '
						|| Utilidades.esUsuario(textFieldNick.getText())) {
					valido = false;
					textFieldNick.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Nick ");
				}
				if (textFieldNombre.getText().compareTo("") == 0 || textFieldNombre.getText().charAt(0) == ' '
						|| UtilidadesBD.toEmpresa(textFieldNombre.getText()) != null) {
					valido = false;
					textFieldNombre.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Nombre ");
				}
				if (textFieldCif.getText().compareTo("") == 0 || textFieldCif.getText().charAt(0) == ' '
						|| !Utilidades.cifCorrecto(textFieldCif.getText())) {
					valido = false;
					textFieldCif.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " CIF ");
				} else {
					if (Utilidades.empresaExisteCif(textFieldCif.getText())) {
						valido = false;
						textFieldCif.setText("");
						lbl_Invalido.setText(lbl_Invalido.getText() + " CIF ");
					}
				}
				if (textFieldEmail.getText().compareTo("") == 0 || textFieldEmail.getText().charAt(0) == ' '
						|| !Utilidades.correoValido(textFieldEmail.getText())|| Utilidades.existeCorreo(textFieldEmail.getText())){
					valido = false;
					textFieldEmail.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Email ");
				}
				if (textFieldTel.getText().compareTo("") == 0 || textFieldTel.getText().charAt(0) == ' '
						|| !Utilidades.telefonoValido(textFieldTel.getText())) {
					valido = false;
					textFieldTel.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Tel ");
				}
				if (textFieldDir.getText().compareTo("") == 0) {
					valido = false;
					textFieldDir.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Dir");
				}
				if (textFieldPass.getText().compareTo("") == 0) {
					valido = false;
					textFieldPass.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Contraseña");
				}
				if (textFieldContact.getText().compareTo("") == 0) {
					valido = false;
					textFieldContact.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Contacto");
				}
				lbl_Invalido.setVisible(!valido);
				if (valido) {
					aux = new Empresa(textFieldNick.getText(), textFieldPass.getText(), textFieldNombre.getText(),
							textFieldCif.getText(), textFieldDir.getText(), textFieldEmail.getText(),
							textFieldTel.getText(), textFieldContact.getText(), textAreaDesc.getText());
					UtilidadesBD.insertarEmpresa(aux);
					VentanaIdentificarse.cerrar();
					VentanaPrincipal.ejecutar();
					Aplicacion.setUsuario(aux);
					textFieldCif.setText("");
					textFieldContact.setText("");
					textFieldDir.setText("");
					textFieldEmail.setText("");
					textFieldNick.setText("");
					textFieldNombre.setText("");
					textFieldPass.setText("");
					textFieldTel.setText("");
					textAreaDesc.setText("");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO mandar correo

		}

	}
}