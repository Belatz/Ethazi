package ethazi.intefaz.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;

import javax.swing.JTextField;

import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.Usuario;
import ethazi.aplicacion.Utilidades;
import ethazi.datos.UtilidadesBD;
import ethazi.intefaz.emergentes.EmergenteCambios;
import ethazi.intefaz.emergentes.TieneEmergente;
import ethazi.intefaz.frame.VentanaIdentificarse;
import ethazi.intefaz.frame.VentanaPrincipal;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Color;
import javax.swing.JPasswordField;

/**
 * The panel RegistroCandidato will show the facts that the user will have to
 * fill, so he can register as a Candidato.
 * 
 * @author Urtzi
 *
 */
public class PanelRegistroCandidato extends JPanel implements TieneEmergente{
	private static final long serialVersionUID = 1L;
	private JTextField nickTextField;
	private JTextField dirtextField;
	private JTextField nombretextField;
	private JTextField apellidostextField;
	private JTextField numIdtextField;
	private JTextField teltextField;
	private JTextField emailtextField;
	private JTextField experienciaProfesionaltextField;
	private JTextArea estudiostextArea;
	private JTextArea otrosConocimientostextArea;
	private JTextArea vidaLaboraltextArea;
	private JCheckBox chckbxCarnet;
	private JCheckBox chckbxCoche;
	private JCheckBox chckbxDisponibilidadParaViajar;
	private JComboBox<Integer> diacomboBox;
	private JComboBox<Integer> mescomboBox;
	private JComboBox<Integer> aniocomboBox;
	private PanelListaDoble conocimientosEditar;
	private JButton btnRegistrar;
	private JLabel lbl_Invalido;
	private JPanel padre;
	private JPasswordField passwordField;

