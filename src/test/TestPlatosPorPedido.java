package test;

import java.util.List;

import datos.ItemPedido;
import datos.Pedido;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;

public class TestPlatosPorPedido {

    public static void main(String[] args) {

        PedidoABM pedidoABM = new PedidoABM();
        ItemPedidoABM itemABM = new ItemPedidoABM();

        // Buscar el pedido con ID 2
        Pedido pedido = pedidoABM.traer(2);

        // Verificar que el pedido exista
        if (pedido == null) {
            System.out.println("No existe un pedido con ID 2.");
            return;
        }

        // Traer los items correspondientes al pedido
        List<ItemPedido> items = itemABM.traer(pedido);

        // Mostrar los platos del pedido
        for (ItemPedido item : items) {
            System.out.println(
                "Plato: " + item.getPlato().getNombre()
                + " - Precio: " + item.getPlato().getPrecioDeVenta()
            );

            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("-------------------------");
        }
    }
}


