package ethazi.aplicacion;

import java.util.ArrayList;

import ethazi.intefaz.Elemento_Listable;

/**
 * @author Jonor
 */
public class Oferta implements Elemento_Listable {
<<<<<<< HEAD
	private int miCod_oferta;
=======

	/**
	 * Shows all the contents of the offer
	 */
	/* jon:esta clase solo es de pruebas */

	private int miCodigo;
>>>>>>> master
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

<<<<<<< HEAD
	
	public Oferta(int cod_oferta, String miTitulo, String miDescripcion, String miLugar, int miSalarioMax, int miSalarioMin,
			int miExperiencia, String misAspectosAValorar, String misAspectosImprescindibles, boolean miVisibilidad,
			byte miContrato, Empresa miEmpresa, ArrayList<String> conocimientos) {
		super();
		this.miCod_oferta = cod_oferta;
=======
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
	public Oferta(int miCodigo, String miTitulo, String miDescripcion, String miLugar, int miSalarioMax, int miSalarioMin,
		  int miExperiencia, String misAspectosAValorar, String misAspectosImprescindibles, boolean miVisibilidad,
			byte miContrato, Empresa miEmpresa, ArrayList<String> conocimientos) {
		super();
		this.miCodigo = miCodigo;
>>>>>>> master
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

	public void setCodigo(int miCodigo) {
		this.miCodigo = miCodigo;
	}

	@Override
	public String getInfo() {
		return miTitulo;
	}

	/**
	 * 
	 * @return
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
	 * @return
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

	/**
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.miTitulo = titulo;
	}

	/**
	 * 
	 * @return
	 */
	public Empresa getEmpresa() {
		return miEmpresa;
	}

	/**
	 * 
	 * @param empresa
	 */
	public void setEmpresa(Empresa empresa) {
		this.miEmpresa = empresa;
	}

	/**
	 * 
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
	 */
	public byte getContrato() {
		return miContrato;
	}

	/**
	 * 
	 * @param miContrato
	 */
	public void setContrato(byte miContrato) {
		this.miContrato = miContrato;
	}

	/**
	 * 
	 * @return
	 */
	public int getExperiencia() {
		return miExperiencia;
	}

	/**
	 * 
	 * @param miExperiencia
	 */
	public void setExperiencia(int miExperiencia) {
		this.miExperiencia = miExperiencia;
	}

	/**
	 * 
	 * @return
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
