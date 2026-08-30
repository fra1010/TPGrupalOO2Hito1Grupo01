package datos;

import java.time.LocalDate;

public class Pedido {

	private int idPedido;
	private LocalDate fechaTransaccion;
	private UnidadVenta unidad;
	public Pedido() {
		
	}
	public Pedido(LocalDate fechaTransaccion, UnidadVenta unidad) {
		super();
		this.fechaTransaccion = fechaTransaccion;
		this.unidad = unidad;
	}
	public int getId() {
		return idPedido;
	}
	protected void setId(int id) {
		this.idPedido = id;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaTransaccion == null) ? 0 : fechaTransaccion.hashCode());
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
		if (fechaTransaccion == null) {
			if (other.fechaTransaccion != null)
				return false;
		} else if (!fechaTransaccion.equals(other.fechaTransaccion))
			return false;
		if (idPedido != other.idPedido)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + idPedido + ", fechaTransaccion=" + fechaTransaccion + "]";
	}
	
	
	
}
