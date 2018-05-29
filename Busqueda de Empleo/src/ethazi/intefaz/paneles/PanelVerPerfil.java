package ethazi.intefaz.paneles;

import javax.swing.JPanel;

import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.Empresa;
import ethazi.aplicacion.Usuario;
import ethazi.aplicacion.Utilidades;
import ethazi.datos.UtilidadesBD;
import ethazi.intefaz.emergentes.EmergenteCambios;
import ethazi.intefaz.emergentes.EmergenteSoloAceptar;
import ethazi.intefaz.emergentes.TieneEmergente;
import ethazi.intefaz.frame.VentanaPrincipal;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.awt.TextArea;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class PanelVerPerfil extends JPanel implements TieneEmergente{
	/**
	 * This panel is used to show the data of the correspondent user: Empresa or
	 * Candidato
	 * 
	 * @author Nestor, Belatz
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nickTextField;
	private JTextField dirtextField;
	private JTextField nombretextField;
	private JTextField apellidostextField;
	private JTextField numIdtextField;
	private JTextField teltextField;
	private JTextField emailtextField;
	private JTextField experienciaProfesionaltextField;
	private TextArea estudiostextArea;
	private TextArea otrosConocimientostextArea;
	private TextArea vidaLaboraltextArea;
	private JCheckBox chckbxCarnet;
	private JCheckBox chckbxCoche;
	private JCheckBox chckbxDisponibilidadParaViajar;
	private JTextArea informacionContactotextArea;
	private JTextArea descripciontextArea;
	private JComboBox<Integer> diacomboBox;
	private JComboBox<Integer> mescomboBox;
	private JComboBox<Integer> aniocomboBox;
	private PanelListaDoble conocimientosEditar;
	private JPanel panel;
	private JButton btnEditar;
	private JButton btnValidar;
	private JButton btnCancelar;
	private JLabel lblContrasea;
	
	private Usuario miUsuario = Aplicacion.getUsuario();
	private boolean esPropio = true;
	private JPasswordField passwordField;
	// private boolean emergenteAceptado;

	public PanelVerPerfil() {
		panel = this;
		setName("Ver Perfil");
		setPreferredSize(new Dimension(762, 488));
		setLayout(null);
		crearPanel();
	}

	private void crearPanel() {
		JLabel milblNick = new JLabel("Nick: ");
		milblNick.setBounds(10, 65, 46, 14);
		add(milblNick);

		nickTextField = new JTextField();
		nickTextField.setBounds(46, 62, 130, 20);

		nickTextField.setEditable(false);
		add(nickTextField);
		nickTextField.setColumns(10);

		JLabel milblNombre = new JLabel("Nombre:");
		milblNombre.setBounds(217, 65, 78, 14);
		add(milblNombre);

		nombretextField = new JTextField();
		nombretextField.setBounds(274, 62, 159, 20);

		nombretextField.setEditable(false);
		add(nombretextField);
		nombretextField.setColumns(10);

		JLabel milblNumId = new JLabel(miUsuario instanceof Empresa ? "CIF:" : "DNI:");
		milblNumId.setBounds(10, 90, 26, 14);
		add(milblNumId);

		numIdtextField = new JTextField();
		numIdtextField.setBounds(46, 90, 85, 20);

		numIdtextField.setEditable(false);
		add(numIdtextField);
		numIdtextField.setColumns(10);

		JLabel milblDireccion = new JLabel("Dir: ");
		milblDireccion.setBounds(141, 87, 26, 20);
		add(milblDireccion);

		dirtextField = new JTextField();
		dirtextField.setBounds(186, 90, 314, 20);

		dirtextField.setEditable(false);
		add(dirtextField);
		dirtextField.setColumns(10);

		JLabel milblEmail = new JLabel("Email: ");
		milblEmail.setBounds(136, 123, 58, 14);
		add(milblEmail);

		emailtextField = new JTextField();
		emailtextField.setBounds(186, 121, 280, 20);

		emailtextField.setEditable(false);
		add(emailtextField);
		emailtextField.setColumns(10);

		JLabel milblTelefono = new JLabel("Tel: ");
		milblTelefono.setBounds(10, 123, 26, 14);
		add(milblTelefono);

		teltextField = new JTextField();
		teltextField.setBounds(46, 121, 85, 20);

		teltextField.setEditable(false);
		add(teltextField);
		teltextField.setColumns(10);

		if (miUsuario instanceof Candidato) {
			JLabel milblApellidos = new JLabel("Apellidos: ");
			milblApellidos.setBounds(456, 65, 78, 14);
			add(milblApellidos);

			apellidostextField = new JTextField();
			apellidostextField.setBounds(527, 62, 225, 20);

			apellidostextField.setEditable(false);
			add(apellidostextField);
			apellidostextField.setColumns(10);

			JLabel milblFechaNac = new JLabel("Fecha Nacimiento: ");
			milblFechaNac.setBounds(10, 148, 121, 14);
			add(milblFechaNac);

			diacomboBox = new JComboBox<Integer>();
			diacomboBox.setBounds(123, 148, 46, 20);
			add(diacomboBox);

			mescomboBox = new JComboBox<Integer>();
			mescomboBox.setBounds(187, 148, 46, 20);
			add(mescomboBox);

			aniocomboBox = new JComboBox<Integer>();
			aniocomboBox.setBounds(246, 148, 85, 20);
			add(aniocomboBox);

			JLabel lblEstudios = new JLabel("Estudios:");
			lblEstudios.setBounds(10, 198, 58, 14);
			add(lblEstudios);

			estudiostextArea = new TextArea();
			estudiostextArea.setEditable(false);

			estudiostextArea.setBounds(83, 198, 653, 58);
			add(estudiostextArea);

			JLabel lblConocimientos = new JLabel("Conocimientos:");
			lblConocimientos.setBounds(10, 254, 102, 14);
			add(lblConocimientos);

			conocimientosEditar = new PanelListaDoble(Usuario.getConocimientosTotales(),
					((Candidato) miUsuario).getConocimientos());
			conocimientosEditar.setBounds(60, 270, 214, 177);
			add(conocimientosEditar);

			JLabel lblOtrosConocimientos = new JLabel("Otros Conocimientos:");
			lblOtrosConocimientos.setBounds(325, 264, 125, 14);
			add(lblOtrosConocimientos);

			otrosConocimientostextArea = new TextArea();

			otrosConocimientostextArea.setEditable(false);
			otrosConocimientostextArea.setBounds(456, 264, 280, 51);
			add(otrosConocimientostextArea);

			JLabel lblVidaLaboral = new JLabel("Vida Laboral:");
			lblVidaLaboral.setBounds(325, 323, 108, 14);
			add(lblVidaLaboral);

			vidaLaboraltextArea = new TextArea();

			vidaLaboraltextArea.setEditable(false);
			vidaLaboraltextArea.setBounds(456, 321, 280, 51);
			add(vidaLaboraltextArea);

			JLabel lblExperienciaProfesional = new JLabel("Experiencia Profesional:");
			lblExperienciaProfesional.setBounds(483, 172, 154, 14);
			add(lblExperienciaProfesional);

			experienciaProfesionaltextField = new JTextField();

			experienciaProfesionaltextField.setEditable(false);
			experienciaProfesionaltextField.setColumns(10);
			experienciaProfesionaltextField.setBounds(647, 169, 39, 20);
			add(experienciaProfesionaltextField);

			chckbxCarnet = new JCheckBox("Carnet de Conducir");
			chckbxCarnet.setEnabled(false);
			chckbxCarnet.setBounds(10, 171, 157, 23);
			add(chckbxCarnet);

			chckbxCoche = new JCheckBox("Coche Propio");
			chckbxCoche.setEnabled(((Candidato) miUsuario).hasCochePropio());
			chckbxCoche.setBounds(186, 168, 118, 23);
			add(chckbxCoche);

			chckbxDisponibilidadParaViajar = new JCheckBox("Disponibilidad para Viajar");
			chckbxDisponibilidadParaViajar.setEnabled(((Candidato) miUsuario).hasDisViajar());
			chckbxDisponibilidadParaViajar.setBounds(303, 171, 174, 23);
			add(chckbxDisponibilidadParaViajar);
		} else {
			JLabel lblInformacinDeContacto = new JLabel("Informaci\u00F3n de Contacto de Recursos Humanos:");
			lblInformacinDeContacto.setBounds(46, 203, 239, 20);
			add(lblInformacinDeContacto);

			informacionContactotextArea = new JTextArea();

			informacionContactotextArea.setText(((Empresa) miUsuario).getContacto());
			informacionContactotextArea.setBounds(46, 234, 239, 213);
			add(informacionContactotextArea);

			JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
			lblDescripcin.setBounds(343, 203, 239, 20);
			add(lblDescripcin);

			descripciontextArea = new JTextArea();

			descripciontextArea.setText(((Empresa) miUsuario).getDescripcion());
			descripciontextArea.setBounds(343, 234, 239, 213);
			add(descripciontextArea);
		}

		inicializarDatos(miUsuario);
		Label label = new Label("Su Perfil:");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 30));
		label.setBounds(10, 0, 742, 44);
		add(label);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 742, 2);
		add(separator);
		
		lblContrasea= new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(476, 124, 82, 14);
		lblContrasea.setVisible(false);
		add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(568, 121, 184, 17);
		passwordField.setVisible(false);
		add(passwordField);
		if (esPropio) {
			btnEditar= new JButton("Editar");
			btnEditar.setToolTipText("Editar Perfil");
			btnEditar.setBounds(693, 454, 67, 23);
			add(btnEditar);
			habilitarODes(false, miUsuario);
			btnEditar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnEditar.setVisible(false);
					btnValidar= new JButton("Guardar");
					btnValidar.setToolTipText("Guardar Cambios");
					btnValidar.setBounds(677, 454, 83, 23);
					add(btnValidar);
					btnCancelar= new JButton("Cancelar");
					btnCancelar.setBounds(2, 454, 86, 23);
					add(btnCancelar);
					habilitarODes(true, miUsuario);
					lblContrasea.setVisible(true);
					passwordField.setVisible(true);
					btnValidar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
//							EmergenteCambios.createWindow("�Esta seguro de que desea guardar los cambios?",
//									(TieneEmergente) panel);
//							if (emergenteAceptado) {
								if (validarDatos(miUsuario)) {
									try {
										if(passwordField.getPassword()!=null && (String.valueOf(passwordField.getPassword()).compareTo("")==0 || String.valueOf(passwordField.getPassword()).isEmpty()))
											miUsuario.setPassword(String.valueOf(passwordField.getPassword()));
										miUsuario.setNombre(nombretextField.getText());
										miUsuario.setDireccion(dirtextField.getText());
										miUsuario.setEmail(emailtextField.getText());
										miUsuario.setTelefono(teltextField.getText());

										if (miUsuario instanceof Candidato) {
											((Candidato) miUsuario).setApellidos(apellidostextField.getText());
											((Candidato) miUsuario)
													.setDisViajar(chckbxDisponibilidadParaViajar.isSelected());
											((Candidato) miUsuario).setCarnet(chckbxCarnet.isSelected());
											((Candidato) miUsuario).setCochePropio(chckbxCoche.isSelected());
											((Candidato) miUsuario).setExperienciaProfesional(
													Float.parseFloat(experienciaProfesionaltextField.getText()));
											((Candidato) miUsuario)
													.setOtrosConocimientos(otrosConocimientostextArea.getText());
											((Candidato) miUsuario).setVidaLaboral(vidaLaboraltextArea.getText());
											((Candidato) miUsuario).setEstudios(estudiostextArea.getText());
											// mes-anyo-dia -> aaaa/mm/dd
											String fecha = String.join(
													String.valueOf(mescomboBox.getSelectedItem() + "-"),
													String.valueOf(aniocomboBox.getSelectedItem() + "-"),
													String.valueOf(diacomboBox.getSelectedItem()));
											((Candidato) miUsuario).setFechaNac(fecha);
											((Candidato) miUsuario)
													.setConocimientos(conocimientosEditar.getConocimientosAnadidos());
										} else {
											((Empresa) miUsuario).setDescripcion(descripciontextArea.getText());
											((Empresa) miUsuario).setContacto(informacionContactotextArea.getText());
										}

										UtilidadesBD.actualizarUsuario(miUsuario);
										EmergenteSoloAceptar.createWindow("Se han guardado los cambios",
												(TieneEmergente) panel, true);
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
								} else {
									EmergenteSoloAceptar.createWindow("No se ha podido guardar los cambios",
											(TieneEmergente) panel,false);
								}
						}
					});
					btnCancelar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							habilitarODes(false, miUsuario);
							lblContrasea.setVisible(false);
							passwordField.setVisible(false);
							btnEditar.setVisible(true);
							inicializarDatos(miUsuario);
							remove(btnValidar);
							remove(btnCancelar);
						}
					});

				}
			});
		} else {
			if (miUsuario instanceof Candidato) {
				JButton btnGuardarCV = new JButton("Guardar CV");
				btnGuardarCV.setToolTipText("Guarda el Curr\u00EDculum Vitae");
				btnGuardarCV.setBounds(693, 454, 67, 23);
				btnGuardarCV.setVisible(true);

				btnGuardarCV.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						File cv = new File(
								miUsuario.getNombre() + "-" + ((Candidato) miUsuario).getApellidos() + "-CV");
						if (cv.exists()) {
							cv.delete();
						}
						PrintWriter pw;
						try {
							pw = new PrintWriter(new FileWriter(cv));
							pw.println(miUsuario.getNombre() + " " + ((Candidato) miUsuario).getApellidos());
							pw.println(miUsuario.getNumID());
							pw.println(miUsuario.getDireccion());
							pw.println(((Candidato) miUsuario).getFechaNac());
							pw.println(miUsuario.getTelefono());
							pw.println(miUsuario.getEmail());
							pw.println("Carnet de Conducir: " + (((Candidato) miUsuario).hasCarnet() ? "Sí" : "No"));
							pw.println("Coche Propio: " + (((Candidato) miUsuario).hasCarnet() ? "Sí" : "No"));
							pw.println("Disponibilidad para Viajar: "
									+ (((Candidato) miUsuario).hasCarnet() ? "Sí" : "No"));
							pw.println("Estudios: " + ((Candidato) miUsuario).getEstudios());
							pw.println("Conocimientos: ");
							for (int i = 0; i < ((Candidato) miUsuario).getConocimientos().size(); i++) {
								pw.println(((Candidato) miUsuario).getConocimientos().get(i));
							}
							pw.println("Otros Conocimientos:");
							pw.println(((Candidato) miUsuario).getOtrosConocimientos());
							pw.println("Vida Laboral: " + ((Candidato) miUsuario).getVidaLaboral());
							pw.print("Experiencia Profesional: " + ((Candidato) miUsuario).getExperienciaProfesional()
									+ " años");
							pw.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

					}
				});
			}
		}
	}

	private boolean validarDatos(Usuario user) {
		boolean _esValido = true;

		if (nombretextField.getText() == null || nombretextField.getText().isEmpty())
			_esValido = false;
		else
			if(user instanceof Empresa && user.getNombre().compareToIgnoreCase(nombretextField.getText())!=0 && Utilidades.empresaExiste(nombretextField.getText()))
				_esValido=false;
		if (dirtextField.getText() == null || dirtextField.getText().isEmpty())
			_esValido = false;
		if (teltextField.getText() == null || teltextField.getText().isEmpty() || !Utilidades.telefonoValido(teltextField.getText()))
			_esValido = false;
		try {
			if (emailtextField.getText() == null || emailtextField.getText().isEmpty()
					|| !Utilidades.correoValido(emailtextField.getText()) ||emailtextField.getText().compareToIgnoreCase(user.getEmail())!=0 && UtilidadesBD.existeEmail(emailtextField.getText()))
				_esValido = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (miUsuario instanceof Candidato) {
			try {
				if (nombretextField.getText()== null || nombretextField.getText().isEmpty()
						|| UtilidadesBD.toEmpresa(nombretextField.getText()) != null) {
					_esValido = false;
					nombretextField.setText("");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String fecha=comboAFecha();
			if((Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(fecha.substring(0, 4)))<18)
			{
				_esValido=false;
				diacomboBox.setSelectedIndex(0);
				mescomboBox.setSelectedIndex(0);
				aniocomboBox.setSelectedIndex(0);
			}
			if (apellidostextField.getText() == null || apellidostextField.getText().isEmpty())
				_esValido = false;
			if (teltextField.getText()!=null|| teltextField.getText().isEmpty()
					|| !Utilidades.telefonoValido(teltextField.getText())) {
				_esValido = false;
				teltextField.setText("");
			}
			if (dirtextField!=null || dirtextField.getText().isEmpty()) {
				_esValido = false;
				dirtextField.setText("");
			}
			int i=0;
			while(i<experienciaProfesionaltextField.getText().length() && ((experienciaProfesionaltextField.getText().charAt(i)>='0' && experienciaProfesionaltextField.getText().charAt(i)<='9')|| experienciaProfesionaltextField.getText().charAt(i)=='.'))
				i++;
			if(i<experienciaProfesionaltextField.getText().length() || experienciaProfesionaltextField.getText().compareTo("")==0 || i<experienciaProfesionaltextField.getText().length() || Float.parseFloat(experienciaProfesionaltextField.getText())<0)
			{
				_esValido=false;
				experienciaProfesionaltextField.setText("");
			}
		} else {
			if (informacionContactotextArea.getText() == null || informacionContactotextArea.getText().isEmpty())
				_esValido = false;
		}

		return _esValido;
	}

	private void inicializarDatos(Usuario user) {
		nickTextField.setText(user.getNick());
		nombretextField.setText(user.getNombre());
		numIdtextField.setText(user.getNumID());
		dirtextField.setText(user.getDireccion());
		emailtextField.setText(user.getEmail());
		teltextField.setText(user.getTelefono());

		if (user instanceof Candidato) {
			apellidostextField.setText(((Candidato) user).getApellidos());

			estudiostextArea.setText(((Candidato) user).getEstudios());
			for (int i = Calendar.getInstance().get(Calendar.YEAR); i >= (Calendar.getInstance().get(Calendar.YEAR)
					- 90); i--)
				aniocomboBox.addItem(Integer.valueOf(i));
			aniocomboBox.setSelectedItem(Integer.valueOf(((Candidato) user).getFechaNac().substring(0,((Candidato) user).getFechaNac().indexOf('-'))));
			for (int i = 1; i <= 12; i++)
				mescomboBox.addItem(Integer.valueOf(i));
			int pos1=((Candidato)user).getFechaNac().indexOf('-')+1;
			int pos2=((Candidato)user).getFechaNac().lastIndexOf('-');
			mescomboBox.setSelectedItem(Integer.valueOf(((Candidato) user).getFechaNac().substring(pos1, pos2)));

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
			diacomboBox.setSelectedItem(Integer.valueOf(((Candidato) user).getFechaNac().substring(pos2+1)));

			otrosConocimientostextArea.setText(((Candidato) user).getOtrosConocimientos());
			vidaLaboraltextArea.setText(((Candidato) user).getVidaLaboral());
			experienciaProfesionaltextField.setText(String.valueOf(((Candidato) user).getExperienciaProfesional()));
			chckbxCarnet.setSelected(((Candidato) user).hasCarnet());
			chckbxCoche.setSelected(((Candidato) user).hasCochePropio());
			chckbxDisponibilidadParaViajar.setSelected(((Candidato) user).hasDisViajar());
			conocimientosEditar.actualizarListas(Usuario.getConocimientosTotales(),
					((Candidato) user).getConocimientos());
		} else {
			informacionContactotextArea.setEditable(false);
			descripciontextArea.setEditable(false);
		}
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

	private void habilitarODes(boolean hab, Usuario user) {
		nombretextField.setEditable(hab);
		dirtextField.setEditable(hab);
		teltextField.setEditable(hab);
		emailtextField.setEditable(hab);

		if (user instanceof Empresa) {
			descripciontextArea.setEditable(hab);
			informacionContactotextArea.setEditable(hab);
		} else {
			apellidostextField.setEditable(hab);

			chckbxDisponibilidadParaViajar.setEnabled(hab);
			chckbxCarnet.setEnabled(hab);
			chckbxCoche.setEnabled(hab);
			experienciaProfesionaltextField.setEditable(hab);
			otrosConocimientostextArea.setEditable(hab);
			vidaLaboraltextArea.setEditable(hab);
			estudiostextArea.setEditable(hab);
			diacomboBox.setEnabled(hab);
			mescomboBox.setEnabled(hab);
			aniocomboBox.setEnabled(hab);
			conocimientosEditar.getBtn_anadir().setVisible(hab);
			conocimientosEditar.getBtn_eliminar().setVisible(hab);
		}
	}

	public void cambiarPerfil(Usuario user, boolean esPropio) {
		miUsuario = user;
		this.esPropio = esPropio;

		this.removeAll();
		crearPanel();
	}

	@Override
	public void funcionalidad(boolean aceptado) {
	if(aceptado)
		{
			btnEditar.setVisible(true);
			btnValidar.setVisible(false);
			btnCancelar.setVisible(false);
			habilitarODes(false, miUsuario);
			lblContrasea.setVisible(false);
			passwordField.setVisible(false);
	}
		
	}
	private String comboAFecha() {
		return aniocomboBox.getSelectedItem()+"-"+
				mescomboBox.getSelectedItem()+"-"+
				diacomboBox.getSelectedItem();
	}
}
