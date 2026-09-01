package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {

	private int idPedido;
	private LocalDate fechaTransaccion;
	private UnidadVenta unidad;
	private Set<ItemPedido> pedidos;

	public Pedido() {

	}

	public Pedido(LocalDate fechaTransaccion, UnidadVenta unidad) {
		super();
		this.fechaTransaccion = fechaTransaccion;
		this.unidad = unidad;
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

	public UnidadVenta getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadVenta unidad) {
		this.unidad = unidad;
	}

	public Set<ItemPedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<ItemPedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPedido;
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
		Pedido other = (Pedido) obj;
		if (idPedido != other.idPedido)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaTransaccion=" + fechaTransaccion + ", unidad=" + unidad + "]";
	}
	
	public double calcularTotal() {
		double total=0;
		
		for (ItemPedido itemPedido : pedidos) {
			total= total + itemPedido.calcularSubTotal();
		}
		return total;
	}
}
