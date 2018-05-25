package ethazi.excepciones;

/**
 * Exception launched when a panel that hasn't been created has been called
 * 
 * @category Excepctions
 * @author belatz
 *
 */
public class PanelNoDisponible extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelNoDisponible() {
	}

	public PanelNoDisponible(String arg0) {
		super(arg0);
	}

	public PanelNoDisponible(Throwable arg0) {
		super(arg0);
	}

	public PanelNoDisponible(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PanelNoDisponible(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
