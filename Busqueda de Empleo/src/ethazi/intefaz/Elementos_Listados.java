package ethazi.intefaz;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * This class receives elements from the class Elementos_A_Listar
 * 
 * @author Nestor, JonOr
 *
 */
public class Elementos_Listados extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1617775952182198487L;
	/** The array elementos A listar. */
	private ArrayList<Elemento_A_Listar> arrayElementos_A_Listar = new ArrayList<Elemento_A_Listar>();

	/** The Constant C_LIMITEMAX. */
	public static final int C_LIMITEMAX = 10;

	/** The limite. */
	public int limite = C_LIMITEMAX;

	/** The max pags. */
	private int maxPags;

	/** The n pagina. */
	private int nPagina = 1;

	/** The tipo. */
	private byte tipo;

	/** The lista de elementos listables. */
	ArrayList<Elemento_Listable> listaDeElementosListables;

	/**
	 * Instantiates a new elementos listados.
	 *
	 * @param listaDeElementosListables
	 *            the lista de elementos listables
	 * @param tipo
	 *            the tipo
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
	 * Actualizar.
	 */
	public void actualizar() {
		removeAll();
		for (int i = 0, coordenada = 0; i < this.limite; i++, coordenada += 100) {

			arrayElementos_A_Listar.get(i).setBounds(10, coordenada, 500, 91);
			add(arrayElementos_A_Listar.get(i));

		}
	}

	/**
	 * Mostrar 10.
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
	 * Mostrar otras 10.
	 */
	public void mostrarOtras10() {
		limite = 10;
		int cont = 0;
		arrayElementos_A_Listar.clear();
		arrayElementos_A_Listar = new ArrayList<Elemento_A_Listar>();
		int elemento = (nPagina * C_LIMITEMAX) - C_LIMITEMAX;
		int sobra = listaDeElementosListables.size() % limite;

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
	 * Gets the max pags.
	 *
	 * @return the max pags
	 */
	public int getMaxPags() {
		return maxPags;
	}

	/**
	 * Gets the n pagina.
	 *
	 * @return the n pagina
	 */
	public int getnPagina() {
		return nPagina;
	}

	/**
	 * Sumar pagina.
	 */
	public void sumarPagina() {
		this.nPagina++;
	}

	/**
	 * Restar pagina.
	 */
	public void restarPagina() {
		this.nPagina--;
	}

}
