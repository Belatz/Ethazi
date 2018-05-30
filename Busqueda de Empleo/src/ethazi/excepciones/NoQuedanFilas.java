package ethazi.excepciones;

/**
 * it's thrown when the last row it's visualized
 * 
 * @author Belatz
 *
 */
public class NoQuedanFilas extends Exception {

	private static final long serialVersionUID = 1L;

	public NoQuedanFilas() {
	}

	public NoQuedanFilas(String arg0) {
		super(arg0);
	}

	public NoQuedanFilas(Throwable arg0) {
		super(arg0);
	}

	public NoQuedanFilas(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoQuedanFilas(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