	public PanelRegistroCandidato() {
    setName("Registro candidato");
    padre=this;
		setLayout(null);
		JLabel milblNick = new JLabel("Nick: ");
		milblNick.setBounds(10, 21, 46, 14);
		add(milblNick);

		nickTextField = new JTextField();
		nickTextField.setBounds(46, 18, 130, 20);
		add(nickTextField);
		nickTextField.setColumns(10);

		JLabel milblNombre = new JLabel("Nombre:");
		milblNombre.setBounds(513, 46, 78, 14);
		add(milblNombre);

		nombretextField = new JTextField();
		nombretextField.setBounds(570, 46, 159, 20);
		add(nombretextField);
		nombretextField.setColumns(10);

		JLabel milblNumId = new JLabel("DNI:");
		milblNumId.setBounds(10, 46, 26, 14);
		add(milblNumId);

		numIdtextField = new JTextField();
		numIdtextField.setBounds(46, 46, 85, 20);
		add(numIdtextField);
		numIdtextField.setColumns(10);

		JLabel milblDireccion = new JLabel("Dir: ");
		milblDireccion.setBounds(141, 43, 26, 20);
		add(milblDireccion);

		dirtextField = new JTextField();
		dirtextField.setBounds(186, 46, 314, 20);
		add(dirtextField);
		dirtextField.setColumns(10);

		JLabel milblEmail = new JLabel("Email: ");
		milblEmail.setBounds(136, 79, 58, 14);
		add(milblEmail);

		emailtextField = new JTextField();
		emailtextField.setBounds(186, 77, 280, 20);
		add(emailtextField);
		emailtextField.setColumns(10);

		JLabel milblTelefono = new JLabel("Tel: ");
		milblTelefono.setBounds(10, 79, 26, 14);
		add(milblTelefono);

		teltextField = new JTextField();
		teltextField.setBounds(46, 77, 85, 20);
		add(teltextField);
		teltextField.setColumns(10);

		JLabel milblApellidos = new JLabel("Apellidos: ");
		milblApellidos.setBounds(476, 77, 78, 14);
		add(milblApellidos);

		apellidostextField = new JTextField();
		apellidostextField.setBounds(536, 77, 225, 20);
		add(apellidostextField);
		apellidostextField.setColumns(10);

		JLabel milblFechaNac = new JLabel("Fecha Nacimiento: ");
		milblFechaNac.setBounds(10, 104, 121, 14);
		add(milblFechaNac);

		diacomboBox = new JComboBox<Integer>();
		diacomboBox.setBounds(123, 104, 46, 20);
		add(diacomboBox);

		mescomboBox = new JComboBox<Integer>();
		mescomboBox.setBounds(187, 104, 46, 20);
		add(mescomboBox);

		aniocomboBox = new JComboBox<Integer>();
		aniocomboBox.setBounds(246, 104, 85, 20);
		add(aniocomboBox);

		JLabel lblEstudios = new JLabel("Estudios:");
		lblEstudios.setBounds(10, 165, 58, 14);
		add(lblEstudios);

		estudiostextArea = new JTextArea();

		estudiostextArea.setBounds(83, 165, 653, 58);
		add(estudiostextArea);

		JLabel lblConocimientos = new JLabel("Conocimientos:");
		lblConocimientos.setBounds(10, 234, 102, 14);
		add(lblConocimientos);

		conocimientosEditar = new PanelListaDoble(Usuario.getConocimientosTotales(), null);
		conocimientosEditar.setBounds(60, 250, 214, 177);
		add(conocimientosEditar);

		JLabel lblOtrosConocimientos = new JLabel("Otros Conocimientos:");
		lblOtrosConocimientos.setBounds(325, 244, 125, 14);
		add(lblOtrosConocimientos);

		otrosConocimientostextArea = new JTextArea();
		otrosConocimientostextArea.setBounds(456, 244, 280, 51);
		add(otrosConocimientostextArea);

		JLabel lblVidaLaboral = new JLabel("Vida Laboral:");
		lblVidaLaboral.setBounds(325, 303, 108, 14);
		add(lblVidaLaboral);

		vidaLaboraltextArea = new JTextArea();
		vidaLaboraltextArea.setBounds(456, 301, 280, 51);
		add(vidaLaboraltextArea);

		JLabel lblExperienciaProfesional = new JLabel("Experiencia Profesional:");
		lblExperienciaProfesional.setBounds(483, 139, 154, 14);
		add(lblExperienciaProfesional);

		experienciaProfesionaltextField = new JTextField();
		experienciaProfesionaltextField.setColumns(10);
		experienciaProfesionaltextField.setBounds(647, 136, 39, 20);
		add(experienciaProfesionaltextField);

		chckbxCarnet = new JCheckBox("Carnet de Conducir");
		chckbxCarnet.setBounds(10, 135, 141, 23);
		add(chckbxCarnet);

		chckbxCoche = new JCheckBox("Coche Propio");
		chckbxCoche.setBounds(156, 135, 118, 23);
		add(chckbxCoche);

		chckbxDisponibilidadParaViajar = new JCheckBox("Disponibilidad para Viajar");
		chckbxDisponibilidadParaViajar.setBounds(274, 135, 174, 23);
		add(chckbxDisponibilidadParaViajar);
		
		JButton buttonRetroceder = new JButton("<--");
		
		buttonRetroceder.setToolTipText("Volver a la Ventana de Identificaci\u00F3n");
		buttonRetroceder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				apellidostextField.setText("");
				nickTextField.setText("");
				nombretextField.setText("");
				numIdtextField.setText("");
				dirtextField.setText("");
				teltextField.setText("");
				emailtextField.setText("");
				diacomboBox.setSelectedIndex(0);
				mescomboBox.setSelectedIndex(0);
				aniocomboBox.setSelectedIndex(0);
				chckbxCarnet.setSelected(false);
				chckbxCoche.setSelected(false);
				chckbxDisponibilidadParaViajar.setSelected(false);
				experienciaProfesionaltextField.setText("");
				estudiostextArea.setText("");
				otrosConocimientostextArea.setText("");
				vidaLaboraltextArea.setText("");
				conocimientosEditar.actualizarListas(Usuario.getConocimientosTotales(), null);
				VentanaIdentificarse.getPa_registrarCandidato().setVisible(false);
				VentanaIdentificarse.getPa_identificarse().setVisible(true);
				VentanaIdentificarse.cambiarTam(new Dimension(300, 300));
			}
		});
		buttonRetroceder.setBounds(10, 454, 89, 23);
		add(buttonRetroceder);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(663, 454, 89, 23);
		add(btnRegistrar);
		
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmergenteCambios.createWindow("�Desea registrar estos datos de la Empresa?", (TieneEmergente) padre);
			}
		});
		
		JLabel labelPass = new JLabel("Contrase\u00F1a:");
		labelPass.setBounds(186, 20, 74, 14);
		add(labelPass);
		
		lbl_Invalido = new JLabel("Campos inv\u00E1lidos/vac\u00EDos ");
		lbl_Invalido.setForeground(Color.RED);
		lbl_Invalido.setBounds(304, 413, 549, 14);
		lbl_Invalido.setVisible(false);
		add(lbl_Invalido);

		for (int i = Calendar.getInstance().get(Calendar.YEAR); i >= (Calendar.getInstance().get(Calendar.YEAR)
				- 90); i--)
			aniocomboBox.addItem(Integer.valueOf(i));
		for (int i = 1; i <= 12; i++)
			mescomboBox.addItem(Integer.valueOf(i));
		mescomboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarDia();
			}
		});
		aniocomboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarDia();
			}
		});
		actualizarDia();
		apellidostextField.setText("");
		nickTextField.setText("");
		nombretextField.setText("");
		numIdtextField.setText("");
		dirtextField.setText("");
		teltextField.setText("");
		emailtextField.setText("");
		diacomboBox.setSelectedIndex(0);
		mescomboBox.setSelectedIndex(0);
		aniocomboBox.setSelectedIndex(0);
		chckbxCarnet.setSelected(false);
		chckbxCoche.setSelected(false);
		chckbxDisponibilidadParaViajar.setSelected(false);
		experienciaProfesionaltextField.setText("");
		estudiostextArea.setText("");
		otrosConocimientostextArea.setText("");
		vidaLaboraltextArea.setText("");
		
		passwordField = new JPasswordField();
		passwordField.setBounds(268, 18, 267, 20);
		add(passwordField);
		conocimientosEditar.actualizarListas(Usuario.getConocimientosTotales(), null);
	
	}

	private void actualizarDia() {
		int total = 0;
		switch (((Integer) mescomboBox.getSelectedItem()).intValue()) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			total = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			total = 30;
			break;
		case 2:
			if (((Integer) aniocomboBox.getSelectedIndex()).intValue() % 4 == 0
					&& ((Integer) aniocomboBox.getSelectedIndex()).intValue() % 100 != 0
					|| ((Integer) aniocomboBox.getSelectedIndex()).intValue() % 400 == 0)
				total = 29;
			else
				total = 28;
		}
		diacomboBox.removeAllItems();

		for (int i = 1; i <= total; i++)
			diacomboBox.addItem(Integer.valueOf(i));
	}
	private String comboAFecha() {
		return aniocomboBox.getSelectedItem()+"-"+
				mescomboBox.getSelectedItem()+"-"+
				diacomboBox.getSelectedItem();
	}
	@Override
	public void funcionalidad(boolean aceptado) {
		if (aceptado) {
			Candidato aux = null;
			lbl_Invalido.setVisible(false);
			lbl_Invalido.setText("Campos inv�lidos/vac�os:");
			try {
				boolean valido = true;
				if (nickTextField.getText().compareTo("") == 0 || nickTextField.getText().charAt(0) == ' '
						|| Utilidades.esUsuario(nickTextField.getText())) {
					valido = false;
					nickTextField.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Nick ");
				}
				if (nombretextField.getText().compareTo("") == 0 || nombretextField.getText().charAt(0) == ' '
						|| UtilidadesBD.toEmpresa(nombretextField.getText()) != null) {
					valido = false;
					nombretextField.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Nombre ");
				}
				if (numIdtextField.getText().compareTo("") == 0 || numIdtextField.getText().charAt(0) == ' '
						|| !Utilidades.dniCorrecto(numIdtextField.getText())) {
					valido = false;
					numIdtextField.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " CIF ");
				} else {
					if (Utilidades.candidatoExisteDNI(numIdtextField.getText())) {
						valido = false;
						numIdtextField.setText("");
						lbl_Invalido.setText(lbl_Invalido.getText() + " CIF ");
					}
				}
				if (emailtextField.getText().compareTo("") == 0 || emailtextField.getText().charAt(0) == ' '
						|| !Utilidades.correoValido(emailtextField.getText())|| Utilidades.existeCorreo(emailtextField.getText())){
					valido = false;
					emailtextField.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Email ");
				}
				if (teltextField.getText().compareTo("") == 0 || teltextField.getText().charAt(0) == ' '
						|| !Utilidades.telefonoValido(teltextField.getText())) {
					valido = false;
					teltextField.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Tel ");
				}
				if (dirtextField.getText().compareTo("") == 0) {
					valido = false;
					dirtextField.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Dir");
				}
				if (String.valueOf(passwordField.getPassword()).compareTo("") == 0) {
					valido = false;
					passwordField.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText() + " Contrase�a");
				}
				String fecha=comboAFecha();
				if((Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(fecha.substring(0, 4)))<18)
				{
					valido=false;
					diacomboBox.setSelectedIndex(0);
					mescomboBox.setSelectedIndex(0);
					aniocomboBox.setSelectedIndex(0);
					lbl_Invalido.setText(lbl_Invalido.getText()+" Fecha");
				}
				if(apellidostextField.getText().compareTo("")==0 || apellidostextField.getText().charAt(0)==' ')
				{
					valido=false;
					apellidostextField.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText()+" Apellidos");
				}
				int i=0;
				while(i<experienciaProfesionaltextField.getText().length() && ((experienciaProfesionaltextField.getText().charAt(i)>='0' && experienciaProfesionaltextField.getText().charAt(i)<='9')|| experienciaProfesionaltextField.getText().charAt(i)=='.'))
					i++;
				if(i<experienciaProfesionaltextField.getText().length() || experienciaProfesionaltextField.getText().compareTo("")==0 || i<experienciaProfesionaltextField.getText().length() || Float.parseFloat(experienciaProfesionaltextField.getText())<0)
				{
					valido=false;
					experienciaProfesionaltextField.setText("");
					lbl_Invalido.setText(lbl_Invalido.getText()+" Experiencia Profecional");
				}
				lbl_Invalido.setVisible(!valido);
				if (valido) {
					aux=new Candidato(nickTextField.getText(), String.valueOf(passwordField.getPassword()), nombretextField.getText(), numIdtextField.getText(), dirtextField.getText(), emailtextField.getText(), teltextField.getText(), apellidostextField.getText(), fecha, chckbxCarnet.getSelectedObjects()==null?false:true,chckbxCoche.getSelectedObjects()==null?false:true, chckbxDisponibilidadParaViajar.getSelectedObjects()==null?false:true, estudiostextArea.getText(), conocimientosEditar.getConocimientosAnadidos(), otrosConocimientostextArea.getText(), vidaLaboraltextArea.getText(), Float.parseFloat(experienciaProfesionaltextField.getText()));
					UtilidadesBD.insertarCandidato(aux);
					VentanaIdentificarse.cerrar();
					VentanaPrincipal.ejecutar();
					Aplicacion.setUsuario(aux);
					numIdtextField.setText("");
					otrosConocimientostextArea.setText("");
					dirtextField.setText("");
					emailtextField.setText("");
					nickTextField.setText("");
					nombretextField.setText("");
					passwordField.setText("");
					teltextField.setText("");
					estudiostextArea.setText("");
					otrosConocimientostextArea.setText("");
					vidaLaboraltextArea.setText("");
					chckbxCarnet.setSelected(false);
					chckbxCoche.setSelected(false);
					chckbxDisponibilidadParaViajar.setSelected(false);
					diacomboBox.setSelectedIndex(0);
					mescomboBox.setSelectedIndex(0);
					aniocomboBox.setSelectedIndex(0);
					apellidostextField.setText("");
					conocimientosEditar.actualizarListas(Usuario.getConocimientosTotales(), null);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO mandar correo
		}
		
	}
}
