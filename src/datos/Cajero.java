package datos;

public class Cajero extends Empleado {

	private String turno;
	
	public Cajero() {}

	public Cajero(String turno) {
		super();
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Cajero [turno=" + turno + "]";
	}
	
	
	
}
