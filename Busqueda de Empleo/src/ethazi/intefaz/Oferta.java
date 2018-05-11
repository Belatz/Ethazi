package ethazi.intefaz;

public class Oferta {
	/*jon:esta clase solo es de pruebas*/
	private String titulo;
	private String empresa;
	private String descripcion;
	private int salario;

	public Oferta(String titulo, String empresa, String descripcion, int salario) {
		super();
		this.titulo = titulo;
		this.empresa = empresa;
		this.descripcion = descripcion;
		this.salario = salario;
	}

	protected String getTitulo() {
		return titulo;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	protected String getEmpresa() {
		return empresa;
	}

	protected void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	protected String getDescripcion() {
		return descripcion;
	}

	protected void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	protected int getSalario() {
		return salario;
	}

	protected void setSalario(int salario) {
		this.salario = salario;
	}

}
