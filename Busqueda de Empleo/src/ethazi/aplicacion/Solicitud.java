package ethazi.aplicacion;

import ethazi.intefaz.Elemento_Listable;

public class Solicitud implements Elemento_Listable {

	private Oferta ofer;
	private Candidato cand;
	private String descrip;
	public Solicitud(Oferta ofer, Candidato cand, String descrip) {
		super();
		this.ofer = ofer;
		this.cand = cand;
		this.descrip = descrip;
	}
	public Oferta getOfer() {
		return ofer;
	}
	public Candidato getCand() {
		return cand;
	}
	public String getDescrip() {
		return descrip;
	}
	
	@Override
	public String getInfo() {
		return getCand().getInfo();
	}

}
