package datos;

public class Cajero extends Empleado {
	private long idCajero;
	private String turno;
	
	public Cajero() {}

	public Cajero(String turno) {
		super();
		this.turno = turno;
	}

	
	public long getIdCajero() {
		return idCajero;
	}

	public void setIdCajero(long idCajero) {
		this.idCajero = idCajero;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Cajero [idCajero=" + idCajero + ", turno=" + turno + "]";
	}
	
	
	
}
