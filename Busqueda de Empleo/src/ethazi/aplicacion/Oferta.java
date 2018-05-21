package ethazi.aplicacion;

import ethazi.intefaz.Elemento_Listable;

public class Oferta implements Elemento_Listable {
	/*jon:esta clase solo es de pruebas*/
	private int miCod;
	private String miTitulo;
	private String miDescripcion;
	private String miLugar;
	private int miSalarioMax;
	private int miSalarioMin;
	private int miExperiencia;
	private String misAspectosAValorar;
	private String misAspectosImprescindibles;
	private boolean miVisibilidad;
	private byte miContrato;
	private Empresa miEmpresa;

	
	public Oferta(int miCod, String miTitulo, String miDescripcion, String miLugar, int miSalarioMax, int miSalarioMin,
			int miExperiencia, String misAspectosAValorar, String misAspectosImprescindibles, boolean miVisibilidad,
			byte miContrato, Empresa miEmpresa) {
		super();
		this.miCod = miCod;
		this.miTitulo = miTitulo;
		this.miDescripcion = miDescripcion;
		this.miLugar = miLugar;
		this.miSalarioMax = miSalarioMax;
		this.miSalarioMin = miSalarioMin;
		this.miExperiencia = miExperiencia;
		this.misAspectosAValorar = misAspectosAValorar;
		this.misAspectosImprescindibles = misAspectosImprescindibles;
		this.miVisibilidad = miVisibilidad;
		this.miContrato = miContrato;
		this.miEmpresa = miEmpresa;
	}

	@Override
	public String getInfo() {
		return miTitulo;
	}

	public void setTitulo(String titulo) {
		this.miTitulo = titulo;
	}

	public Empresa getEmpresa() {
		return miEmpresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.miEmpresa = empresa;
	}

	public String getDescripcion() {
		return miDescripcion;
	}

	public void setDescripcion(String descripcion) {
		this.miDescripcion = descripcion;
	}

	public int getSalarioMax() {
		return miSalarioMax;
	}

	public void setSalarioMax(int salario) {
		this.miSalarioMax = salario;
	}
	
	public int getSalarioMin() {
		return miSalarioMin;
	}

	public void setSalarioMin(int salario) {
		this.miSalarioMin = salario;
	}

}
