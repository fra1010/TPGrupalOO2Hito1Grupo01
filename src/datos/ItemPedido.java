package datos;

public class ItemPedido {
	private int idItemPedido;
	private Pedido pedido;
	private Plato plato;
	private int cantidad;


	public ItemPedido() {
		super();
	}



	public ItemPedido(Pedido pedido, Plato plato, int cantidad) {
		super();
		this.pedido = pedido;
		this.plato = plato;
		this.cantidad = cantidad;
	}



	public int getIdItemPedido() {
		return idItemPedido;
	}



	protected void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}



	public Pedido getPedido() {
		return pedido;
	}



	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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



	public double calcularSubTotal() {
		
		return this.cantidad * this.plato.getPrecioDeVenta();
	}
}
