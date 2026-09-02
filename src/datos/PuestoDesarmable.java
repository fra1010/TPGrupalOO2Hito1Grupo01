package datos;

public class PuestoDesarmable extends UnidadVenta {
	private int cantidadCarpas;
	private int tiempo;

	public PuestoDesarmable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PuestoDesarmable(String nombre, Empleado responsable, double superficie, String codigo, int cantidadCarpas,
			int tiempo) {
		super(nombre, responsable, superficie, codigo);
		this.cantidadCarpas = cantidadCarpas;
		this.tiempo = tiempo;
	}

	public int getCantidadCarpas() {
		return cantidadCarpas;
	}

	public void setCantidadCarpas(int cantidadCarpas) {
		this.cantidadCarpas = cantidadCarpas;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PuestoDesarmable \n");
		sb.append("  idUnidadVenta: ").append(idUnidadVenta).append(",\n");
		sb.append("  nombre: ").append(nombre).append(",\n");
		sb.append("  responsable: ").append(responsable).append(",\n");
		sb.append("  superficie: ").append(superficie).append(",\n");
		sb.append("  codigo: ").append(codigo).append(",\n");
		sb.append("  cantidadCarpas: ").append(cantidadCarpas).append(",\n");
		sb.append("  tiempo: ").append(tiempo).append("\n");
		sb.append(" ");
		return sb.toString();
	}

}