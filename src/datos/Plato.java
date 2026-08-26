package datos;

public class Plato {
	private long idPlato;
	private String nombre;
	private double precioDeVenta;
	private double costoDePlato;
	
	public Plato() {}

	public Plato(String nombre, double precioDeVenta, double costoDePlato) {
		super();
		this.nombre = nombre;
		this.precioDeVenta = precioDeVenta;
		this.costoDePlato = costoDePlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioDeVenta() {
		return precioDeVenta;
	}

	public void setPrecioDeVenta(double precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}

	public double getCostoDePlato() {
		return costoDePlato;
	}

	public void setCostoDePlato(double costoDePlato) {
		this.costoDePlato = costoDePlato;
	}

	public long getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(long idPlato) {
		this.idPlato = idPlato;
	}

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precioDeVenta=" + precioDeVenta
				+ ", costoDePlato=" + costoDePlato + "]";
	}
	
	

}
