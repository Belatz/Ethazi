package ethazi.intefaz;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Elemento_A_Listar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel miPaElemento_A_Listar;
	
	private JButton miBtnEliminar;
	private JButton miBtnCambiar_Estado;
	private JLabel miLblAbrir_Elemento;
	private JLabel miLblAnalizar;
	private JButton miBtnEditar;

	public final static byte C_CONSULTAR_SUS_SOLICITUDES = 0;
	public final static byte C_CONSULTAR_OFERTAS = 1;
	public final static byte C_VER_OFERTAS_CON_SOLICITUD = 2;
	public final static byte C_CONSULTAR_SUS_OFERTAS = 3;
	public final static byte C_ANALIZAR_SOLICITUDES = 4;
	public final static byte C_BUSCAR_CANDIDATOS = 5;

	public Elemento_A_Listar(Elemento_Listable p_elemento, byte p_constante_opcion) {
		miPaElemento_A_Listar=new JPanel();
		miPaElemento_A_Listar.setBounds(0, 0, 500, 50);
		setLayout(null);
		
		switch (p_constante_opcion) {
		case 0: {
			miBtnEliminar=new JButton("Retirar Oferta");
			miBtnEliminar.setBounds(364, 44, 107, 30);
			add(miBtnEliminar);
			miLblAnalizar=new JLabel(((Solicitud)p_elemento).getOfer().getEmpresa());//Cuando Empresa sea una Clase hay q hacer el getter del nombre
			miLblAnalizar.setBounds(364, 1, 107, 40);
			add(miLblAnalizar);
			miLblAbrir_Elemento=new JLabel(((Solicitud)p_elemento).getInfo());
			miLblAbrir_Elemento.setBounds(0, 1, 354, 40);
			add(miLblAbrir_Elemento);
			//Codificar 
			miBtnEliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			//Codificar
			miLblAnalizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			//Codificar
			miLblAbrir_Elemento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
		}
			break;
		case 1: {
			miLblAnalizar=new JLabel(((Oferta)p_elemento).getEmpresa());//Cuando Empresa sea una Clase hay q hacer el getter del nombre
			miLblAnalizar.setBounds(364, 1, 117, 40);
			add(miLblAnalizar);
			miLblAbrir_Elemento=new JLabel(((Oferta)p_elemento).getInfo());
			miLblAbrir_Elemento.setBounds(0, 1, 354, 40);
			add(miLblAbrir_Elemento);
			//Codificar 
			miLblAnalizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			//Codificar 
			miLblAbrir_Elemento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
		}
			break;
		case 2: {
			miLblAbrir_Elemento=new JLabel(((Oferta)p_elemento).getInfo());
			miLblAbrir_Elemento.setBounds(0,0,471,50);
			add(miLblAbrir_Elemento);
			//Codificar 
			miLblAbrir_Elemento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
		}
			break;
		case 3: {
			miLblAbrir_Elemento=new JLabel(((Oferta)p_elemento).getInfo());
			miLblAbrir_Elemento.setBounds(0, 0, 290, 50);
			add(miLblAbrir_Elemento);
			miBtnEliminar=new JButton();
			miBtnEliminar.setBounds(400, 0, 50, 50);
			add(miBtnEliminar);
			miBtnEditar=new JButton();
			miBtnEditar.setBounds(300, 0, 50, 50);
			add(miBtnEditar);
			miBtnCambiar_Estado=new JButton();
			miBtnCambiar_Estado.setBounds(350, 0, 50, 50);
			add(miBtnCambiar_Estado);
			//Codificar 
			miLblAbrir_Elemento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			//Codificar 
			miBtnEliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			//Codificar 
			miBtnEditar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			//Codificar 
			miBtnCambiar_Estado.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
		}
			break;
		case 4: {
			miLblAnalizar=new JLabel(((Solicitud)p_elemento).getInfo());
			miLblAnalizar.setBounds(0, 33, 471, 28);
			add(miLblAnalizar);
			miLblAbrir_Elemento=new JLabel(((Solicitud)p_elemento).getDescrip().substring(0,50 )+"...");
			miLblAbrir_Elemento.setBounds(0, 0, 471, 22);
			add(miLblAbrir_Elemento);
			//Codificar 
			miLblAnalizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
			//Codificar 
			miLblAbrir_Elemento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
		}
			break;
		case 5: {
			miLblAnalizar=new JLabel(((Candidato)p_elemento).getInfo());
			miLblAnalizar.setBounds(0,0,450,50);
			add(miLblAnalizar);
			//Codificar 
			miLblAnalizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
				}
			});
		}
			break;
		}
	}

	public JPanel getMiPaElemento_A_Listar() {
		return miPaElemento_A_Listar;
	}

	public void setMiPaElemento_A_Listar(JPanel miPaElemento_A_Listar) {
		this.miPaElemento_A_Listar = miPaElemento_A_Listar;
	}

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