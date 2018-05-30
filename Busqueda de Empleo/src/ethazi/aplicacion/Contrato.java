package ethazi.aplicacion;

import java.util.ArrayList;

/**
 * This is an enumeration of all the data of contrato
 * 
 * @author mañana
 *
 */
public enum Contrato {
	TEMPORAL_TIEMPO_COMPLETO(0), TEMPORTAL_TIEMPO_PARCIAL(1), INDEFINIDO_TIEMPO_COMPLETO(2), INDEFINIDO_TIEMPO_PARCIAL(
			3);

	private int miTipo;

	private Contrato(int tipo) {
		this.miTipo = tipo;
	}

	public int getTipo() {
		return miTipo;
	}

	public static Contrato value(int i) {
		ArrayList<Contrato> values = new ArrayList<Contrato>();
		values.add(TEMPORAL_TIEMPO_COMPLETO);
		values.add(TEMPORTAL_TIEMPO_PARCIAL);
		values.add(INDEFINIDO_TIEMPO_COMPLETO);
		values.add(INDEFINIDO_TIEMPO_PARCIAL);
		return values.get(i);
	}

	public static int value(Contrato aux) {
		ArrayList<Contrato> values = new ArrayList<Contrato>();
		values.add(TEMPORAL_TIEMPO_COMPLETO);
		values.add(TEMPORTAL_TIEMPO_PARCIAL);
		values.add(INDEFINIDO_TIEMPO_COMPLETO);
		values.add(INDEFINIDO_TIEMPO_PARCIAL);
		int i = 0;
		while (i < values.size() && aux != values.get(i))
			i++;
		if (i == values.size())
			i = -1;
		return i;
	}
}
