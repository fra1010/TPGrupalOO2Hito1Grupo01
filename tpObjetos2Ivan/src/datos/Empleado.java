package datos;

import java.time.LocalDate;

public abstract class Empleado {

	protected int idEmpleado;
	protected String nombre;
	protected String apellido;
	protected int dni;
	protected LocalDate fechaDeNacimiento;
	protected LocalDate ingreso;
	protected double sueldo;
	
	public Empleado() {
		
	}

	public Empleado(int idEmpleado, String nombre, String apellido, int dni, LocalDate fechaDeNacimiento,
			LocalDate ingreso, double sueldo) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.ingreso = ingreso;
		this.sueldo = sueldo;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
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

	public int getDni() {
		return dni;
	}

	protected void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	protected void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public LocalDate getIngreso() {
		return ingreso;
	}

	protected void setIngreso(LocalDate ingreso) {
		this.ingreso = ingreso;
	}

	public double getSueldo() {
		return sueldo;
	}

	protected void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", ingreso=" + ingreso + ", sueldo=" + sueldo + "]\n";
	}
	
}
