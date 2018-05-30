package ethazi.aplicacion;

import java.util.ArrayList;

import ethazi.intefaz.Elemento_Listable;

/**
 * 
 * @author Jonor
 */
public class Oferta implements Elemento_Listable {

	private int miCodigo;
	private String miTitulo;
	private String miDescripcion;
	private String miLugar;
	private int miSalarioMax;
	private int miSalarioMin;
	private float miExperiencia;
	private String misAspectosAValorar;
	private String misAspectosImprescindibles;
	private boolean miVisibilidad;
	private Contrato miContrato;
	private Empresa miEmpresa;
	private ArrayList<String> misConocimientos;

	/**
	 * 
	 * @param miTitulo
	 * @param miDescripcion
	 * @param miLugar
	 * @param miSalarioMax
	 * @param miSalarioMin
	 * @param miExperiencia
	 * @param misAspectosAValorar
	 * @param misAspectosImprescindibles
	 * @param miVisibilidad
	 * @param miContrato
	 * @param miEmpresa
	 * @param conocimientos
	 */
	public Oferta(int miCodigo, String miTitulo, String miDescripcion, String miLugar, int miSalarioMax,
			int miSalarioMin, float miExperiencia, String misAspectosAValorar, String misAspectosImprescindibles,
			boolean miVisibilidad, Contrato miContrato, Empresa miEmpresa, ArrayList<String> conocimientos) {
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
		this.misConocimientos = conocimientos;
	}

	public Oferta(String miTitulo, String miDescripcion, String miLugar, int miSalarioMax, int miSalarioMin,
			float miExperiencia, String misAspectosAValorar, String misAspectosImprescindibles, boolean miVisibilidad,
			Contrato miContrato, Empresa miEmpresa, ArrayList<String> conocimientos) {
		super();
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
		this.misConocimientos = conocimientos;
	}

	public int getCodigo() {
		return miCodigo;
	}

	@Override
	public String getInfo() {
		return miTitulo;
	}

	/**
	 * 
	 * @return miVisivilidad
	 */
	public boolean isVisibilidad() {
		return miVisibilidad;
	}

	/**
	 * 
	 * @param miVisibilidad
	 */
	public void setVisibilidad(boolean miVisibilidad) {
		this.miVisibilidad = miVisibilidad;
	}

	/**
	 * 
	 * @return misConocimientos
	 */
	public ArrayList<String> getConocimientos() {
		return misConocimientos;
	}

	/**
	 * 
	 * @param misConocimientos
	 */
	public void setConocimientos(ArrayList<String> misConocimientos) {
		this.misConocimientos = misConocimientos;
	}

	public String getTitulo() {
		return miTitulo;
	}

	/**
	 * 
	 * @return miEmpresa
	 */
	public Empresa getEmpresa() {
		return miEmpresa;
	}

	/**
	 * 
	 * @return miDescripcion
	 */
	public String getDescripcion() {
		return miDescripcion;
	}

	/**
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.miDescripcion = descripcion;
	}

	/**
	 * 
	 * @return miSalario
	 */
	public int getSalarioMax() {
		return miSalarioMax;
	}

	/**
	 * 
	 * @param salario
	 */
	public void setSalarioMax(int salario) {
		this.miSalarioMax = salario;
	}

	/**
	 * 
	 * @return
	 */
	public int getSalarioMin() {
		return miSalarioMin;
	}

	/**
	 * 
	 * @param salario
	 */
	public void setSalarioMin(int salario) {
		this.miSalarioMin = salario;
	}

	/**
	 * 
	 * @return misAspectosAValorar
	 */
	public String getAspectosAValorar() {
		return misAspectosAValorar;
	}

	/**
	 * 
	 * @param misAspectosAValorar
	 */
	public void setAspectosAValorar(String misAspectosAValorar) {
		this.misAspectosAValorar = misAspectosAValorar;
	}

	/**
	 * 
	 * @return misAspectosImprescindibles
	 */
	public String getAspectosImprescindibles() {
		return misAspectosImprescindibles;
	}

	/**
	 * 
	 * @param misAspectosImprescindibles
	 */
	public void setAspectosImprescindibles(String misAspectosImprescindibles) {
		this.misAspectosImprescindibles = misAspectosImprescindibles;
	}

	/**
	 * 
	 * @return miContrato
	 */
	public Contrato getContrato() {
		return miContrato;
	}

	/**
	 * 
	 * @param miContrato
	 */
	public void setContrato(Contrato miContrato) {
		this.miContrato = miContrato;
	}

	/**
	 * 
	 * @return miExperiencia
	 */
	public float getExperiencia() {
		return miExperiencia;
	}

	/**
	 * 
	 * @param miExperiencia
	 */
	public void setExperiencia(float miExperiencia) {
		this.miExperiencia = miExperiencia;
	}

	/**
	 * 
	 * @return miLugar
	 */
	public String getLugar() {
		return miLugar;
	}

	/**
	 * 
	 * @param miLugar
	 */
	public void setLugar(String miLugar) {
		this.miLugar = miLugar;
	}

}
