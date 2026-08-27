package datos;

public class Cajero extends Empleado{

	private String turno;

	public Cajero() {
		
	}
	
	public Cajero(String turno) {
		super();
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
		return super.toString() + "Cajero [turno=" + turno + "]";
	}
	
	
	
	
}
