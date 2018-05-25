package ethazi.aplicacion;

import ethazi.intefaz.Elemento_Listable;

/**
 * @author Belatz
 */
public class Solicitud implements Elemento_Listable {
	/**
	 * This class shows @ofer @cand @descrip
	 */
	private Oferta ofer;
	private Candidato cand;
	private String descrip;

	public Solicitud(Oferta ofer, Candidato cand, String descrip) {
		super();
		this.ofer = ofer;
		this.cand = cand;
		this.descrip = descrip;
	}

	/**
	 * 
	 * @return ofer
	 */
	public Oferta getOfer() {
		return ofer;
	}

	/**
	 * 
	 * @return cand
	 */
	public Candidato getCand() {
		return cand;
	}

	/**
	 * 
	 * @return descrip
	 */
	public String getDescrip() {
		return descrip;
	}

	@Override
	public String getInfo() {
		return getCand().getInfo();
	}

}
