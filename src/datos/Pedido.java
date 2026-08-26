package datos;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
	private long idPedido;
	private LocalDate fechaTransaccion;
	private Festival festival;
	private UnidadVenta unidad;
	private List<ItemPedido>itemsPedido;
	
	public Pedido() {}

	public Pedido(LocalDate fechaTransaccion, Festival festival, UnidadVenta unidad, List<ItemPedido> itemsPedido) {
		super();
		this.fechaTransaccion = fechaTransaccion;
		this.festival = festival;
		this.unidad = unidad;
		this.itemsPedido = itemsPedido;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public UnidadVenta getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadVenta unidad) {
		this.unidad = unidad;
	}

	public List<ItemPedido> getItemsPedido() {
		return itemsPedido;
	}

	public void setItemsPedido(List<ItemPedido> itemsPedido) {
		this.itemsPedido = itemsPedido;
	}


	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaTransaccion=" + fechaTransaccion + ", festival=" + festival
				+ ", unidad=" + unidad + ", itemsPedido=" + itemsPedido + "]";
	}
	
	
	
}
