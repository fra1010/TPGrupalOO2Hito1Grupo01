package datos;

public class FoodTruck extends UnidadVenta {
	private long idFoodTruck;
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


	public long getIdFoodTruck() {
		return idFoodTruck;
	}

	public void setIdFoodTruck(long idFoodTruck) {
		this.idFoodTruck = idFoodTruck;
	}

	@Override
	public String toString() {
		return "FoodTruck [idFoodTruck=" + idFoodTruck + ", patente=" + patente + ", conexion=" + conexion + "]";
	}
	
	
	

}
