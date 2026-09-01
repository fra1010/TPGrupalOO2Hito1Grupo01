package datos;

public class ItemPedido {
	private int idItemPedio;
	private Plato plato;
	private int cantidad;

	public ItemPedido() {
		super();
	}

	public ItemPedido(Plato plato, int cantidad) {
		super();
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public int getIdItemPedio() {
		return idItemPedio;
	}

	protected void setIdItemPedio(int idItemPedio) {
		this.idItemPedio = idItemPedio;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idItemPedio;
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
		ItemPedido other = (ItemPedido) obj;
		if (idItemPedio != other.idItemPedio)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemPedido [idItemPedio=" + idItemPedio + ", plato=" + plato + ", cantidad=" + cantidad + "]";
	}
	public double calcularSubTotal() {
		
		return this.cantidad * this.plato.getPrecioDeVenta();
	}
}
