package datos;

import java.util.Set;

public class Plato {
	private long idPlato;
	private String nombre;
	private double precioDeVenta;
	private double costoDePlato;
	private Set<ItemPedido> itemsPedidos;
	public Plato() {
	}

	public Plato(String nombre, double precioDeVenta, double costoDePlato) {

		this.nombre = nombre;
		this.precioDeVenta = precioDeVenta;
		this.costoDePlato = costoDePlato;
	}


	public long getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(long idPlato) {
		this.idPlato = idPlato;
	}

	public Set<ItemPedido> getItemsPedidos() {
		return itemsPedidos;
	}

	public void setItemsPedidos(Set<ItemPedido> itemsPedidos) {
		this.itemsPedidos = itemsPedidos;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(costoDePlato);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (idPlato ^ (idPlato >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		temp = Double.doubleToLongBits(precioDeVenta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plato other = (Plato) obj;
		if (Double.doubleToLongBits(costoDePlato) != Double.doubleToLongBits(other.costoDePlato))
			return false;
		if (idPlato != other.idPlato)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precioDeVenta) != Double.doubleToLongBits(other.precioDeVenta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Plato [id=" + idPlato + ", nombre=" + nombre + ", precioDeVenta=" + precioDeVenta + ", costoDePlato="
				+ costoDePlato + "]";
	}

	
}
