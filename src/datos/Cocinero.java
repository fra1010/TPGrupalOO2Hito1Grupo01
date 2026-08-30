package datos;

import java.time.LocalDate;

public class Cocinero extends Empleado {
	private String especialidad;

	
	public Cocinero() {
		
	}


	public Cocinero(String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate ingreso,
			String especialidad) {
		super(nombre, apellido, dni, fechaNacimiento, ingreso);
		this.especialidad = especialidad;
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Cocinero \n");
	    sb.append("  especialidad: ").append(especialidad).append(",\n");
	    sb.append("  id: ").append(idEmpleado).append(",\n");
	    sb.append("  nombre: ").append(nombre).append(",\n");
	    sb.append("  apellido: ").append(apellido).append(",\n");
	    sb.append("  dni: ").append(dni).append(",\n");
	    sb.append("  fechaNacimiento: ").append(fechaNacimiento).append(",\n");
	    sb.append("  ingreso: ").append(ingreso).append("\n");
	    sb.append("");
	    return sb.toString();
	}
	
	
	
	

}
