package datos;

public class PuestoDesarmable extends UnidadVenta {

	private int cantidadCarpas;
	private int tiempo;
	
	public PuestoDesarmable() {}

	public PuestoDesarmable(int cantidadCarpas, int tiempo) {
		super();
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
		return "PuestoDesarmable [cantidadCarpas=" + cantidadCarpas + ", tiempo=" + tiempo + "]";
	}
	
	
	
}
