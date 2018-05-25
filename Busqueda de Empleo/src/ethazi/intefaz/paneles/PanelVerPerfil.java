package ethazi.intefaz.paneles;

import javax.swing.JPanel;

import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.Empresa;
import ethazi.aplicacion.Usuario;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
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
import java.util.Calendar;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class PanelVerPerfil extends JPanel {
	/**
	 * 
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

	public PanelVerPerfil(Usuario user, boolean propio) {
		setPreferredSize(new Dimension(762, 488));
		setLayout(null);
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

		JLabel milblNumId = new JLabel(user instanceof Empresa?"CIF:":"DNI:");
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

		if (user instanceof Candidato) {
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
	
			conocimientosEditar = new PanelListaDoble(Usuario.getConocimientosTotales(), ((Candidato)user).getConocimientos());
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
			chckbxCoche.setEnabled(((Candidato) user).isCochePropio());
			chckbxCoche.setBounds(186, 168, 118, 23);
			add(chckbxCoche);

			chckbxDisponibilidadParaViajar = new JCheckBox("Disponibilidad para Viajar");
			chckbxDisponibilidadParaViajar.setEnabled(((Candidato) user).isDisViajar());
			chckbxDisponibilidadParaViajar.setBounds(303, 171, 174, 23);
			add(chckbxDisponibilidadParaViajar);
		} else {
			JLabel lblInformacinDeContacto = new JLabel("Informaci\u00F3n de Contacto de Recursos Humanos:");
			lblInformacinDeContacto.setBounds(46, 203, 239, 20);
			add(lblInformacinDeContacto);

			informacionContactotextArea = new JTextArea();

			informacionContactotextArea.setText(((Empresa) user).getContacto());
			informacionContactotextArea.setBounds(46, 234, 239, 213);
			add(informacionContactotextArea);

			JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
			lblDescripcin.setBounds(343, 203, 239, 20);
			add(lblDescripcin);

			descripciontextArea = new JTextArea();

			descripciontextArea.setText(((Empresa) user).getDescripcion());
			descripciontextArea.setBounds(343, 234, 239, 213);
			add(descripciontextArea);
		}

		inicializarDatos(user);
		Label label = new Label("Su Perfil:");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 30));
		label.setBounds(10, 0, 742, 44);
		add(label);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 742, 2);
		add(separator);
		if (propio) {
			JButton btnEditar = new JButton("Editar");
			btnEditar.setToolTipText("Editar Perfil");
			btnEditar.setBounds(693, 454, 67, 23);
			add(btnEditar);
			habilitarODes(false, user);
			btnEditar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnEditar.setVisible(false);
					JButton btnValidar = new JButton("Guardar");
					btnValidar.setToolTipText("Guardar Cambios");
					btnValidar.setBounds(677, 454, 83, 23);
					add(btnValidar);
					JButton btnCancelar = new JButton("Cancelar");
					btnCancelar.setBounds(2, 454, 86, 23);
					add(btnCancelar);
					habilitarODes(true, user);
					btnValidar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							//TODO dar funcionalidad a validar y guardar datos
						}
					});
					btnCancelar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							habilitarODes(false, user);
							btnValidar.removeAll();
							btnCancelar.removeAll();
							btnEditar.setVisible(true);
							inicializarDatos(user);
						}
					});

				}
			});
		} else {
			if (user instanceof Candidato) {
				JButton btnGuardarCV = new JButton("Guardar CV");
				btnGuardarCV.setToolTipText("Guarda el Curr\u00EDculum Vitae");
				btnGuardarCV.setBounds(693, 454, 67, 23);
				btnGuardarCV.setVisible(true);

				btnGuardarCV.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						File cv = new File(user.getNombre() + "-" + ((Candidato) user).getApellidos() + "-CV");
						if (cv.exists()) {
							cv.delete();
						}
						PrintWriter pw;
						try {
							pw = new PrintWriter(new FileWriter(cv));
							pw.println(user.getNombre() + " " + ((Candidato) user).getApellidos());
							pw.println(user.getNumID());
							pw.println(user.getDireccion());
							pw.println(((Candidato) user).getFechaNac());
							pw.println(user.getTelefono());
							pw.println(user.getEmail());
							pw.println("Carnet de Conducir: " + (((Candidato) user).isCarnet() ? "Sí" : "No"));
							pw.println("Coche Propio: " + (((Candidato) user).isCarnet() ? "Sí" : "No"));
							pw.println("Disponibilidad para Viajar: " + (((Candidato) user).isCarnet() ? "Sí" : "No"));
							pw.println("Estudios: " + ((Candidato) user).getEstudios());
							pw.println("Conocimientos: ");
							for (int i = 0; i < ((Candidato) user).getConocimientos().size(); i++) {
								pw.println(((Candidato) user).getConocimientos().get(i));
							}
							pw.println("Otros Conocimientos:");
							pw.println(((Candidato) user).getOtrosConocimientos());
							pw.println("Vida Laboral: " + ((Candidato) user).getVidaLaboral());
							pw.print(
									"Experiencia Profesional: " + ((Candidato) user).getExperienciaProfesional() + " años");
							pw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						

					}
				});
			}
		}
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
			aniocomboBox.setSelectedItem(Integer.valueOf(((Candidato) user).getFechaNac().substring(6)));
			for (int i = 1; i <= 12; i++)
				mescomboBox.addItem(Integer.valueOf(i));
			mescomboBox.setSelectedItem(Integer.valueOf(((Candidato) user).getFechaNac().substring(3, 5)));
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
			diacomboBox.setSelectedItem(Integer.valueOf(((Candidato) user).getFechaNac().substring(0, 2)));

			otrosConocimientostextArea.setText(((Candidato) user).getOtrosConocimientos());
			vidaLaboraltextArea.setText(((Candidato) user).getVidaLaboral());
			experienciaProfesionaltextField.setText(String.valueOf(((Candidato) user).getExperienciaProfesional()));
			chckbxCarnet.setSelected(((Candidato) user).isCarnet());
			chckbxCoche.setSelected(((Candidato) user).isCochePropio());
			chckbxDisponibilidadParaViajar.setSelected(((Candidato) user).isDisViajar());
			conocimientosEditar.actualizarListas(Usuario.getConocimientosTotales(), ((Candidato)user).getConocimientos());
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
}
