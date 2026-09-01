package datos;

import java.time.LocalDate;
import java.util.Set;



public class Festival {
	private int idFestival;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Set<UnidadVenta> unidadesVenta;
	private Costo costo;

	public Festival() {}

	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, Costo costo) {
	    this.nombre = nombre;
	    this.temporada = temporada;
	    this.fechaInicio = fechaInicio;
	    this.fechaFin = fechaFin;
	    this.costo = costo;

	    if (costo != null) {
	        costo.setFestival(this);
	    }
	}
	
	

	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin) {
	    this.nombre = nombre;
	    this.temporada = temporada;
	    this.fechaInicio = fechaInicio;
	    this.fechaFin = fechaFin;

	}
	
	public Set<UnidadVenta> getUnidadesVenta() {
	    return unidadesVenta;
	}

	public void setUnidadesVenta(Set<UnidadVenta> unidadesVenta) {
	    this.unidadesVenta = unidadesVenta;
	}
	
	public int getIdFestival() {
		return idFestival;
	}

	protected void setIdFestival(int idFestival) {
		this.idFestival = idFestival;
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

	
	public Costo getCosto() {
		return costo;
	}

	public void setCosto(Costo costo) {
		this.costo = costo;
	}



	@Override
	public String toString() {
		return "Festival [id=" + idFestival + ", nombre=" + nombre + ", temporada=" + temporada + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", costo=" + costo + "]";
	};
	
	
	

}