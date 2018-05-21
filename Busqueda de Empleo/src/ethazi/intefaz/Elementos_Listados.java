package ethazi.intefaz;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * 
 * @author Nestor
 *
 */

public class Elementos_Listados extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1617775952182198487L;
	/** The array elementos A listar. */
	private ArrayList<Elemento_A_Listar> arrayElementos_A_Listar = new ArrayList<Elemento_A_Listar>();

	/** The Constant C_LIMITEMAX. */
	public static final int C_LIMITEMAX = 10;

	/** The limit. */
	public int limite = C_LIMITEMAX;

	/** The max pages. */
	private int maxPags;

	/** The n of pages. */
	private int nPagina = 1;

	/** The type. */
	private byte tipo;

	/** The list of elementos listables. */
	ArrayList<Elemento_Listable> listaDeElementosListables;

	/**
	 * Instantiates a new elementos listados.
	 *
	 * @param listaDeElementosListables
	 *            the list of elementos listables
	 * @param tipo
	 *            the type
	 */
	public Elementos_Listados(ArrayList<Elemento_Listable> listaDeElementosListables, byte tipo) {
		this.tipo = tipo;
		this.listaDeElementosListables = listaDeElementosListables;
		maxPags = ((listaDeElementosListables.size() / limite)
				+ (int) Math.pow(listaDeElementosListables.size() % limite, 0));
		setLayout(null);
		setAlignmentX(0);
		setAlignmentY(0);
		setPreferredSize(new Dimension(600, 1050));
		mostrar10();
		for (int i = 0, coordenada = 0; i < limite; i++, coordenada += 100) {
			arrayElementos_A_Listar.get(i).setBounds(10, coordenada, 500, 91);
			add(arrayElementos_A_Listar.get(i));
		}
	}

	/**
	 * Upgrade.
	 */
	public void actualizar() {
		removeAll();
		for (int i = 0, coordenada = 0; i < this.limite; i++, coordenada += 100) {

			arrayElementos_A_Listar.get(i).setBounds(10, coordenada, 500, 91);
			add(arrayElementos_A_Listar.get(i));
		}
	}

	/**
	 * Show 10.
	 */
	public void mostrar10() {
		int cont = 0;
		int elemento = (nPagina * C_LIMITEMAX) - C_LIMITEMAX;
		int sobra = listaDeElementosListables.size() % 10;
		if (sobra != 0 && maxPags == 1) {
			this.limite = sobra;
		}

		Elemento_A_Listar aux;
		while (cont < this.limite) {
			aux = new Elemento_A_Listar(listaDeElementosListables.get(elemento + cont), tipo);
			arrayElementos_A_Listar.add(aux);
			cont++;
		}

	}

	/**
	 * Show other 10.
	 */
	public void mostrarOtras10() {
		int cont = 0;
		arrayElementos_A_Listar.clear();
		arrayElementos_A_Listar = new ArrayList<Elemento_A_Listar>();
		int elemento = (nPagina * C_LIMITEMAX) - C_LIMITEMAX;
		int sobra = listaDeElementosListables.size() % 10;

		if (sobra != 0 && maxPags == nPagina) {
			this.limite = sobra;
		}
		Elemento_A_Listar aux;
		while (cont < this.limite) {
			aux = new Elemento_A_Listar(listaDeElementosListables.get(elemento + cont), (byte) 1);
			arrayElementos_A_Listar.add(aux);
			cont++;
		}
		actualizar();
		updateUI();
	}

	/**
	 * Gets the max page.
	 *
	 * @return the max page.
	 */
	public int getMaxPags() {
		return maxPags;
	}

	/**
	 * Gets the n of pages.
	 *
	 * @return the n of page.
	 */
	public int getnPagina() {
		return nPagina;
	}

	/**
	 * Sums the page.
	 */
	public void sumarPagina() {
		this.nPagina++;
	}

	/**
	 * Substracts the page.
	 */
	public void restarPagina() {
		this.nPagina--;
	}

}
