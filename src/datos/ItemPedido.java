package datos;

public class ItemPedido {

	private int idItemPedido;
	private Plato plato;
	private Pedido pedido;
	private int cantidad;
	
	public ItemPedido() {
		super();
	}

	public ItemPedido(Plato plato, Pedido pedido, int cantidad) {
		super();
		this.plato = plato;
		this.pedido = pedido;
		this.cantidad = cantidad;
	}

	public int getIdItemPedido() {
		return idItemPedido;
	}

	protected void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ItemPedido [idItemPedido=" + idItemPedido  + ", cantidad=" + cantidad + "]";
	}
	
}
