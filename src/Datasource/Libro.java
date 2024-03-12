package Datasource;

public class Libro {
	
	private String codigo, título, autor, localización, asignatura;
	private boolean disponible;
	
	public Libro() {

	}

	public Libro(String codigo, String título, String autor, String localización, String asignatura,
			boolean disponible) {
		this.codigo = codigo;
		this.título = título;
		this.autor = autor;
		this.localización = localización;
		this.asignatura = asignatura;
		this.disponible = disponible;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTítulo() {
		return título;
	}

	public void setTítulo(String título) {
		this.título = título;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLocalización() {
		return localización;
	}

	public void setLocalización(String localización) {
		this.localización = localización;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	@Override
	public String toString() {
		return "Libro{" + "codigo=" + codigo + ",título= "+ título +
				", autor= "+autor+"localización= "+ localización + 
				", asignatura= "+ asignatura + ", disponibilidad" + 
				disponible+"}";
	}
}
