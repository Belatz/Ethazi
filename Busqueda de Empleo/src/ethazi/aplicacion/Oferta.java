package ethazi.aplicacion;

import java.util.ArrayList;

import ethazi.intefaz.Elemento_Listable;

public class Oferta implements Elemento_Listable {
	private int miCodigo;
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
	private ArrayList<String> misConocimientos;

	
	public Oferta(int miCodigo, String miTitulo, String miDescripcion, String miLugar, int miSalarioMax, int miSalarioMin,
			int miExperiencia, String misAspectosAValorar, String misAspectosImprescindibles, boolean miVisibilidad,
			byte miContrato, Empresa miEmpresa, ArrayList<String> conocimientos) {
		super();
		this.miCodigo = miCodigo;
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
		this.misConocimientos=conocimientos;
	}

	public int getCodigo() {
		return miCodigo;
	}

	public void setCodigo(int miCodigo) {
		this.miCodigo = miCodigo;
	}

	@Override
	public String getInfo() {
		return miTitulo;
	}
	
	public boolean isVisibilidad() {
		return miVisibilidad;
	}

	public void setVisibilidad(boolean miVisibilidad) {
		this.miVisibilidad = miVisibilidad;
	}

	public ArrayList<String> getConocimientos() {
		return misConocimientos;
	}

	public void setConocimientos(ArrayList<String> misConocimientos) {
		this.misConocimientos = misConocimientos;
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
	public String getAspectosAValorar() {
		return misAspectosAValorar;
	}

	public void setAspectosAValorar(String misAspectosAValorar) {
		this.misAspectosAValorar = misAspectosAValorar;
	}

	public String getAspectosImprescindibles() {
		return misAspectosImprescindibles;
	}

	public void setAspectosImprescindibles(String misAspectosImprescindibles) {
		this.misAspectosImprescindibles = misAspectosImprescindibles;
	}

	public byte getContrato() {
		return miContrato;
	}

	public void setContrato(byte miContrato) {
		this.miContrato = miContrato;
	}

	public int getExperiencia() {
		return miExperiencia;
	}

	public void setExperiencia(int miExperiencia) {
		this.miExperiencia = miExperiencia;
	}

	public String getLugar() {
		return miLugar;
	}

	public void setLugar(String miLugar) {
		this.miLugar = miLugar;
	}

}
