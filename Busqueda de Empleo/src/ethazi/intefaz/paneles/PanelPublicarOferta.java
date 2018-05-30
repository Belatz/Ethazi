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
import javax.swing.UIManager;

import ethazi.aplicacion.Aplicacion;
import ethazi.aplicacion.Contrato;
import ethazi.aplicacion.Empresa;
import ethazi.aplicacion.Oferta;
import ethazi.aplicacion.Usuario;
import ethazi.datos.UtilidadesBD;
import ethazi.intefaz.emergentes.EmergenteCambios;
import ethazi.intefaz.emergentes.EmergenteSoloAceptar;
import ethazi.intefaz.emergentes.TieneEmergente;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPublicarOferta extends JPanel implements TieneEmergente{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txField_titulo;
	private JTextField txField_sueldoMin;
	private JTextField txField_sueldoMax;
	private JTextField txField_experiencia;
	private JTextField txField_buscarCono;
	private JTextField txField_lugar;
	private JTextArea txArea_descripcion;
	private JTextArea txArea_aspectosImpres;
	private JTextArea txArea_aspectosValorar;
	private PanelListaDoble pa_conocimientos;
	private JComboBox<Contrato> combo_contrato;
	private final JPanel padre=this;
	/**
	 * Create the panel.
	 */
	//TODO label que informe que la oferta se realizó correcta o no
	public PanelPublicarOferta() {
		setName("Publicar Oferta");
		setPreferredSize(new Dimension(762,488));
		setLayout(null);
		
		JLabel lbl_titulo = new JLabel("Titulo:");
		lbl_titulo.setBounds(10, 52, 46, 14);
		add(lbl_titulo);
		
		txField_titulo = new JTextField();
		txField_titulo.setBounds(51, 49, 322, 20);
		add(txField_titulo);
		txField_titulo.setColumns(10);
		
		JLabel lbl_PublicarOferta = new JLabel("Nueva Oferta");
		lbl_PublicarOferta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_PublicarOferta.setBounds(309, 11, 172, 20);
		add(lbl_PublicarOferta);
		
		JLabel lbl_sueldoMin = new JLabel("Sueldo Minimo:");
		lbl_sueldoMin.setBounds(10, 83, 107, 14);
		add(lbl_sueldoMin);
		
		txField_sueldoMin = new JTextField();
		txField_sueldoMin.setColumns(10);
		txField_sueldoMin.setBounds(104, 80, 93, 20);
		add(txField_sueldoMin);
		
		JLabel lbl_sueldoMax = new JLabel("Sueldo Maximo:");
		lbl_sueldoMax.setBounds(10, 115, 107, 14);
		add(lbl_sueldoMax);
		
		txField_sueldoMax = new JTextField();
		txField_sueldoMax.setColumns(10);
		txField_sueldoMax.setBounds(104, 112, 93, 20);
		add(txField_sueldoMax);
		
		JLabel lbl_experiencia = new JLabel("Anos de experiencia minimos:");
		lbl_experiencia.setBounds(10, 143, 187, 14);
		add(lbl_experiencia);
		
		txField_experiencia = new JTextField();
		txField_experiencia.setColumns(10);
		txField_experiencia.setBounds(184, 140, 93, 20);
		add(txField_experiencia);
		
		JLabel lbl_aspectosValorar = new JLabel("Aspectos a valorar:");
		lbl_aspectosValorar.setBounds(10, 178, 133, 14);
		add(lbl_aspectosValorar);
		
		txArea_aspectosValorar= new JTextArea();
		txArea_aspectosValorar.setBorder(UIManager.getBorder("TextField.border"));
		txArea_aspectosValorar.setBounds(120, 195, 253, 41);
		add(txArea_aspectosValorar);
		
		JLabel lbl_aspectosImpres = new JLabel("Aspectos imprescindibles:");
		lbl_aspectosImpres.setBounds(10, 238, 187, 14);
		add(lbl_aspectosImpres);
		
		txArea_aspectosImpres= new JTextArea();
		txArea_aspectosImpres.setBorder(UIManager.getBorder("TextField.border"));
		txArea_aspectosImpres.setBounds(120, 252, 253, 41);
		add(txArea_aspectosImpres);
		
		JLabel lbl_descripcion = new JLabel("Descripcion:");
		lbl_descripcion.setBounds(10, 302, 107, 14);
		add(lbl_descripcion);
		
		txArea_descripcion= new JTextArea();
		txArea_descripcion.setBorder(UIManager.getBorder("TextField.border"));
		txArea_descripcion.setBounds(10, 328, 465, 149);
		add(txArea_descripcion);
		
		JLabel lbl_conocimientos = new JLabel("Conocimientos requeridos:");
		lbl_conocimientos.setBounds(517, 123, 169, 14);
		add(lbl_conocimientos);
		
		pa_conocimientos= new PanelListaDoble(Usuario.misConocimientosTotales,null);
		pa_conocimientos.setBounds(517, 174, 215, 180);
		add(pa_conocimientos);
		
		txField_buscarCono = new JTextField();
		txField_buscarCono.setBounds(517, 140, 135, 20);
		add(txField_buscarCono);
		txField_buscarCono.setColumns(10);
		
		JButton btn_buscar = new JButton("");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pa_conocimientos.filtrarElemento(txField_buscarCono.getText());
			}
		});
		btn_buscar.setBounds(662, 138, 24, 23);
		btn_buscar.setToolTipText("Buscar Conocimiento");
		add(btn_buscar);
		
		JButton btn_restaurar = new JButton("");
		btn_restaurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pa_conocimientos.filtrarElemento("");
				txField_buscarCono.setText("");
			}
		});
		btn_restaurar.setBounds(730, 138, 24, 23);
		btn_restaurar.setToolTipText("Restaurar a la lista sin filtros");
		add(btn_restaurar);
		
		JButton btn_crear = new JButton("");

		btn_crear.setToolTipText("Crear Conocimiento");
		btn_crear.setIcon(new ImageIcon(PanelPublicarOferta.class.getResource("/ethazi/intefaz/iconos/add.png")));

		btn_crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Si el conocimiento ya existe
					if (UtilidadesBD.buscarConocimiento(txField_buscarCono.getText())) {
						EmergenteSoloAceptar.createWindow("El conocimiento ya existe",(TieneEmergente) padre, false);
					}
				} catch (SQLException e) {
					EmergenteCambios.createWindow("¿Seguro que desea añadir el conocimiento?",(TieneEmergente) padre, false);
					
				}
			}
		});
		btn_crear.setBounds(696, 138, 24, 23);
		add(btn_crear);
		
		txField_lugar = new JTextField();
		txField_lugar.setColumns(10);
		txField_lugar.setBounds(518, 49, 234, 20);
		add(txField_lugar);
		
		JLabel lbl_lugar = new JLabel("Lugar de trabajo:");
		lbl_lugar.setBounds(411, 52, 133, 14);
		add(lbl_lugar);
		
		JLabel lbl_contrato = new JLabel("Tipo de contrato:");
		lbl_contrato.setBounds(411, 86, 107, 14);
		add(lbl_contrato);
		
		combo_contrato= new JComboBox<Contrato>();
		combo_contrato.addItem(Contrato.INDEFINIDO_TIEMPO_COMPLETO);
		combo_contrato.addItem(Contrato.INDEFINIDO_TIEMPO_PARCIAL);
		combo_contrato.addItem(Contrato.TEMPORAL_TIEMPO_COMPLETO);
		combo_contrato.addItem(Contrato.TEMPORTAL_TIEMPO_PARCIAL);
		combo_contrato.setBounds(528, 82, 159, 20);
		add(combo_contrato);
		
		JButton btn_publicar = new JButton("Publicar oferta");
		btn_publicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmergenteCambios.createWindow("¿Desea publicar esta oferta?",(TieneEmergente) padre, true);
			}
		});
		btn_publicar.setBounds(627, 436, 125, 41);
		add(btn_publicar);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(492, 436, 125, 41);
		add(btn_cancelar);
		btn_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txArea_aspectosImpres.setText("");
				txArea_aspectosValorar.setText("");
				txArea_descripcion.setText("");
				txField_experiencia.setText("");
				txField_buscarCono.setText("");
				txField_lugar.setText("");
				txField_sueldoMax.setText("");
				txField_sueldoMin.setText("");
				txField_titulo.setText("");
				combo_contrato.setSelectedIndex(0);
				pa_conocimientos.actualizarListas(Usuario.misConocimientosTotales, null);
			}
		});
	}
	@Override
	public void funcionalidad(boolean aceptado) {
		//Añade Oferta
		if(aceptado)
		{
			boolean valido=true;
			try {
				if(txField_titulo==null || txField_titulo.getText().isEmpty() || UtilidadesBD.toOfertaTitulo(txField_titulo.getText())!=null)
				{
					valido=false;
					txField_titulo.setText("");
				}
				if(Integer.valueOf(txField_sueldoMin.getText())>Integer.valueOf(txField_sueldoMax.getText()))
				{
					valido=false;
					txField_sueldoMin.setText("");
					txField_sueldoMax.setText("");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(txField_lugar==null || txField_lugar.getText().isEmpty())
				valido=false;
			if(valido)
			{
				try {
					UtilidadesBD.insertarOferta(new Oferta(txField_titulo.getText(),txArea_descripcion.getText() , txField_lugar.getText(), Integer.valueOf(txField_sueldoMax.getText()), Integer.valueOf(txField_sueldoMin.getText()), Float.parseFloat(txField_experiencia.getText()), txArea_aspectosValorar.getText(), txArea_aspectosImpres.getText(), true,(Contrato)combo_contrato.getSelectedItem(), (Empresa)Aplicacion.getUsuario(), pa_conocimientos.getConocimientosAnadidos()));
					txArea_aspectosImpres.setText("");
					txArea_aspectosValorar.setText("");
					txArea_descripcion.setText("");
					txField_experiencia.setText("");
					txField_buscarCono.setText("");
					txField_lugar.setText("");
					txField_sueldoMax.setText("");
					txField_sueldoMin.setText("");
					txField_titulo.setText("");
					combo_contrato.setSelectedIndex(0);
					pa_conocimientos.actualizarListas(Usuario.misConocimientosTotales, null);
				} catch (NumberFormatException | SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		//Añade Conocimiento
		else
		{
			Usuario.misConocimientosTotales.add(txField_buscarCono.getText());
			pa_conocimientos.actualizarListas(Usuario.misConocimientosTotales, null);
			try {
				UtilidadesBD.insertarConocimiento(txField_buscarCono.getText());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
