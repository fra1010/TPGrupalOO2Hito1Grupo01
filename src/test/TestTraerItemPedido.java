package test;

import java.util.List;

import datos.ItemPedido;
import negocio.ItemPedidoABM;

public class TestTraerItemPedido {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ItemPedidoABM itemABM = new ItemPedidoABM();
		
		List<ItemPedido> items = itemABM.traer();
		
		for (ItemPedido item : items) {
		    System.out.println("Pedido " + item.getPedido().getIdPedido() + " - Plato: " + item.getPlato().getNombre() + " - Cantidad: " + item.getCantidad());
		}
		
	}

}
