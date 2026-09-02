package test;

import java.util.List;

import datos.ItemPedido;
import datos.Pedido;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;

public class TestPlatosPorPedido {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PedidoABM pedidoABM = new PedidoABM();
		ItemPedidoABM itemABM = new ItemPedidoABM();

		Pedido pedido = pedidoABM.traer(2);

		List<ItemPedido> items = itemABM.traer(pedido);

		for (ItemPedido item : items) {
		    System.out.println("Plato: " + item.getPlato().getNombre() +  "- " + item.getPlato().getPrecioDeVenta());
		    System.out.println("Cantidad: " + item.getCantidad());
		}
	}

}
