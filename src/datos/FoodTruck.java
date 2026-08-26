package datos;

public class FoodTruck extends UnidadVenta {
	
	private String patente;
	private boolean conexion;
	
	public FoodTruck() {}

	public FoodTruck(String patente, boolean conexion) {
		super();
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
		return "FoodTruck [patente=" + patente + ", conexion=" + conexion + "]";
	}
	
	

}
