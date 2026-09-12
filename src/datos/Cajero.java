package datos;

import java.time.LocalDate;

public class Cajero extends Empleado
{
	private String turno;
	private double plusAntiguedad;
	public Cajero() 
	{
		
	}
	
	public Cajero(String nombre, String apellido,long dni, LocalDate fechaNacimiento, LocalDate ingreso,String turno) 
	{
		super(nombre,apellido,dni,fechaNacimiento,ingreso);
		this.turno = turno;
	}
	
	public Cajero(String nombre, String apellido, long dni, LocalDate fechaNacimiento, LocalDate ingreso, String turno,
			double plusAntiguedad) {
		super(nombre, apellido, dni, fechaNacimiento, ingreso);
		this.turno = turno;
		this.plusAntiguedad = plusAntiguedad;
	}

	public String getTurno() 
	{
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public double getPlusAntiguedad() {
		return plusAntiguedad;
	}

	public void setPlusAntiguedad(double plusAntiguedad) {
		this.plusAntiguedad = plusAntiguedad;
	}

	@Override
	public String toString() 
	{
		return super.toString() + "CAJERO [turno=" + turno + "]\n";
	}
}
