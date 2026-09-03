package datos;


public class Plato {

	private int idPlato;
	private String nombre;
	private double precioDeVenta;
	private double costoDePlato;
	private UnidadVenta unidadVenta;
	public Plato() {
		super();
	}
	public Plato(String nombre, double precioDeVenta, double costoDePlato,UnidadVenta unidadVenta) {
		super();
		this.nombre = nombre;
		this.precioDeVenta = precioDeVenta;
		this.costoDePlato = costoDePlato;
		this.unidadVenta=unidadVenta;
	}
	public Plato(String nombre, double precioDeVenta, double costoDePlato) {
		super();
		this.nombre = nombre;
		this.precioDeVenta = precioDeVenta;
		this.costoDePlato = costoDePlato;
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

	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}
	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}
	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precioDeVenta=" + precioDeVenta
				+ ", costoDePlato=" + costoDePlato + "]";
	}
	
}
