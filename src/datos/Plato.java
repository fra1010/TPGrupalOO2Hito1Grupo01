package datos;


public class Plato {

	private int idPlato;
	private String nombre;
	private double precioDeVenta;
	private double costoDePlato;
	private UnidadVenta unidad;
	
	public Plato() {
		super();
	}

	public Plato(String nombre, double precioDeVenta, double costoDePlato, UnidadVenta unidad) {
		super();
		this.nombre = nombre;
		this.precioDeVenta = precioDeVenta;
		this.costoDePlato = costoDePlato;
		this.unidad = unidad;
	}

	public int getIdPlato() {
		return idPlato;
	}

	protected void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
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

	public UnidadVenta getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadVenta unidad) {
		this.unidad = unidad;
	}
	
	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precioDeVenta=" + precioDeVenta
				+ ", costoDePlato=" + costoDePlato + "]";
	}
}
