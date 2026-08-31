package datos;

import java.time.LocalDate;

public class Cajero extends Empleado {
	private String turno;

	public Cajero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cajero(String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate ingreso,
			String turno) {
		super(nombre, apellido, dni, fechaNacimiento, ingreso);
		this.turno = turno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Cajero {\n");
	    sb.append("  id: ").append(idEmpleado).append(",\n");
	    sb.append("  nombre: ").append(nombre).append(",\n");
	    sb.append("  apellido: ").append(apellido).append(",\n");
	    sb.append("  dni: ").append(dni).append(",\n");
	    sb.append("  fechaNacimiento: ").append(fechaNacimiento).append(",\n");
	    sb.append("  ingreso: ").append(ingreso).append(",\n");
	    sb.append("  turno: ").append(turno).append("\n");
	    sb.append("}");
	    return sb.toString();
	}

	
	
	

}
