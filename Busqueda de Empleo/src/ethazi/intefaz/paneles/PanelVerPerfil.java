package ethazi.intefaz.paneles;

import javax.swing.JPanel;

import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.Usuario;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import java.awt.TextArea;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import javax.swing.JSeparator;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelVerPerfil extends JPanel {
	private JTextField nickTextField;
	private JTextField dirtextField;
	private JTextField nombretextField;
	private JTextField apellidostextField;
	private JTextField numIdtextField;
	private JTextField teltextField;
	private JTextField emailtextField;
	private JTextField fechNactextField;
	private JTable table;
	private JTextField experienciaProfesionaltextField;

	public PanelVerPerfil(Usuario user) {
		setPreferredSize(new Dimension(762, 488));
		setLayout(null);
		JLabel milblNick = new JLabel("Nick: ");
		milblNick.setBounds(10, 65, 26, 14);
		add(milblNick);
		
		nickTextField = new JTextField();
		nickTextField.setBounds(46, 62, 130, 20);
		nickTextField.setText(user.getMiNick());
		nickTextField.setEditable(false);
		add(nickTextField);
		nickTextField.setColumns(10);
		
		JLabel milblNombre = new JLabel("Nombre:");
		milblNombre.setBounds(186, 65, 46, 14);
		add(milblNombre);
		
		nombretextField = new JTextField();
		nombretextField.setBounds(230, 62, 159, 20);
		nombretextField.setText(user.getMiNombre());
		nombretextField.setEditable(false);
		add(nombretextField);
		nombretextField.setColumns(10);
		
		JLabel milblNumId = new JLabel(((user instanceof Candidato)?"DNI: ":"CIF:"));
		milblNumId.setBounds(10, 90, 26, 14);
		add(milblNumId);
		
		numIdtextField = new JTextField();
		numIdtextField.setBounds(46, 87, 66, 20);
		numIdtextField.setText(user.getMiNumID());
		numIdtextField.setEditable(false);
		add(numIdtextField);
		numIdtextField.setColumns(10);
		
		JLabel milblDireccion = new JLabel("Dir: ");
		milblDireccion.setBounds(141, 87, 26, 20);
		add(milblDireccion);
		
		dirtextField = new JTextField();
		dirtextField.setBounds(170, 90, 314, 20);
		dirtextField.setText(user.getMiDireccion());
		dirtextField.setEditable(false);
		add(dirtextField);
		dirtextField.setColumns(10);
		
		JLabel milblEmail = new JLabel("Email: ");
		milblEmail.setBounds(136, 123, 31, 14);
		add(milblEmail);
		
		emailtextField = new JTextField();
		emailtextField.setBounds(170, 120, 280, 20);
		emailtextField.setText(user.getMiEmail());
		emailtextField.setEditable(false);
		add(emailtextField);
		emailtextField.setColumns(10);
		
		JLabel milblTelefono = new JLabel("Tel: ");
		milblTelefono.setBounds(10, 115, 26, 14);
		add(milblTelefono);
		
		teltextField = new JTextField();
		teltextField.setBounds(46, 115, 66, 20);
		teltextField.setText(user.getMiTelefono());
		teltextField.setEditable(false);
		add(teltextField);
		teltextField.setColumns(10);
		
		//va dentro del if
		JLabel milblApellidos = new JLabel("Apellidos: ");
		milblApellidos.setBounds(399, 65, 49, 14);
		add(milblApellidos);
		
		apellidostextField = new JTextField();
		apellidostextField.setBounds(448, 62, 304, 20);
		apellidostextField.setText(((Candidato)user).getApellidos());
		apellidostextField.setEditable(false);
		add(apellidostextField);
		apellidostextField.setColumns(10);
		
		JLabel milblFechaNac = new JLabel("Fecha Nacimiento: ");
		milblFechaNac.setBounds(10, 151, 91, 14);
		add(milblFechaNac);
		
		fechNactextField = new JTextField();
		fechNactextField.setBounds(105, 148, 68, 20);
		fechNactextField.setText(((Candidato)user).getFechaNac());
		fechNactextField.setEditable(false);
		add(fechNactextField);
		fechNactextField.setColumns(10);
		
		JLabel lblEstudios = new JLabel("Estudios:");
		lblEstudios.setBounds(10, 198, 46, 14);
		add(lblEstudios);
		
		TextArea estudiostextArea = new TextArea();
		estudiostextArea.setEditable(false);
		estudiostextArea.setText(((Candidato)user).getEstudios());
		estudiostextArea.setBounds(72, 200, 653, 58);
		add(estudiostextArea);
		
		JLabel lblConocimientos = new JLabel("Conocimientos:");
		lblConocimientos.setBounds(10, 264, 76, 14);
		add(lblConocimientos);
		
		table = new JTable();
		table.setBounds(107, 336, 102, -94);
		add(table);
		
		JList list = new JList();
		list.setBounds(136, 348, 159, -94);
		add(list);
		
		JScrollPane conocimientosscrollPane = new JScrollPane();
		conocimientosscrollPane.setBounds(87, 264, 225, 178);
		add(conocimientosscrollPane);
		
		JList conoCimientoslist = new JList();
		conocimientosscrollPane.setViewportView(conoCimientoslist);
		conoCimientoslist.setModel(new AbstractListModel() {
			String[] values = new String[] {"0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblOtrosConocimientos = new JLabel("Otros Conocimientos:");
		lblOtrosConocimientos.setBounds(325, 264, 108, 14);
		add(lblOtrosConocimientos);
		
		TextArea otrosConocimientostextArea = new TextArea();
		otrosConocimientostextArea.setText("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
		otrosConocimientostextArea.setEditable(false);
		otrosConocimientostextArea.setBounds(445, 264, 280, 51);
		add(otrosConocimientostextArea);
		
		JLabel lblVidaLaboral = new JLabel("Vida Laboral");
		lblVidaLaboral.setBounds(322, 323, 108, 14);
		add(lblVidaLaboral);
		
		TextArea vidaLaboraltextArea = new TextArea();
		vidaLaboraltextArea.setText("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
		vidaLaboraltextArea.setEditable(false);
		vidaLaboraltextArea.setBounds(445, 321, 280, 51);
		add(vidaLaboraltextArea);
		
		JLabel lblExperienciaProfesional = new JLabel("Experiencia Profesional:");
		lblExperienciaProfesional.setBounds(424, 172, 130, 14);
		add(lblExperienciaProfesional);
		
		experienciaProfesionaltextField = new JTextField();
		experienciaProfesionaltextField.setText("50,5");
		experienciaProfesionaltextField.setEditable(false);
		experienciaProfesionaltextField.setColumns(10);
		experienciaProfesionaltextField.setBounds(546, 172, 39, 20);
		add(experienciaProfesionaltextField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Carnet de Conducir");
		chckbxNewCheckBox.setEnabled(((Candidato)user).isCarnet());
		chckbxNewCheckBox.setBounds(10, 172, 124, 23);
		add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Coche Propio");
		chckbxNewCheckBox_1.setEnabled(((Candidato)user).isCochePropio());
		chckbxNewCheckBox_1.setBounds(147, 172, 97, 23);
		add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxDisponibilidadParaViajar = new JCheckBox("Disponibilidad para Viajar");
		chckbxDisponibilidadParaViajar.setEnabled(((Candidato)user).isDisViajar());
		chckbxDisponibilidadParaViajar.setBounds(256, 172, 150, 23);
		add(chckbxDisponibilidadParaViajar);
		
		Label label = new Label("Su Perfil:");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 30));
		label.setBounds(10, 0, 742, 44);
		add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 742, 2);
		add(separator);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setToolTipText("Editar Perfil");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditar.setBounds(669, 454, 67, 23);
		add(btnEditar);
		
		
	}
}
