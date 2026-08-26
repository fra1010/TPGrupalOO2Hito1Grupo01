package datos;

import java.time.LocalDate;
import java.util.List;

public class Festival {
	private long idFestival;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private List<UnidadVenta>unidadesVenta;
	
	public Festival() {}

	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
			List<UnidadVenta> unidadesventa) {
		super();
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.unidadesVenta = unidadesventa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<UnidadVenta> getUnidadesventa() {
		return unidadesVenta;
	}

	public void setUnidadesventa(List<UnidadVenta> unidadesventa) {
		this.unidadesVenta = unidadesventa;
	}

	

	public long getIdFestival() {
		return idFestival;
	}

	public void setIdFestival(long idFestival) {
		this.idFestival = idFestival;
	}

	@Override
	public String toString() {
		return "Festival [idFestival=" + idFestival + ", nombre=" + nombre + ", temporada=" + temporada
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", unidadesventa=" + unidadesVenta + "]";
	}
	
	
	
	
}

	