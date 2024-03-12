package Datasource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Prestamo {
	
	private String codigoLibro, numeroSocio;
	private LocalDateTime fecha;
	
	public Prestamo() {
		
	}

	public Prestamo(String codigoLibro, String numeroSocio, LocalDateTime fecha) {
		super();
		this.codigoLibro = codigoLibro;
		this.numeroSocio = numeroSocio;
		this.fecha = fecha;
	}

	public String getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(String codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	public String getNumeroSocio() {
		return numeroSocio;
	}

	public void setNumeroSocio(String numeroSocio) {
		this.numeroSocio = numeroSocio;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	public String getFechaFormato() {
		String formato= "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
		return formateador.format(this.fecha);
	}

	@Override
	public String toString() {
		return "Prestamo [codigoLibro=" + codigoLibro + ", numeroSocio=" + numeroSocio + ", fecha=" + this.getFechaFormato() + "]";
	}
	
}
