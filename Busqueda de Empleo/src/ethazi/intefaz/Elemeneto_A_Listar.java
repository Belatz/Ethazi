package ethazi.intefaz;

import ethazi.intefaz.Oferta;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Elemeneto_A_Listar extends JPanel {
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

	public Elemeneto_A_Listar(Elemento_Listable p_elemento, byte p_constante_opcion) {
		miPaElemento_A_Listar=new JPanel();
		setLayout(null);
		switch (p_constante_opcion) {
		case 0: {
			miBtnEliminar=new JButton();
			miLblAnalizar=new JLabel(((Oferta)p_elemento).getEmpresa());//Cuando Empresa sea una Clase hay q hacer el getter del nombre
			miLblAbrir_Elemento=new JLabel(((Oferta)p_elemento).getTitulo());
		}
			break;
		case 1: {
			miLblAnalizar=new JLabel(((Oferta)p_elemento).getEmpresa());//Cuando Empresa sea una Clase hay q hacer el getter del nombre
			miLblAbrir_Elemento=new JLabel(((Oferta)p_elemento).getTitulo());
		}
			break;
		case 2: {
			miLblAbrir_Elemento=new JLabel(((Oferta)p_elemento).getTitulo());
		}
			break;
		case 3: {
			miLblAbrir_Elemento=new JLabel(((Oferta)p_elemento).getTitulo());
			miBtnEliminar=new JButton();
			miBtnEditar=new JButton();
			miBtnCambiar_Estado=new JButton();
		}
			break;
		case 4: {

		}
			break;
		case 5: {

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
