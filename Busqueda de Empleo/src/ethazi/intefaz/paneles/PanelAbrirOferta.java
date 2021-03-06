package ethazi.intefaz.paneles;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTextArea;

import ethazi.aplicacion.Oferta;
import ethazi.aplicacion.Usuario;
import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Candidato;
import ethazi.aplicacion.Contrato;
import ethazi.aplicacion.Empresa;
import ethazi.datos.UtilidadesBD;
import ethazi.intefaz.emergentes.EmergenteCambios;
import ethazi.intefaz.emergentes.TieneEmergente;
import ethazi.intefaz.frame.VentanaPrincipal;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * @author Nestor, Belatz, Xavier, JonOr
 */
public class PanelAbrirOferta extends JPanel implements TieneEmergente {
	/**
	 * Shows offers, with their data
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txField_Empresa;
	private JTextField txField_sueldoMin;
	private JTextField txField_sueldoMax;
	private JTextField txField_experiencia;
	private JTextField txField_buscarCono;
	private JTextField txField_lugar;
	private JTextArea txArea_aspectosValorar;
	private JTextArea txArea_aspectosImpres;
	private JTextArea txArea_descripcion;
	private PanelListaDoble pa_conocimientos;
	private JComboBox<Contrato> combo_contrato;
	private JLabel lbl_Oferta;
	private final JPanel padre = this;
	private JButton btn_cancelar;
	private JButton btn_guardar;
	private JButton button_Editar;
	private JButton btnRetirar;
	private JButton btnEliminar;
	private JButton btn_crear;

	private Oferta miOferta;

	/**
	 * Creates the panel
	 * 
	 * �
	 * 
	 * 
	 */
	public PanelAbrirOferta() {
		try {
			miOferta = new Oferta(0, "Dummy", "Oferta de muestra", "", 1, 1, 0, "", "", false, Contrato.value(1),
					(Empresa) UtilidadesBD.toUsuario("Dummy2", true), Usuario.getConocimientosTotales());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		setName("Abir Oferta");
		setPreferredSize(new Dimension(762, 488));
		setLayout(null);

		crearPanel();
	}

	/**
	 * To change the offer, first removes all information, and then creates a new
	 * panel.
	 * 
	 * @param ofer
	 */
	public void cambiarOferta(Oferta ofer) {
		miOferta = ofer;

		this.removeAll();
		crearPanel();
	}

	/**
	 * Creates the panel of the offer
	 */
	private void crearPanel() {
		JLabel lbl_Empresa = new JLabel("Empresa:");
		lbl_Empresa.setBounds(10, 52, 72, 14);
		add(lbl_Empresa);

		txField_Empresa = new JTextField();
		txField_Empresa.setBounds(116, 49, 204, 20);
		add(txField_Empresa);
		txField_Empresa.setColumns(10);

		lbl_Oferta = new JLabel(" ");
		lbl_Oferta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Oferta.setBounds(10, 11, 742, 20);
		add(lbl_Oferta);

		JLabel lbl_sueldoMin = new JLabel("Sueldo Minimo:");
		lbl_sueldoMin.setBounds(10, 83, 96, 14);
		add(lbl_sueldoMin);

		txField_sueldoMin = new JTextField();
		txField_sueldoMin.setColumns(10);
		txField_sueldoMin.setBounds(116, 80, 93, 20);
		add(txField_sueldoMin);

		JLabel lbl_sueldoMax = new JLabel("Sueldo Maximo:");
		lbl_sueldoMax.setBounds(10, 115, 96, 14);
		add(lbl_sueldoMax);

		txField_sueldoMax = new JTextField();
		txField_sueldoMax.setColumns(10);
		txField_sueldoMax.setBounds(116, 112, 93, 20);
		add(txField_sueldoMax);

		JLabel lbl_experiencia = new JLabel("A\u00F1os de experiencia minimos:");
		lbl_experiencia.setBounds(10, 143, 185, 14);
		add(lbl_experiencia);

		txField_experiencia = new JTextField();
		txField_experiencia.setColumns(10);
		txField_experiencia.setBounds(205, 140, 93, 20);
		add(txField_experiencia);

		JLabel lbl_aspectosValorar = new JLabel("Aspectos a valorar:");
		lbl_aspectosValorar.setBounds(10, 178, 137, 14);
		add(lbl_aspectosValorar);

		txArea_aspectosValorar = new JTextArea();
		txArea_aspectosValorar.setBorder(UIManager.getBorder("TextField.border"));
		txArea_aspectosValorar.setBounds(157, 172, 253, 41);
		add(txArea_aspectosValorar);

		JLabel lbl_aspectosImpres = new JLabel("Aspectos imprescindibles:");
		lbl_aspectosImpres.setBounds(10, 238, 133, 14);
		add(lbl_aspectosImpres);

		txArea_aspectosImpres = new JTextArea();
		txArea_aspectosImpres.setBorder(UIManager.getBorder("TextField.border"));
		txArea_aspectosImpres.setBounds(157, 232, 253, 41);
		add(txArea_aspectosImpres);

		JLabel lbl_descripcion = new JLabel("Descripcion:");
		lbl_descripcion.setBounds(10, 302, 107, 14);
		add(lbl_descripcion);

		txArea_descripcion = new JTextArea();
		txArea_descripcion.setBorder(UIManager.getBorder("TextField.border"));
		txArea_descripcion.setBounds(10, 328, 465, 149);
		add(txArea_descripcion);

		JLabel lbl_conocimientos = new JLabel("Conocimientos requeridos:");
		lbl_conocimientos.setBounds(537, 125, 169, 14);
		add(lbl_conocimientos);

		pa_conocimientos = new PanelListaDoble(Usuario.getConocimientosTotales(), miOferta.getConocimientos());
		pa_conocimientos.setBounds(537, 174, 215, 180);
		add(pa_conocimientos);

		txField_buscarCono = new JTextField();
		txField_buscarCono.setBounds(537, 140, 135, 20);
		add(txField_buscarCono);
		txField_buscarCono.setColumns(10);

		JButton btn_buscar = new JButton("");
		btn_buscar.setBounds(682, 138, 24, 23);
		add(btn_buscar);

		btn_crear = new JButton("");
		btn_crear.setBounds(716, 138, 24, 23);
		add(btn_crear);

		txField_lugar = new JTextField();
		txField_lugar.setEditable(false);
		txField_lugar.setColumns(10);
		txField_lugar.setBounds(506, 49, 234, 20);
		add(txField_lugar);

		JLabel lbl_lugar = new JLabel("Lugar de trabajo:");
		lbl_lugar.setBounds(392, 52, 104, 14);
		add(lbl_lugar);

		JLabel lbl_contrato = new JLabel("Tipo de contrato:");
		lbl_contrato.setBounds(392, 83, 104, 14);
		add(lbl_contrato);

		combo_contrato = new JComboBox<Contrato>();
		combo_contrato.addItem(Contrato.INDEFINIDO_TIEMPO_COMPLETO);
		combo_contrato.addItem(Contrato.INDEFINIDO_TIEMPO_PARCIAL);
		combo_contrato.addItem(Contrato.TEMPORAL_TIEMPO_COMPLETO);
		combo_contrato.addItem(Contrato.TEMPORTAL_TIEMPO_PARCIAL);
		combo_contrato.setBounds(506, 83, 159, 20);
		add(combo_contrato);
		// d
		inicializar(miOferta);
		desHabCampos(false);
		if (miOferta.getEmpresa().getNumID().compareToIgnoreCase(Aplicacion.getUsuario().getNumID()) == 0) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setToolTipText("Eliminar");
			btnEliminar.setBounds(492, 384, 125, 41);
			add(btnEliminar);

			btnRetirar = new JButton("\uD83D\uDC40");
			btnRetirar.setToolTipText("Retirar Oferta");
			btnRetirar.setBounds(627, 384, 125, 41);
			add(btnRetirar);

			button_Editar = new JButton("Editar");
			button_Editar.setToolTipText("Editar");
			button_Editar.setBounds(627, 436, 125, 41);
			add(button_Editar);

			button_Editar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					desHabCampos(true);
					button_Editar.setVisible(false);
					btnEliminar.setVisible(false);
					btnRetirar.setVisible(false);
					btn_crear.setVisible(false);

					btn_guardar = new JButton("Guardar");
					btn_guardar.setToolTipText("Guardar");
					btn_guardar.setBounds(627, 436, 125, 41);
					add(btn_guardar);

					btn_cancelar = new JButton("Cancelar");
					btn_cancelar.setToolTipText("Cancelar");
					btn_cancelar.setBounds(492, 436, 125, 41);
					add(btn_cancelar);

					btn_cancelar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							btn_guardar.removeAll();
							btn_cancelar.removeAll();
							btn_cancelar.setVisible(false);
							btn_guardar.setVisible(false);
							btnEliminar.setVisible(true);
							button_Editar.setVisible(true);
							btnRetirar.setVisible(true);
							btn_crear.setVisible(true);
							inicializar(miOferta);
							desHabCampos(false);
						}
					});

					btn_guardar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							EmergenteCambios.createWindow("�Desea guardar los cambios?", (TieneEmergente) padre);
						}
					});
				}
			});
		}
	}

	/**
	 * Initializes the offer's information to be introduced.
	 * 
	 * @param ofer
	 */
	private void inicializar(Oferta ofer) {
		lbl_Oferta.setText(ofer.getTitulo());
		txField_Empresa.setText(ofer.getEmpresa().getNombre());
		txArea_descripcion.setText(ofer.getDescripcion());
		txField_lugar.setText(ofer.getLugar());
		txField_experiencia.setText(String.valueOf(ofer.getExperiencia()));
		combo_contrato.setSelectedItem(ofer.getContrato());
		txField_sueldoMax.setText(String.valueOf(ofer.getSalarioMax()));
		txField_sueldoMin.setText(String.valueOf(ofer.getSalarioMin()));
		txArea_aspectosValorar.setText(ofer.getAspectosAValorar());
		txArea_aspectosImpres.setText(ofer.getAspectosImprescindibles());
	}

	/**
	 * Makes the fields editable to insert information to the offer.
	 * 
	 * @param hab
	 */
	private void desHabCampos(boolean hab) {
		lbl_Oferta.setEnabled(hab);
		txArea_descripcion.setEditable(hab);
		txField_lugar.setEditable(hab);
		txField_experiencia.setEditable(hab);
		combo_contrato.setEditable(hab);
		txField_sueldoMax.setEditable(hab);
		txField_sueldoMin.setEditable(hab);
		txArea_aspectosImpres.setEditable(hab);
		txArea_aspectosValorar.setEditable(hab);
		pa_conocimientos.setEnabled(hab);
		txField_Empresa.setEnabled(false);
		pa_conocimientos.getBtn_anadir().setEnabled(hab);
		pa_conocimientos.getBtn_eliminar().setEnabled(hab);
	}

	/**
	 * It gives functionality to the buttons so the offer can be saved, cancelled,
	 * edited or deleted.
	 */
	@Override
	public void funcionalidad(boolean aceptado) {
		if (aceptado) {
			btn_guardar.removeAll();
			btn_cancelar.removeAll();
			btn_cancelar.setVisible(false);
			btn_guardar.setVisible(false);
			btnEliminar.setVisible(true);
			button_Editar.setVisible(true);
			btnRetirar.setVisible(true);
			btn_crear.setVisible(true);

			if (validarDatos()) {
				// Actualizar miOferta
				miOferta.setDescripcion(txArea_descripcion.getText());
				miOferta.setLugar(txField_lugar.getText());
				miOferta.setExperiencia(Float.parseFloat(txField_experiencia.getText()));
				miOferta.setContrato(((Contrato) combo_contrato.getSelectedItem()));
				miOferta.setSalarioMax(Integer.parseInt(txField_sueldoMax.getText()));
				miOferta.setSalarioMin(Integer.parseInt(txField_sueldoMin.getText()));
				miOferta.setAspectosImprescindibles(txArea_aspectosImpres.getText());
				miOferta.setAspectosAValorar(txArea_aspectosValorar.getText());
				miOferta.setConocimientos(pa_conocimientos.getConocimientosAnadidos());
			}

			try {
				UtilidadesBD.actualizarOferta(miOferta);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validates the inserted information of the offer.
	 * 
	 * @return _esValido
	 */
	private boolean validarDatos() {
		boolean _esValido = true;

		if (txField_lugar.getText() == null || txField_lugar.getText().isEmpty())
			_esValido = false;
		return _esValido;
	}

	public void setOferta(Oferta oferta) {
		miOferta = oferta;
	}
}
