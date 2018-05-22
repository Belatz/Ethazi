package ethazi.aplicacion;

public enum Contrato {
	TEMPORAL_TIEMPO_COMPLETO(0),
	TEMPORTAL_TIEMPO_PARCIAL(1),
	INDEFINIDO_TIEMPO_COMPLETO(2),
	INDEFINIDO_TIEMPO_PARCIAL(3);
	
	private int miTipo;
	
	private Contrato(int tipo) {
		this.miTipo = tipo;
	}
	
	public int getTipo() {
		return miTipo;
	}
}
