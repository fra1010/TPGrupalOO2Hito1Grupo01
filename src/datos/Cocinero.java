package datos;

import java.time.LocalDate;

public class Cocinero extends Empleado{

	private String especialidad;
	
	public Cocinero()
	{
		
	}
	
	public Cocinero(String nombre, String apellido,long dni, LocalDate fechaNacimiento, LocalDate ingreso, String especialidad) 
	{
		super(nombre, apellido, dni, fechaNacimiento,ingreso);
		
		this.especialidad = especialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() 
	{
		return super.toString() + "-----COCINERO [especialidad=" + especialidad + "]\n";
	}
	
}


