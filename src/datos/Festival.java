package datos;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

public class Festival {
	private int idFestival;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Set<UnidadVenta> unidadesVenta;
	private Costo costo;

	public Festival() {
	}

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

	public Set<UnidadVenta> getUnidadesPorTipo(String tipoUnidad) {
		Set<UnidadVenta> resultado = new HashSet<UnidadVenta>();

		if (unidadesVenta == null) {
			return resultado;
		}

		for (UnidadVenta unidad : unidadesVenta) {
			if (tipoUnidad.equalsIgnoreCase("FoodTruck") && unidad instanceof FoodTruck) {
				resultado.add(unidad);
			}

			if (tipoUnidad.equalsIgnoreCase("PuestoDesarmable") && unidad instanceof PuestoDesarmable) {
				resultado.add(unidad);
			}
		}

		return resultado;
	}

	public String nombresUnidadesPorTipo(String tipoUnidad) {
		StringBuilder resultado = new StringBuilder();

		for (UnidadVenta unidad : getUnidadesPorTipo(tipoUnidad)) {
			if (resultado.length() > 0) {
				resultado.append(", ");
			}

			resultado.append(unidad.getNombre());
		}

		return resultado.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Festival))
			return false;
		Festival other = (Festival) o;
		return java.util.Objects.equals(nombre, other.nombre);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(nombre);
	}

	@Override
	public String toString() {
		return "Festival [id=" + idFestival + ", nombre=" + nombre + ", temporada=" + temporada + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", costo=" + costo + "]";
	};

}