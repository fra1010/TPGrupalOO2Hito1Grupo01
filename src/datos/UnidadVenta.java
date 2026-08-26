package datos;

import java.util.List;

public class UnidadVenta {
	private long idUnidadVenta;
	private String nombre;
	private Empleado responsable;
	private double superficie;
	private String codigo;
	private List<Empleado>empleados;
	private List<Plato>platos;
	
	public UnidadVenta() {}

	public UnidadVenta(String nombre, Empleado responsable, double superficie, String codigo, List<Empleado> empleados,
			List<Plato> platos) {
		super();
		this.nombre = nombre;
		this.responsable = responsable;
		this.superficie = superficie;
		this.codigo = codigo;
		this.empleados = empleados;
		this.platos = platos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empleado getResponsable() {
		return responsable;
	}

	public void setResponsable(Empleado responsable) {
		this.responsable = responsable;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}


	public long getIdUnidadVenta() {
		return idUnidadVenta;
	}

	public void setIdUnidadVenta(long idUnidadVenta) {
		this.idUnidadVenta = idUnidadVenta;
	}

	@Override
	public String toString() {
		return "UnidadVenta [idUnidadVenta=" + idUnidadVenta + ", nombre=" + nombre + ", responsable=" + responsable
				+ ", superficie=" + superficie + ", codigo=" + codigo + ", empleados=" + empleados + ", platos="
				+ platos + "]";
	}
	
	

}
