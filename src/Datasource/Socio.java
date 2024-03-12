package Datasource;

public class Socio {
	
	private String ci, nombre, dirección;

	public Socio() {
		
	}

	public Socio(String ci, String nombre, String dirección) {
		super();
		this.ci = ci;
		this.nombre = nombre;
		this.dirección = dirección;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}

	@Override
	public String toString() {
		return "Socio [ci=" + ci + ", nombre=" + nombre + ", dirección=" + dirección + "]";
	}
	
}
