package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PedidoDao;
import datos.Pedido;

public class PedidoABM {
	
	PedidoDao dao = new PedidoDao();

	public Pedido traer(int idPedido) {
		return dao.traer(idPedido);
	}

	public int agregar(LocalDate fechaDeTransaccion) {
		// Pendiente implementar lógica de negocio
		Pedido p = new Pedido(fechaDeTransaccion);
		return dao.agregar(p);
	}

	public void modificar(Pedido p) {
		// Pendiente implementar lógica de negocio
		dao.actualizar(p);
	}

	public void eliminar(int idPedido) {
		// Pendiente implementar lógica de negocio
		Pedido p = dao.traer(idPedido);
		dao.eliminar(p);
	}

	public List<Pedido> traer() {
		return dao.traer();
	}
	
	public Pedido traerPedidoEItems(int idPedido) {
		return dao.traerPedidoEItems(idPedido);
	}
}
