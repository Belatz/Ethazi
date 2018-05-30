package ethazi.intefaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import ethazi.aplicacion.*;
import ethazi.excepciones.PanelNoDisponible;
import ethazi.intefaz.frame.VentanaPrincipal;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.prism.paint.Color;

/**
 * List the elements in a panel
 *
 * @author Nestor
 *
 */
public class Elemento_A_Listar extends JPanel {

	private static final long serialVersionUID = 1L;

	// private JPanel miPaElemento_A_Listar;

	private JButton miBtnEliminar;
	private JButton miBtnCambiar_Estado;
	private JLabel miLblAbrir_Elemento;
	private JLabel miLblAnalizar;
	private JButton miBtnEditar;
	private JLabel descripcion;

	public final static byte C_CONSULTAR_SUS_SOLICITUDES = 0;
	public final static byte C_CONSULTAR_OFERTAS = 1;
	public final static byte C_VER_OFERTAS_CON_SOLICITUD = 2;
	public final static byte C_CONSULTAR_SUS_OFERTAS = 3;
	public final static byte C_ANALIZAR_SOLICITUDES = 4;
	public final static byte C_BUSCAR_CANDIDATOS = 5;

	/**
	 * Generates an element so it can be listed in the class Elementos_listados
	 * 
	 * @param p_elemento
	 * @param p_constante_opcion
	 */
	public Elemento_A_Listar(Elemento_Listable p_elemento, byte p_constante_opcion) {
		// miPaElemento_A_Listar=new JPanel();
		/* miPaElemento_A_Listar. */setBounds(0, 0, 450, 50);
		setLayout(null);

		switch (p_constante_opcion) {
		case C_CONSULTAR_SUS_SOLICITUDES: {

			miBtnEliminar = new JButton("Retirar Solicitud");
			miBtnEliminar.setBounds(364, 44, 107, 30);
			add(miBtnEliminar);
			miLblAnalizar = new JLabel(((Solicitud) p_elemento).getOfer().getEmpresa().getNombre());
			miLblAnalizar.setBounds(364, 1, 107, 40);
			add(miLblAnalizar);
			miLblAbrir_Elemento = new JLabel(((Solicitud) p_elemento).getInfo());
			miLblAbrir_Elemento.setBounds(0, 1, 354, 40);
			add(miLblAbrir_Elemento);
			// Codificar
			miBtnEliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			// Codificar
			miLblAnalizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_ANALIZAR_SOLICITUDES,((Solicitud) p_elemento));
					} catch (PanelNoDisponible | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					super.mouseClicked(e);
				}
			});
			// Codificar
			miLblAbrir_Elemento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//gg
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
		}
			break;
		case C_CONSULTAR_OFERTAS: {
			miLblAnalizar = new JLabel(((Oferta) p_elemento).getEmpresa().getNombre());
		
			miLblAnalizar.setBounds(350, 1, 117, 40);
			add(miLblAnalizar);
			descripcion = new JLabel();
			descripcion.setText("Descripción: "+((Oferta) p_elemento).getDescripcion());
			descripcion.setBounds(5, 30, 360, 20);
			add(descripcion);
			miLblAbrir_Elemento = new JLabel(((Oferta) p_elemento).getInfo());
			miLblAbrir_Elemento.setBounds(0, 1, 354, 40);
			add(miLblAbrir_Elemento);
			// Codificar
			miLblAnalizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_ANALIZAR_EMPRESA,((Oferta) p_elemento).getEmpresa());
					} catch (PanelNoDisponible | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					super.mouseClicked(e);
				}
			});
			// Codificar
			miLblAbrir_Elemento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_ABRIR_OFERTA, p_elemento);
					} catch (PanelNoDisponible | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					super.mouseClicked(e);
				}
			});
		}
			break;
		case C_VER_OFERTAS_CON_SOLICITUD: {
			miLblAbrir_Elemento = new JLabel(((Oferta) p_elemento).getInfo());
			miLblAbrir_Elemento.setBounds(0, 0, 471, 50);
			add(miLblAbrir_Elemento);
			// Codificar
			miLblAbrir_Elemento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_OFERTAS_CON_SOLICITUDES, p_elemento);
					} catch (PanelNoDisponible | SQLException e1) {
						
						e1.printStackTrace();
					}
					super.mouseClicked(e);
				}
			});
		}
			break;
		case C_CONSULTAR_SUS_OFERTAS: {
			miLblAbrir_Elemento = new JLabel(((Oferta) p_elemento).getTitulo());
			miLblAbrir_Elemento.setBounds(0, 0, 290, 50);
			add(miLblAbrir_Elemento);
			miBtnEliminar = new JButton();
			miBtnEliminar.setBounds(400, 0, 50, 50);
			add(miBtnEliminar);
			miBtnEditar = new JButton();
			miBtnEditar.setBounds(300, 0, 50, 50);
			add(miBtnEditar);
			miBtnCambiar_Estado = new JButton();
			miBtnCambiar_Estado.setBounds(350, 0, 50, 50);
			add(miBtnCambiar_Estado);
			descripcion = new JLabel();
			descripcion.setText("Descripción: "+((Oferta) p_elemento).getDescripcion());
			descripcion.setBounds(5, 30, 360, 20);
			add(descripcion);
			// Codificar
			miLblAbrir_Elemento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_ABRIR_OFERTA, p_elemento);
					} catch (PanelNoDisponible | SQLException e1) {
						
						e1.printStackTrace();
					}
					super.mouseClicked(e);
				}
			});
			// Codificar
			miBtnEliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					super.mouseClicked(e);
				}
			});
			// Codificar
			miBtnEditar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			// Codificar
			miBtnCambiar_Estado.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
		}
			break;
		case C_ANALIZAR_SOLICITUDES: {
			miLblAnalizar = new JLabel(((Solicitud) p_elemento).getInfo());
			miLblAnalizar.setBounds(0, 33, 471, 28);
			add(miLblAnalizar);
			if (((Solicitud) p_elemento).getInfo().length() > 50)
				miLblAbrir_Elemento = new JLabel(((Solicitud) p_elemento).getDescrip().substring(0, 50) + "...");
			else
				miLblAbrir_Elemento = new JLabel(((Solicitud) p_elemento).getDescrip() + "...");
			miLblAbrir_Elemento.setBounds(0, 0, 471, 22);
			add(miLblAbrir_Elemento);
			// Codificar
			miLblAnalizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						VentanaPrincipal.cambiarPanel((short) VentanaPrincipal.C_ANALIZAR_SOLICITUDES, p_elemento);
					} catch (PanelNoDisponible | SQLException e1) {
						
						e1.printStackTrace();
					}
					super.mouseClicked(e);
				}
			});
			// Codificar
			miLblAbrir_Elemento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
		}
			break;
		case C_BUSCAR_CANDIDATOS: {
			miLblAnalizar = new JLabel(p_elemento.getInfo());
			miLblAnalizar.setBounds(0, 0, 450, 50);
			add(miLblAnalizar);
			// Codificar
			miLblAnalizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
			
					super.mouseClicked(e);
				}
			});
		}
			break;
		}
	}

	/*
	 * public JPanel getMiPaElemento_A_Listar() { return miPaElemento_A_Listar; }
	 * 
	 * public void setMiPaElemento_A_Listar(JPanel miPaElemento_A_Listar) {
	 * this.miPaElemento_A_Listar = miPaElemento_A_Listar; }
	 */



	public JButton getMiBtnEliminar() {
		return miBtnEliminar;
	}

	public void setMiBtnEliminar(JButton miBtnEliminar) {
		this.miBtnEliminar = miBtnEliminar;
	}

	public JButton getMiBtnCambiar_Estado() {
		return miBtnCambiar_Estado;
	}

	public void setMiBtnCambiar_Estado(JButton miBtnCambiar_Estado) {
		this.miBtnCambiar_Estado = miBtnCambiar_Estado;
	}

	public JLabel getMiLblAbrir_Elemento() {
		return miLblAbrir_Elemento;
	}

	public void setMiLblAbrir_Elemento(JLabel miLblAbrir_Elemento) {
		this.miLblAbrir_Elemento = miLblAbrir_Elemento;
	}

	public JLabel getMiLblAnalizar() {
		return miLblAnalizar;
	}

	public void setMiLblAnalizar(JLabel miLblAnalizar) {
		this.miLblAnalizar = miLblAnalizar;
	}

	public JButton getMiBtnEditar() {
		return miBtnEditar;
	}

	public void setMiBtnEditar(JButton miBtnEditar) {
		this.miBtnEditar = miBtnEditar;
	}
}