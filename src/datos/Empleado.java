package datos;

import java.time.LocalDate;

public class Empleado {
	protected int idEmpleado;
	protected String nombre;
	protected String apellido;
	protected long dni;
	protected LocalDate fechaNacimiento;
	protected LocalDate ingreso;
	public Empleado() {
		
	}
	public Empleado(String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate ingreso) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.ingreso = ingreso;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}
	protected void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public LocalDate getIngreso() {
		return ingreso;
	}
	public void setIngreso(LocalDate ingreso) {
		this.ingreso = ingreso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (dni ^ (dni >>> 32));
		result = prime * result + idEmpleado;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (dni != other.dni)
			return false;
		if (idEmpleado != other.idEmpleado)
			return false;
		return true;
	}
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Empleado {\n");
	    sb.append("  idEmpleado: ").append(idEmpleado).append(",\n");
	    sb.append("  nombre: ").append(nombre).append(",\n");
	    sb.append("  apellido: ").append(apellido).append(",\n");
	    sb.append("  dni: ").append(dni).append(",\n");
	    sb.append("  fechaNacimiento: ").append(fechaNacimiento).append(",\n");
	    sb.append("  ingreso: ").append(ingreso).append("\n");
	    sb.append("}");
	    return sb.toString();
	}
}