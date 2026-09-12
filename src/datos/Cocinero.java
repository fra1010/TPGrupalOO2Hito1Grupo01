package datos;

import java.time.LocalDate;

public class Cocinero extends Empleado{

	private String especialidad;
	private String categoria;
	private int porcentaje;
	
	public Cocinero()
	{
		
	}
	
	public Cocinero(String nombre, String apellido,long dni, LocalDate fechaNacimiento, LocalDate ingreso, 
			         String especialidad, String categoria,int porcentaje) 
	{
		super(nombre, apellido, dni, fechaNacimiento,ingreso);
		
		this.especialidad = especialidad;
		this.categoria = categoria;
		this.porcentaje = porcentaje;
		
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public String toString() {
		return super.toString() + "----COCINERO [especialidad=" + especialidad + ", categoria=" 
								+ categoria + ", porcentaje=" + porcentaje + "]\n";
	}
	
}

