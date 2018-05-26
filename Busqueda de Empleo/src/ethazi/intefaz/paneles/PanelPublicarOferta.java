package ethazi.intefaz.paneles;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.UIManager;

import ethazi.aplicacion.Usuario;
import ethazi.intefaz.emergentes.EmergenteCambios;
import ethazi.intefaz.emergentes.TieneEmergente;

import javax.swing.JButton;
import javax.swing.JComboBox;

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
	private final JPanel padre=this;
	/**
	 * Create the panel.
	 */
	public PanelPublicarOferta() {
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
		lbl_sueldoMin.setBounds(10, 83, 85, 14);
		add(lbl_sueldoMin);
		
		txField_sueldoMin = new JTextField();
		txField_sueldoMin.setColumns(10);
		txField_sueldoMin.setBounds(93, 80, 93, 20);
		add(txField_sueldoMin);
		
		JLabel lbl_sueldoMax = new JLabel("Sueldo Maximo:");
		lbl_sueldoMax.setBounds(10, 115, 85, 14);
		add(lbl_sueldoMax);
		
		txField_sueldoMax = new JTextField();
		txField_sueldoMax.setColumns(10);
		txField_sueldoMax.setBounds(93, 112, 93, 20);
		add(txField_sueldoMax);
		
		JLabel lbl_experiencia = new JLabel("Anos de experiencia minimos:");
		lbl_experiencia.setBounds(10, 143, 152, 14);
		add(lbl_experiencia);
		
		txField_experiencia = new JTextField();
		txField_experiencia.setColumns(10);
		txField_experiencia.setBounds(162, 140, 93, 20);
		add(txField_experiencia);
		
		JLabel lbl_aspectosValorar = new JLabel("Aspectos a valorar:");
		lbl_aspectosValorar.setBounds(10, 178, 107, 14);
		add(lbl_aspectosValorar);
		
		JTextArea txArea_aspectosValorar = new JTextArea();
		txArea_aspectosValorar.setBorder(UIManager.getBorder("TextField.border"));
		txArea_aspectosValorar.setBounds(137, 173, 253, 41);
		add(txArea_aspectosValorar);
		
		JLabel lbl_aspectosImpres = new JLabel("Aspectos imprescindibles:");
		lbl_aspectosImpres.setBounds(10, 238, 133, 14);
		add(lbl_aspectosImpres);
		
		JTextArea txArea_aspectosImpres = new JTextArea();
		txArea_aspectosImpres.setBorder(UIManager.getBorder("TextField.border"));
		txArea_aspectosImpres.setBounds(137, 233, 253, 41);
		add(txArea_aspectosImpres);
		
		JLabel lbl_descripcion = new JLabel("Descripcion:");
		lbl_descripcion.setBounds(10, 302, 107, 14);
		add(lbl_descripcion);
		
		JTextArea txArea_descripcion = new JTextArea();
		txArea_descripcion.setBorder(UIManager.getBorder("TextField.border"));
		txArea_descripcion.setBounds(10, 328, 465, 149);
		add(txArea_descripcion);
		
		JLabel lbl_conocimientos = new JLabel("Conocimientos requeridos:");
		lbl_conocimientos.setBounds(537, 125, 169, 14);
		add(lbl_conocimientos);
		
		PanelListaDoble pa_conocimientos = new PanelListaDoble(Usuario.misConocimientosTotales,null);
		pa_conocimientos.setBounds(537, 174, 215, 180);
		add(pa_conocimientos);
		
		txField_buscarCono = new JTextField();
		txField_buscarCono.setBounds(537, 140, 135, 20);
		add(txField_buscarCono);
		txField_buscarCono.setColumns(10);
		
		JButton btn_buscar = new JButton("");
		btn_buscar.setBounds(682, 138, 24, 23);
		add(btn_buscar);
		
		JButton btn_crear = new JButton("");
		btn_crear.setBounds(716, 138, 24, 23);
		add(btn_crear);
		
		txField_lugar = new JTextField();
		txField_lugar.setColumns(10);
		txField_lugar.setBounds(506, 49, 234, 20);
		add(txField_lugar);
		
		JLabel lbl_lugar = new JLabel("Lugar de trabajo:");
		lbl_lugar.setBounds(411, 52, 93, 14);
		add(lbl_lugar);
		
		JLabel lbl_contrato = new JLabel("Tipo de contrato:");
		lbl_contrato.setBounds(411, 86, 93, 14);
		add(lbl_contrato);
		
		JComboBox<String> combo_contrato = new JComboBox<String>();
		combo_contrato.addItem("Indefinido Tiempo Completo");
		combo_contrato.addItem("Indefinido Tiempo Parcial");
		combo_contrato.addItem("Temporal Tiempo Completo");
		combo_contrato.addItem("Temporal Tiempo Parcial");
		combo_contrato.setBounds(506, 83, 159, 20);
		add(combo_contrato);
		
		JButton btn_publicar = new JButton("Publicar oferta");
		btn_publicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmergenteCambios.createWindow("�Desea publicar esta oferta?",(TieneEmergente) padre);
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
		if(aceptado)
		{
			//TODO guardar oferta
		}
		
	}
}
