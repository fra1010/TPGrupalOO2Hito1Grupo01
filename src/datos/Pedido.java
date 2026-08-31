package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {
	private int idPedido;
	private LocalDate fechaTransaccion;
//	private UnidadVenta unidad;
	private Set<ItemPedido> itemsPedidos;
	
	public Pedido() {
		super();
	}
	
	public Pedido(LocalDate fechaTransaccion) {
		super();
		this.fechaTransaccion = fechaTransaccion;
//		this.unidad = unidad;
	}

	public int getIdPedido() {
		return idPedido;
	}

	protected void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

/*	public UnidadVenta getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadVenta unidad) {
		this.unidad = unidad;
	}
*/
	public Set<ItemPedido> getItemsPedidos() {
		return itemsPedidos;
	}

	public void setItemsPedidos(Set<ItemPedido> itemsPedidos) {
		this.itemsPedidos = itemsPedidos;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaTransaccion=" + fechaTransaccion + "]";
	}
	

}
