package datos;

import java.time.LocalDate;

public class Cajero extends Empleado
{
	private String turno;

	public Cajero() 
	{
		
	}
	
	public Cajero(String nombre, String apellido,long dni, LocalDate fechaNacimiento, LocalDate ingreso,String turno) 
	{
		super(nombre,apellido,dni,fechaNacimiento,ingreso);
		this.turno = turno;
	}

	public String getTurno() 
	{
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return super.toString() + "Cajero [turno=" + turno + "]\n";
	}
}
