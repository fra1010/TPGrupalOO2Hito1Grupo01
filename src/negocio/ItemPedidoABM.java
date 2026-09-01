package negocio;

import java.util.List;

import dao.ItemPedidoDao;
import datos.ItemPedido;
import datos.Pedido;
import datos.Plato;

public class ItemPedidoABM {
	
	ItemPedidoDao dao = new ItemPedidoDao();

	public ItemPedido traer(int idItemPedido) {
		return dao.traer(idItemPedido);
	}

	public int agregar(Plato plato, Pedido pedido, int cantidad) {
		// Pendiente implementar lógica de negocio
		ItemPedido i = new ItemPedido(plato, pedido, cantidad);
		return dao.agregar(i);
	}

	public void modificar(ItemPedido i) {
		// Pendiente implementar lógica de negocio
		dao.actualizar(i);
	}

	public void eliminar(int idItemPedido) {
		// Pendiente implementar lógica de negocio
		ItemPedido i = dao.traer(idItemPedido);
		dao.eliminar(i);
	}

	public List<ItemPedido> traer() {
		return dao.traer();
	}
	
	public List<ItemPedido> traer(Pedido pedido) {
	    return dao.traer(pedido);
	}
	
	public List<ItemPedido> traer(Plato plato) {
	    return dao.traer(plato);
	}
}
