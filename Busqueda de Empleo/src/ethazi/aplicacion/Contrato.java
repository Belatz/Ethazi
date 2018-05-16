package ethazi.aplicacion;

public enum Contrato {
	INDEFINIDO_TIEMPO_COMP(1),
	INDEFINIDO_TIEMPO_PARCIAL(2),
	TEMPORAL_TIEMPO_COMP(3),
	TEMPORAL_TIEMPO_PARCIAL(4);
	
	private final int miTipo;
	
	private Contrato(int miTipo) {
		this.miTipo = miTipo;
	}

	protected int getMiTipo() {
		return miTipo;
	}
	
}
	


