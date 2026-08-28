package datos;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Empleado {

	protected int idEmpleado;
	protected String nombre;
	protected String apellido;
	protected long dni;
	protected LocalDate fechaNacimiento;
	protected LocalDate ingreso;
	
	public Empleado() 
	{
		
	}

	public Empleado(String nombre, String apellido,long dni, LocalDate fechaNacimiento, LocalDate ingreso) 
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.ingreso = ingreso;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	protected void setIdEmpleado(int id) {
		this.idEmpleado = id;
	}

	public String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	protected void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	protected void setDni(long dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	protected void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getIngreso() {
		return ingreso;
	}

	protected void setIngreso(LocalDate ingreso) {
		this.ingreso = ingreso;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
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
		return dni == other.dni;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaDeNacimiento=" + fechaNacimiento + ", ingreso=" + ingreso + "]\n";
	}
	
}
