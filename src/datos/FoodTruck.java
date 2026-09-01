package datos;

public class FoodTruck extends UnidadVenta{
	private String patente;
	private boolean conexion;
	
	public FoodTruck() {
		super();
	}

	public FoodTruck(String nombre, Empleado responsable, double superficie, String codigo, String patente,
			boolean conexion) {
		super(nombre, responsable, superficie, codigo);
		this.patente = patente;
		this.conexion = conexion;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public boolean isConexion() {
		return conexion;
	}

	public void setConexion(boolean conexion) {
		this.conexion = conexion;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("FoodTruck \n");
	    sb.append("  idUnidadVenta: ").append(idUnidadVenta).append(",\n");
	    sb.append("  nombre: ").append(nombre).append(",\n");
	    sb.append("  responsable: ").append(responsable).append(",\n");
	    sb.append("  superficie: ").append(superficie).append(",\n");
	    sb.append("  codigo: ").append(codigo).append(",\n");
	    sb.append("  patente: ").append(patente).append(",\n");
	    sb.append("  conexion: ").append(conexion).append("\n");
	    sb.append(" ");
	    return sb.toString();
	}
}

