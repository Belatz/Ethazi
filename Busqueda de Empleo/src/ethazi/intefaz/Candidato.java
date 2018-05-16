package ethazi.intefaz;

public class Candidato implements Elemento_Listable{
	private String nombre;
	private String apellidos;
	
	
	public Candidato(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String getInfo() {
		return nombre+" "+apellidos;
	}

}
